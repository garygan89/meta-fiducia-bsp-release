SUMMARY = "wget with openssl suppport to download from https sites"
DESCRIPTION = "wget"
HOMEPAGE = "ftp://ftp.gnu.org/gnu/wget/wget-1.20.3.tar.gz"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=c678957b0c8e964aa6c70fd77641a71e"
SECTION = "console/network"
PRIORITY = "optional"
PV = "1.20.3"
PR = "r1"
DEFAULT_PREFERENCE = "1"

SRC_URI = "ftp://ftp.gnu.org/gnu/wget/wget-${PV}.tar.gz"
SRC_URI[md5sum] = "db4e6dc7977cbddcd543b240079a4899"
SRC_URI[sha256sum] = "31cccfc6630528db1c8e3a06f6decf2a370060b982841cfab2b8677400a5092e"

DEPENDS = "openssl"

inherit autotools gettext texinfo update-alternatives pkgconfig

EXTRA_OECONF =	"--prefix=${prefix} \
				--sysconfdir=${sysconfdir} \
				--with-ssl=openssl"
