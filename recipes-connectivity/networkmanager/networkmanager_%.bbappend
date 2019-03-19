FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
	file://orange.nmconnection \
	file://chinamobile.nmconnection \
"

do_install_append () {
	install -d ${D}${sysconfdir}/NetworkManager/system-connections
	install -m 0600 ${WORKDIR}/orange.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections
	install -m 0600 ${WORKDIR}/chinamobile.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections
}

FILES_${PN} += "${sysconfdir}/NetworkManager/system-connections"
