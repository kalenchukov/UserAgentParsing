/*
 * Copyright © 2022-2023 Алексей Каленчуков
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
 *
 * @author Алексей Каленчуков
 */
public enum OperatingSystemType
{
	/**
	 * Не определён.
	 */
	UNKNOWN(
		null
	),

	/**
	 * Windows.
	 */
	WINDOWS(
		"Windows"
	),

	/**
	 * Kubuntu.
	 */
	KUBUNTU(
		"Kubuntu"
	),

	/**
	 * Mac OS X.
	 */
	MAC_OS_X(
		"Mac OS X"
	),

	/**
	 * Mac OS 9.
	 */
	MAC_OS_9(
		"Mac OS 9"
	),

	/**
	 * Android.
	 */
	ANDROID(
		"Android"
	),

	/**
	 * iOS.
	 */
	IOS(
		"iOS"
	),

	/**
	 * Linux.
	 */
	LINUX(
		"Linux"
	),

	/**
	 * Ubuntu.
	 */
	UBUNTU(
		"Ubuntu"
	),

	/**
	 * Mandriva Linux.
	 */
	MANDRIVA_LINUX(
		"Mandriva Linux"
	),

	/**
	 * ASPLinux.
	 */
	ASPLINUX(
		"ASPLinux"
	),

	/**
	 * OpenSUSE
	 */
	OPENSUSE(
		"OpenSUSE"
	),

	/**
	 * Bada.
	 */
	BADA(
		"Bada"
	),

	/**
	 * Chrome OS.
	 */
	CHROME_OS(
		"Chrome OS"
	),

	/**
	 * Darwin.
	 */
	DARWIN(
		"Darwin"
	),

	/**
	 * NetBSD.
	 */
	NETBSD(
		"NetBSD"
	),

	/**
	 * BlackBerry OS.
	 */
	BLACKBERRY_OS(
		"BlackBerry OS"
	),

	/**
	 * AmigaOS.
	 */
	AMIGAOS(
		"AmigaOS"
	),

	/**
	 * Haiku.
	 */
	HAIKU(
		"Haiku"
	),

	/**
	 * Windows Mobile.
	 */
	WINDOWS_MOBILE(
		"Windows Mobile"
	),

	/**
	 * Windows Phone.
	 */
	WINDOWS_PHONE(
		"Windows Phone"
	),

	/**
	 * Symbian OS.
	 */
	SYMBIAN_OS(
		"Symbian OS"
	),

	/**
	 * Solaris.
	 */
	SOLARIS(
		"Solaris"
	),

	/**
	 * Windows CE.
	 */
	WINDOWS_CE(
		"Windows CE"
	),

	/**
	 * BeOS.
	 */
	BEOS(
		"BeOS"
	),

	/**
	 * Fedora.
	 */
	FEDORA(
		"Fedora"
	),

	/**
	 * OpenBSD.
	 */
	OPENBSD(
		"OpenBSD"
	),

	/**
	 * Linux Mint.
	 */
	LINUX_MINT(
		"Linux Mint"
	),

	/**
	 * FreeBSD.
	 */
	FREEBSD(
		"FreeBSD"
	),

	/**
	 * Linux Gentoo.
	 */
	LINUX_GENTOO(
		"Linux Gentoo"
	),

	/**
	 * Slackware Linux.
	 */
	SLACKWARE_LINUX(
		"Slackware Linux"
	),

	/**
	 * MIDP.
	 */
	MIDP(
		"MIDP"
	),

	/**
	 * CentOS.
	 */
	CENTOS(
		"CentOS"
	),

	/**
	 * Red Hat.
	 */
	RED_HAT(
		"Red Hat"
	),

	/**
	 * SunOS.
	 */
	SUNOS(
		"SunOS"
	),

	/**
	 * KaiOS.
	 */
	KAIOS(
		"KaiOS"
	),

	/**
	 * WebOS.
	 */
	WEBOS(
		"WebOS"
	),

	/**
	 * Apple TV OS.
	 */
	TV_OS(
		"Apple TV OS"
	),

	/**
	 * MAUI.
	 */
	MAUI(
		"MAUI"
	),

	/**
	 * Tizen.
	 */
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
	 * @param name название операционной системы.
	 */
	OperatingSystemType(@Nullable final String name)
	{
		this.name = name;
	}

	/**
	 * Возвращает название операционной системы.
	 *
	 * @return название операционной системы.
	 */
	@Nullable
	public String getName()
	{
		return this.name;
	}
}
