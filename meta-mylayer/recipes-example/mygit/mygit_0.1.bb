DESCRIPTION = "Simple hello world application from git repository"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/maherme/simple-c-app.git;protocol=https;branch=master \
           file://0001-main.c.patch"
S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"

do_compile(){
    ${CC} main.c -o userprog3 ${LDFLAGS}
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 userprog3 ${D}${bindir}
}
