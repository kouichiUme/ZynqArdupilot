#
# This file is the ardu recipe.
#

SUMMARY = "Simple ardu application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# fetch from github url
# https://github.com/ArduPilot/ardupilot.git
# git clone --recurse-submodules https://github.com/your-github-userid/ardupilot
# cd ardupilot
# Tools/environment_install/install-prereqs-ubuntu.sh -y
# reload configuration

# . ~/.profile
# git://github.com/sckulkarni246/yocto-test-apps;protocol=https
SRCREV="6dcaf94c3d89a844769bf2237db8fd1520dd4304"
SRC_URI = "git://github.com/ArduPilot/ardupilot.git;protocol=https"
SRC_URI[sha256sum] = "5638e56615fafb0e26e5183dfef2beed0bb21f8bc298e19f29b1a00ea4321db2"
S = "${WORKDIR}"

IMAGE_INSTALL += "empy"

do_configure() {
	cd ${WORKDIR}/git
	git submodule update --init --recursive
	./waf configure --board=zynq --static
}

do_compile() {
	cd ${WORKDIR}/git
	/usr/bin/env python3 -m pip install empy pexpect future
	./waf build 
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 ardu ${D}${bindir}
}
