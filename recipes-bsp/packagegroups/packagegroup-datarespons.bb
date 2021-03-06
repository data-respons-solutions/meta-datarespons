SUMMARY = "Standard packages for Data Respons"
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
	packagegroup-datarespons-base \
	packagegroup-datarespons-utils \
	packagegroup-datarespons-policy \
	packagegroup-datarespons-core \
	packagegroup-datarespons-io \
	packagegroup-datarespons-developer \
	packagegroup-datarespons-net \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-datarespons-pcbios', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'packagegroup-datarespons-efi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'vfat', 'packagegroup-datarespons-vfat', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'ext2', 'packagegroup-datarespons-ext', '',d)} \
"

RDEPENDS_packagegroup-datarespons-base = "\
	packagegroup-datarespons-core \
	packagegroup-datarespons-net \
	packagegroup-datarespons-utils \
	packagegroup-datarespons-policy \
	packagegroup-datarespons-io \
	${@bb.utils.contains('MACHINE_FEATURES', 'pcbios', 'packagegroup-datarespons-pcbios', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'packagegroup-datarespons-efi', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', '3g', 'packagegroup-datarespons-cellular', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'gps', 'packagegroup-datarespons-gps', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'tpm2', 'packagegroup-datarespons-tpm2', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'screen', 'packagegroup-datarespons-screen', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'wifi', 'packagegroup-datarespons-wifi', '',d)} \
	${@bb.utils.contains('COMBINED_FEATURES', 'bluetooth', 'packagegroup-datarespons-bt', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'vfat', 'packagegroup-datarespons-vfat', '',d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'ext2', 'packagegroup-datarespons-ext', '',d)} \
"
RDEPENDS_packagegroup-datarespons-utils = "\
	dr-emergency \
	dr-runlevel \
	nvram \
	nvram-hostname \
"

RDEPENDS_packagegroup-datarespons-policy = "\
	sysctl-rp-filter \
"

RDEPENDS_packagegroup-datarespons-tpm2 = "\
    ibmtpm20tss \
    tpm2-conf \
"
	
RDEPENDS_packagegroup-datarespons-io = "\
	libiio \
	libiio-tests \
	libiio-python3 \
"

RDEPENDS_packagegroup-datarespons-core = "\
	bash-completion \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-bash-completion', '',d)} \	
	findutils \
	glibc-localedata-i18n \
	glibc-localedata-posix \
	less \
	bc \
	tar \
	bzip2 \
	gzip \
	util-linux-uuidgen \
	util-linux \
	tzdata \
	iputils \
	procps \
	dbus \	
	login-environment \
"

RDEPENDS_packagegroup-datarespons-developer = "\
	gdb \
	strace \
	ldd \
"

RDEPENDS_packagegroup-datarespons-net = "\
	networkmanager \
	networkmanager-nmcli \
	networkmanager-bash-completion \
	ethtool \
"

RDEPENDS_packagegroup-datarespons-wifi = "\
	wpa-supplicant \
	wpa-supplicant-cli \
	wpa-supplicant-passphrase \
	iw \
	rfkill \
"
RDEPENDS_packagegroup-datarespons-cellular = "\
	modemmanager \
	modemmanager-bash-completion \
	rfkill \
"
    
RDEPENDS_packagegroup-datarespons-bt = "\
	bluez5 \
	bluez5-noinst-tools \
	bluez5-testtools \
	rfkill \
"
	
RDEPENDS_packagegroup-datarespons-gps = "\
	gpsd \
	gpsd-conf \
	gps-utils \
	gpsd-gpsctl \
	libgps \
"

RDEPENDS_packagegroup-datarespons-screen = "\
	weston \
	weston-xwayland \
	weston-init \
	weston-examples \
	xterm \
	fbtest \
	glmark2 \
	${@bb.utils.contains('MACHINE_FEATURES', 'touchscreen', 'libinput libinput-bin', '',d)} \
"

RDEPENDS_packagegroup-datarespons-efi = "\
	efitools \
	login-secureboot-check \
	efibootmgr \
	efivar \
"

RDEPENDS_packagegroup-datarespons-pcbios = "\
	dmidecode \
"

RDEPENDS_packagegroup-datarespons-vfat = "\
	dosfstools \
"

RDEPENDS_packagegroup-datarespons-ext2 = "\
	e2fsprogs \
"
