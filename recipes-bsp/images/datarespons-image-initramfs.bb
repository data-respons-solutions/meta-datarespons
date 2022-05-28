DESCRIPTION = "Data Respons Image initramfs"

require datarespons-image.bb

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

ROOTFS_POSTPROCESS_COMMAND:append = " remove_kernel_image;"

remove_kernel_image() {
	rm ${IMAGE_ROOTFS}/boot/${KERNEL_IMAGETYPE}*
}
