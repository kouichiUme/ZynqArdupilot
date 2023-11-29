FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://bsp.cfg"
KERNEL_FEATURES:append = " bsp.cfg"
SRC_URI += "file://user_2023-10-01-10-50-00.cfg \
            file://user_2023-10-04-16-01-00.cfg \
            file://user_2023-10-22-11-24-00.cfg \
            file://user_2023-10-22-18-51-00.cfg \
            "

