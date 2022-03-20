/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных операционных систем.
 */
public enum OperatingSystemType
{
	UNKNOWN(
		null,
		null
	),

	WINDOWS(
		1L,
		"Windows"
	),

	KUBUNTU(
		2L,
		"Kubuntu"
	),

	MAC_OS_X(
		3L,
		"Mac OS X"
	),

	MAC_OS_9(
		4L,
		"Mac OS 9"
	),

	ANDROID(
		5L,
		"Android"
	),

	IOS(
		6L,
		"iOS"
	),

	LINUX(
		7L,
		"Linux"
	),

	UBUNTU(
		8L,
		"Ubuntu"
	),

	MANDRIVA_LINUX(
		9L,
		"Mandriva Linux"
	),

	ASPLINUX(
		10L,
		"ASPLinux"
	),

	OPENSUSE(
		11L,
		"OpenSUSE"
	),

	BADA(
		12L,
		"Bada"
	),

	CHROME_OS(
		13L,
		"Chrome OS"
	),

	DARWIN(
		14L,
		"Darwin"
	),

	NETBSD(
		15L,
		"NetBSD"
	),

	BLACKBERRY_OS(
		16L,
		"BlackBerry OS"
	),

	AMIGAOS(
		17L,
		"AmigaOS"
	),

	HAIKU(
		18L,
		"Haiku"
	),

	WINDOWS_MOBILE(
		19L,
		"Windows Mobile"
	),

	WINDOWS_PHONE(
		20L,
		"Windows Phone"
	),

	SYMBIAN_OS(
		21L,
		"Symbian OS"
	),

	SOLARIS(
		22L,
		"Solaris"
	),

	WINDOWS_CE(
		23L,
		"Windows CE"
	),

	BEOS(
		24L,
		"BeOS"
	),

	FEDORA(
		25L,
		"Fedora"
	),

	OPENBSD(
		26L,
		"OpenBSD"
	),

	LINUX_MINT(
		27L,
		"Linux Mint"
	),

	FREEBSD(
		28L,
		"FreeBSD"
	),

	LINUX_GENTOO(
		29L,
		"Linux Gentoo"
	),

	SLACKWARE_LINUX(
		30L,
		"Slackware Linux"
	),

	MIDP(
		31L,
		"MIDP"
	),

	CENTOS(
		32L,
		"CentOS"
	),

	RED_HAT(
		33L,
		"Red Hat"
	),

	SUNOS(
		34L,
		"SunOS"
	),

	KAIOS(
		35L,
		"KaiOS"
	),

	WEBOS(
		36L,
		"WebOS"
	),

	TV_OS(
		37L,
		"Apple TV OS"
	),

	MAUI(
		38L,
		"MAUI"
	),

	TIZEN(
		39L,
		"Tizen"
	);

	/**
	 * Идентификатор операционной системы.
	 */
	@Nullable
	private final Long id;

	/**
	 * Название операционной системы.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает идентификатор и название операционной системы.
	 *
	 * @param id Идентификатор операционной системы.
	 * @param name Название операционной системы.
	 */
	OperatingSystemType(@Nullable final Long id, @Nullable final String name)
	{
		this.id = id;
		this.name = name;
	}

	/**
	 * Возвращает идентификатор операционной системы.
	 *
	 * @return Идентификатор операционной системы.
	 */
	@Nullable
	public Long getId()
	{
		return this.id;
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
