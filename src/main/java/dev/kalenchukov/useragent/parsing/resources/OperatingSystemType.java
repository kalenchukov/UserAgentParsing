/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragent.parsing.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных операционных систем.
 */
public enum OperatingSystemType
{
	UNKNOWN(
		null
	),

	WINDOWS(
		"Windows"
	),

	KUBUNTU(
		"Kubuntu"
	),

	MAC_OS_X(
		"Mac OS X"
	),

	MAC_OS_9(
		"Mac OS 9"
	),

	ANDROID(
		"Android"
	),

	IOS(
		"iOS"
	),

	LINUX(
		"Linux"
	),

	UBUNTU(
		"Ubuntu"
	),

	MANDRIVA_LINUX(
		"Mandriva Linux"
	),

	ASPLINUX(
		"ASPLinux"
	),

	OPENSUSE(
		"OpenSUSE"
	),

	BADA(
		"Bada"
	),

	CHROME_OS(
		"Chrome OS"
	),

	DARWIN(
		"Darwin"
	),

	NETBSD(
		"NetBSD"
	),

	BLACKBERRY_OS(
		"BlackBerry OS"
	),

	AMIGAOS(
		"AmigaOS"
	),

	HAIKU(
		"Haiku"
	),

	WINDOWS_MOBILE(
		"Windows Mobile"
	),

	WINDOWS_PHONE(
		"Windows Phone"
	),

	SYMBIAN_OS(
		"Symbian OS"
	),

	SOLARIS(
		"Solaris"
	),

	WINDOWS_CE(
		"Windows CE"
	),

	BEOS(
		"BeOS"
	),

	FEDORA(
		"Fedora"
	),

	OPENBSD(
		"OpenBSD"
	),

	LINUX_MINT(
		"Linux Mint"
	),

	FREEBSD(
		"FreeBSD"
	),

	LINUX_GENTOO(
		"Linux Gentoo"
	),

	SLACKWARE_LINUX(
		"Slackware Linux"
	),

	MIDP(
		"MIDP"
	),

	CENTOS(
		"CentOS"
	),

	RED_HAT(
		"Red Hat"
	),

	SUNOS(
		"SunOS"
	),

	KAIOS(
		"KaiOS"
	),

	WEBOS(
		"WebOS"
	),

	TV_OS(
		"Apple TV OS"
	),

	MAUI(
		"MAUI"
	),

	TIZEN(
		"Tizen"
	);

	/**
	 * Название операционной системы.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает название операционной системы.
	 *
	 * @param name Название операционной системы.
	 */
	OperatingSystemType(@Nullable final String name)
	{
		this.name = name;
	}

	/**
	 * Возвращает название операционной системы.
	 *
	 * @return Название операционной системы.
	 */
	@Nullable
	public String getName()
	{
		return this.name;
	}
}
