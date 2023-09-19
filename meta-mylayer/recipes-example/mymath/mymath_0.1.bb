DESCRIPTION = "Simple application for using my dynamic library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://calculator.c"

DEPENDS = "mystatic mydynamic"

S = "${WORKDIR}"

LDFLAGS += "-lmymath -lmymath2"

do_compile(){
    ${CC} calculator.c ${LDFLAGS} -o calculator
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 calculator ${D}${bindir}
}
