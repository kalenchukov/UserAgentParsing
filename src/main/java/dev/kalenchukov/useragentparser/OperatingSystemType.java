/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных операционных систем.
 */
enum OperatingSystemType
{
	UNKNOWN(
		null,
		null
	),

	WINDOWS(
		"1",
		"Windows"
	),

	KUBUNTU(
		"2",
		"Kubuntu"
	),

	MAC_OS_X(
		"3",
		"Mac OS X"
	),

	MAC_OS_9(
		"4",
		"Mac OS 9"
	),

	ANDROID(
		"5",
		"Android"
	),

	IOS(
		"6",
		"iOS"
	),

	LINUX(
		"7",
		"Linux"
	),

	UBUNTU(
		"8",
		"Ubuntu"
	),

	MANDRIVA_LINUX(
		"9",
		"Mandriva Linux"
	),

	ASPLINUX(
		"10",
		"ASPLinux"
	),

	OPENSUSE(
		"11",
		"OpenSUSE"
	),

	BADA(
		"12",
		"Bada"
	),

	CHROME_OS(
		"13",
		"Chrome OS"
	),

	DARWIN(
		"14",
		"Darwin"
	),

	NETBSD(
		"15",
		"NetBSD"
	),

	BLACKBERRY_OS(
		"16",
		"BlackBerry OS"
	),

	AMIGAOS(
		"17",
		"AmigaOS"
	),

	HAIKU(
		"18",
		"Haiku"
	),

	WINDOWS_MOBILE(
		"19",
		"Windows Mobile"
	),

	WINDOWS_PHONE(
		"20",
		"Windows Phone"
	),

	SYMBIAN_OS(
		"21",
		"Symbian OS"
	),

	SOLARIS(
		"22",
		"Solaris"
	),

	WINDOWS_CE(
		"23",
		"Windows CE"
	),

	BEOS(
		"24",
		"BeOS"
	),

	FEDORA(
		"25",
		"Fedora"
	),

	OPENBSD(
		"26",
		"OpenBSD"
	),

	LINUX_MINT(
		"27",
		"Linux Mint"
	),

	FREEBSD(
		"28",
		"FreeBSD"
	),

	LINUX_GENTOO(
		"29",
		"Linux Gentoo"
	),

	SLACKWARE_LINUX(
		"30",
		"Slackware Linux"
	),

	MIDP(
		"31",
		"MIDP"
	),

	CENTOS(
		"32",
		"CentOS"
	),

	RED_HAT(
		"33",
		"Red Hat"
	),

	SUNOS(
		"34",
		"SunOS"
	),

	KAIOS(
		"35",
		"KaiOS"
	),

	WEBOS(
		"36",
		"WebOS"
	),

	TV_OS(
		"37",
		"Apple TV OS"
	),

	MAUI(
		"38",
		"MAUI"
	),

	TIZEN(
		"39",
		"Tizen"
	);

	/**
	 * ID операционной системы.
	 */
	@Nullable
	private final String id;

	/**
	 * Название операционной системы.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает ID операционной системы.
	 * Устанавливает название операционной системы.
	 *
	 * @param id ID операционной системы
	 * @param name название операционной системы
	 */
	OperatingSystemType(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	@Nullable
	String getId()
	{
		return this.id;
	}

	@Nullable
	String getName()
	{
		return this.name;
	}
}
