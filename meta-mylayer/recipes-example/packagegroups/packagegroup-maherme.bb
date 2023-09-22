SUMMARY = "Maherme Package Group"

inherit packagegroup

RDEPENDS:${PN} = "util-linux \
                  pciutils \
                  usbutils"

RRECOMMENDS:${PN} = "lshw"
