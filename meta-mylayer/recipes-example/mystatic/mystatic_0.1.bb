DESCRIPTION = "Simple.static.library.for math operations"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://mymath.c \
           file://mymath.h"

S = "${WORKDIR}"

do_compile(){
    ${CC} mymath.c -c mymath.o
    ${AR} rcs libmymath.a mymath.o
}

do_install(){
    install -d ${D}${libdir}
    install -m 0755 libmymath.a ${D}${libdir}
    install -d ${D}${includedir}
    install -m 0644 mymath.h ${D}${includedir}
}
