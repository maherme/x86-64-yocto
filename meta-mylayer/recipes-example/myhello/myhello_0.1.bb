DESCRIPTION = "Simple hello world application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://userprog.c \
           file://README.txt \
           file://README2.txt"

S = "${WORKDIR}"

do_compile(){
    bbnote "Compilation Started"
    ${CC} userprog.c ${LDFLAGS} -o userprog
    bbnote "Compilation Complete"
}

do_install(){
    bbwarn "Installation Started (this is a test message)"
    install -d ${D}${bindir}
    install -m 0755 userprog ${D}${bindir}
    install -d ${D}${docdir}
    install -m 0644 README.txt ${D}${docdir}
    install -d ${D}/home/root
    install -m 0644 README2.txt ${D}/home/root
    bbwarn "Installation Ended (this is a test message)"
}

FILES:${PN}-maherme += "/home/root/README2.txt"
PACKAGES += "${PN}-maherme"
