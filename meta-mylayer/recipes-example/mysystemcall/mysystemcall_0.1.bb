DESCRIPTION = "Simple.recipe of a system call"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://mysystemcall.c"

S = "${WORKDIR}"

RDEPENDS:${PN} = "pciutils"

do_compile(){
    ${CC} mysystemcall.c ${LDFLAGS} -o mysystemcall
}

do_install(){
    install -d ${D}${bindir}
    install -m 0755 mysystemcall ${D}${bindir}
}
