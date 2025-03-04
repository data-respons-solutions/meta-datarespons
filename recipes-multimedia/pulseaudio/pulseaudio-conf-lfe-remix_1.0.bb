LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://lfe-remix.conf"

do_install () {
	install -d ${D}${sysconfdir}/pulse/daemon.conf.d
	install -m 0644 ${WORKDIR}/lfe-remix.conf ${D}${sysconfdir}/pulse/daemon.conf.d/
}

FILES:${PN} += "${sysconfdir}/pulse/daemon.conf.d/"
