FROM ubuntu:20.04

# Use DEBIAN_FRONTEND=noninteractive, to avoid image build hang waiting
# for a default confirmation [Y/n] at some configurations.
ENV DEBIAN_FRONTEND=noninteractive

# Keep the dependency list as short as reasonable
RUN apt update
RUN apt install -y gawk wget git diffstat unzip texinfo gcc build-essential chrpath \
    socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping \
    python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint3 xterm python3-subunit \
    mesa-common-dev zstd liblz4-tool locales sudo
#    make python3-pip inkscape texlive-latex-extra
#RUN pip3 install sphinx sphinx_rtd_theme pyyaml

# Set up locales
RUN locale-gen en_US.UTF-8 && update-locale LC_ALL=en_US.UTF-8 \
    LANG=en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8

# Yocto needs 'source' command for setting up the build environment, so replace
# the 'sh' alias to 'bash' instead of 'dash'.
RUN rm /bin/sh && ln -s bash /bin/sh

# Install repo
ADD https://storage.googleapis.com/git-repo-downloads/repo /usr/local/bin/
RUN chmod 755 /usr/local/bin/repo

# Add your user to sudoers to be able to install other packages in the container.
ARG USER
RUN echo "${USER} ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/${USER} && \
    chmod 0440 /etc/sudoers.d/${USER}

# Set the arguments for host_id and user_id to be able to save the build artifacts
# outside the container, on host directories, as docker volumes.
ARG host_uid \
    host_gid
RUN groupadd -g $host_gid nxp && \
    useradd -g $host_gid -m -s /bin/bash -u $host_uid $USER

# Yocto builds should run as a normal user.
USER $USER

ARG DOCKER_WORKDIR
WORKDIR ${DOCKER_WORKDIR}
