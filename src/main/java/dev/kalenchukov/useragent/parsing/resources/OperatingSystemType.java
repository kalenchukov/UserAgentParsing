/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
