DESCRIPTION = "Simple.dynamic.library.for math operations"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://mymath2.c \
           file://mymath2.h"

S = "${WORKDIR}"

do_compile(){
    ${CC} mymath2.c -c -fPIC mymath2.o
    ${CC} ${LDFLAGS} -shared -Wl,-soname,libmymath2.so.1 -o libmymath2.so.1.0 mymath2.o
}

do_install(){
    install -d ${D}${libdir}
    install -m 0755 libmymath2.so.1.0 ${D}${libdir}
    ln -s libmymath2.so.1.0 ${D}${libdir}/libmymath2.so.1
    ln -s libmymath2.so.1 ${D}${libdir}/libmymath2.so
    install -d ${D}${includedir}
    install -m 0644 mymath2.h ${D}${includedir}
}
