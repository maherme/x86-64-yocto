DESCRIPTION = "Simple.recipe of using autotools with GNU hello world"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${WORKDIR}/hello-2.12/COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "https://ftp.gnu.org/gnu/hello/hello-2.12.tar.gz"
SRC_URI[sha256sum] = "cf04af86dc085268c5f4470fbae49b18afbc221b78096aab842d934a76bad0ab"

S = "${WORKDIR}/hello-2.12"

inherit autotools-brokensep gettext

