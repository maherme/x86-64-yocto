DESCRIPTION = "Custom linux kernel recipe"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit kernel

SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v6.x/linux-6.5.4.tar.xz;name=kernel \
           file://defconfig"
SRC_URI[kernel.sha256sum] = "bdf76c15229b241e578046b8486106f09534d754ea4cbf105e0660e551fb1669"

S = "${WORKDIR}/linux-6.5.4"
