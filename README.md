# x86-64-yocto
This repository contains a layer (meta-mylayer) with some recipes as examples about yocto using a x86-64 based machine

# Compiling
You need to add the poky to the same level as [meta-mylayer](meta-mylayer) folder. Be sure you are checked out to the same revision as LAYERSERIES_COMPAT_meta-mylayer is set.
To avoid installing dependencies, there is a [Dockerfile](Dockerfile) for building the yocto image, you can build the docker image using in the root foler of this repository:

```
docker build --tag "yocto" --build-arg "DOCKER_WORKDIR=$(pwd)" --build-arg "USER=$(whoami)" --build-arg "host_uid=$(id -u)" --build-arg "host_gid=$(id -g)" .
```

For running the container use this command:

```
docker run -it --rm -w "$(pwd)" --mount type=bind,src="$(pwd)",dst="$(pwd)" "yocto"
```

For load the yocto build enviroment use this command in the poky directory:

```
source oe-init-build-env ../build
```

For generating the yocto image:

```
bitbake maherme-image
```
