DESCRIPTION = "SSH test key. Private key stored in public repository. Not for production use."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
	file://droot.pub \
"

do_install() {
    install -d -m 700 ${D}/home/root/.ssh
    install -m 0600 ${WORKDIR}/droot.pub ${D}/home/root/.ssh/authorized_keys
}

FILES:${PN} = "/home/root/.ssh/authorized_keys"
