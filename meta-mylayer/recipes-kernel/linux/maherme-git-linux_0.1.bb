DESCRIPTION = "Custom linux kernel recipe"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit kernel

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;branch=master \
           file://defconfig \
           file://0001-my-first-msg.patch"
SRCREV = "v6.4"

S = "${WORKDIR}/git"

PV = "0.1+git${SRCPV}"
