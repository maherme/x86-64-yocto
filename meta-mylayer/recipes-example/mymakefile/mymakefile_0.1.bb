DESCRIPTION = "Simple hello world application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://userprog2.c\
           file://Makefile"

S = "${WORKDIR}"

CLEANBROKEN = "1"

do_install(){
    oe_runmake install DESTDIR=${D}/usr/bin/
}
