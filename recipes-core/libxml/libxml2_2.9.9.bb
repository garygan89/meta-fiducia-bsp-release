SUMMARY = "libxml2"
DESCRIPTION = "libxml2"
HOMEPAGE = "http://xmlsoft.org/sources/libxml2-2.9.9.tar.gz"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=2044417e2e5006b65a8b9067b683fcf1"
SECTION = "console/network"
PRIORITY = "optional"
PV = "2.9.9"
PR = "r1"
DEFAULT_PREFERENCE = "1"

SRC_URI = "http://xmlsoft.org/sources/libxml2-${PV}.tar.gz \
           file://python-sitepackages-dir.patch \
           "

SRC_URI[md5sum] = "c04a5a0a042eaa157e8e8c9eabe76bd6"
SRC_URI[sha256sum] = "94fb70890143e3c6549f265cee93ec064c80a84c42ad0f23e85ee1fd6540a871"

BINCONFIG = "${bindir}/xml2-config"

PACKAGECONFIG ??= "python \
    ${@bb.utils.filter('DISTRO_FEATURES', 'ipv6', d)} \
"

PACKAGECONFIG[python] = "--with-python=${PYTHON},--without-python,python3"
PACKAGECONFIG[ipv6] = "--enable-ipv6,--disable-ipv6,"

inherit autotools pkgconfig binconfig-disabled ptest

inherit ${@bb.utils.contains('PACKAGECONFIG', 'python', 'python3native', '', d)}

export PYTHON_SITE_PACKAGES="${PYTHON_SITEPACKAGES_DIR}"

DEPENDS = "zlib virtual/libiconv"

EXTRA_OECONF = "--prefix=${prefix}"

PACKAGES += "${PN}-utils ${PN}-python"

FILES_${PN}-staticdev += "${PYTHON_SITEPACKAGES_DIR}/*.a"
FILES_${PN}-dev += "${libdir}/xml2Conf.sh ${libdir}/cmake/*"
FILES_${PN}-utils += "${bindir}/*"
FILES_${PN}-python += "${PYTHON_SITEPACKAGES_DIR}"
