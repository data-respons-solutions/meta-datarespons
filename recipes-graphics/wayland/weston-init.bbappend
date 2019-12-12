FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	${@bb.utils.contains('DISTRO_FEATURES', 'systemd wayland', 'file://weston-init.service.in', '', d)} \
"

HAS_SYSTEMD = "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}"

REQUIRED_DISTRO_FEATURES += "pam"

RDEPENDS_${PN} += "weston-check"

do_install_append() {
    if ${HAS_SYSTEMD}; then
        sed -e 's:@bindir@:${bindir}:g' -e 's:@sbindir@:${sbindir}:g' < ${WORKDIR}/weston-init.service.in > ${WORKDIR}/weston-init.service
        install -m 0644 ${WORKDIR}/weston-init.service ${D}${systemd_system_unitdir}/
    fi
}

SYSTEMD_SERVICE_${PN} += "weston-init.service"