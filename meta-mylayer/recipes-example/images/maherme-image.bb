SUMMARY = "A small boot image made by maherme"
LICENSE = "MIT"
inherit core-image

IMAGE_NAME = "maherme-image"

# Core files for basic console boot
IMAGE_INSTALL = "packagegroup-core-boot"

IMAGE_INSTALL += "myhello myhello-doc myhello-maherme mymakefile mygit mystatic-staticdev mydynamic \
                  mydynamic-dev mymath mysystemcall"
