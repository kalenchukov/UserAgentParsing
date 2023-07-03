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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Типы возможных браузеров.
 *
 * @author Алексей Каленчуков
 */
public enum BrowserType
{
	/**
	 * Не определён.
	 */
	UNKNOWN(
		null
	),

	/**
	 * Google Chrome.
	 */
	GOOGLE_CHROME(
		"Google Chrome"
	),

	/**
	 * Opera.
	 */
	OPERA(
		"Opera"
	),

	/**
	 * Firefox.
	 */
	FIREFOX(
		"Firefox"
	),

	/**
	 * Internet Explorer.
	 */
	INTERNET_EXPLORER(
		"Internet Explorer"
	),

	/**
	 * Yandex.
	 */
	YANDEX_BROWSER(
		"Yandex browser"
	),

	/**
	 * Edge.
	 */
	EDGE(
		"Edge"
	),

	/**
	 * Safari.
	 */
	SAFARI(
		"Safari"
	),

	/**
	 * Chromium.
	 */
	CHROMIUM(
		"Chromium"
	),

	/**
	 * Otter.
	 */
	OTTER_BROWSER(
		"Otter Browser"
	),

	/**
	 * Vivaldi.
	 */
	VIVALDI(
		"Vivaldi"
	),

	/**
	 * Maxthon.
	 */
	MAXTHON(
		"Maxthon"
	),

	/**
	 * Konqueror.
	 */
	KONQUEROR(
		"Konqueror"
	),

	/**
	 * SRWare Iron.
	 */
	SRWARE_IRON(
		"SRWare Iron"
	),

	/**
	 * SeaMonkey.
	 */
	SEAMONKEY(
		"SeaMonkey"
	),

	/**
	 * Aol.
	 */
	AOL_BROWSER(
		"Aol Browser"
	),

	/**
	 * IceWeasel.
	 */
	ICEWEASEL(
		"IceWeasel"
	),

	/**
	 * Epiphany.
	 */
	EPIPHANY(
		"Epiphany"
	),

	/**
	 * Kazehakase.
	 */
	KAZEHAKASE(
		"Kazehakase"
	),

	/**
	 * Galeon.
	 */
	GALEON(
		"Galeon"
	),

	/**
	 * IceCat.
	 */
	ICECAT(
		"IceCat"
	),

	/**
	 * Opera Touch.
	 */
	OPERA_TOUCH(
		"Opera Touch"
	),

	/**
	 * Flock.
	 */
	FLOCK(
		"Flock"
	),

	/**
	 * Netscape Navigator.
	 */
	NETSCAPE_NAVIGATOR(
		"Netscape Navigator"
	),

	/**
	 * Phoenix.
	 */
	PHOENIX_BROWSER(
		"Phoenix Browser"
	),

	/**
	 * UCBrowser.
	 */
	UCBROWSER(
		"UCBrowser"
	),

	/**
	 * Arora.
	 */
	ARORA(
		"Arora"
	),

	/**
	 * Minimo.
	 */
	MINIMO(
		"Minimo"
	),

	/**
	 * OmniWeb.
	 */
	OMNIWEB(
		"OmniWeb"
	),

	/**
	 * Shiira.
	 */
	SHIIRA(
		"Shiira"
	),

	/**
	 * Sunrise.
	 */
	SUNRISE_BROWSER(
		"Sunrise Browser"
	),

	/**
	 * Nokia.
	 */
	NOKIA_BROWSER(
		"Nokia Browser"
	),

	/**
	 * Camino.
	 */
	CAMINO(
		"Camino"
	),

	/**
	 * Chimera.
	 */
	CHIMERA(
		"Chimera"
	),

	/**
	 * IceApe.
	 */
	ICEAPE(
		"IceApe"
	),

	/**
	 * Midori.
	 */
	MIDORI(
		"Midori"
	),

	/**
	 * LeechCraft.
	 */
	LEECHCRAFT(
		"LeechCraft"
	),

	/**
	 * Miui.
	 */
	MIUI_BROWSER(
		"Miui Browser"
	),

	/**
	 * Baidu HD.
	 */
	BAIDU_BROWSER_HD(
		"Baidu Browser HD"
	),

	/**
	 * K-Ninja.
	 */
	K_NINJA(
		"K-Ninja"
	),

	/**
	 * NetFront.
	 */
	NETFRONT(
		"NetFront"
	),

	/**
	 * ThunderBrowse.
	 */
	THUNDERBROWSE(
		"ThunderBrowse"
	),

	/**
	 * Pale Moon.
	 */
	PALE_MOON(
		"Pale Moon"
	),

	/**
	 * Aloha.
	 */
	ALOHA_BROWSER(
		"Aloha Browser"
	),

	/**
	 * Samsung.
	 */
	SAMSUNG_BROWSER(
		"Samsung Browser"
	),

	/**
	 * Dolphin.
	 */
	DOLPHIN_BROWSER(
		"Dolphin Browser"
	),

	/**
	 * Mercury.
	 */
	MERCURY(
		"Mercury"
	),

	/**
	 * K-Meleon.
	 */
	K_MELEON(
		"K-Meleon"
	),

	/**
	 * QQBrowser.
	 */
	QQBROWSER(
		"QQBrowser"
	),

	/**
	 * Opera Mini.
	 */
	OPERA_MINI(
		"Opera Mini"
	),

	/**
	 * Opera Mobi.
	 */
	OPERA_MOBI(
		"Opera Mobi"
	),

	/**
	 * Sputnik.
	 */
	SPUTNIK_BROWSER(
		"Sputnik Browser"
	),

	/**
	 * Bing Search App.
	 */
	BING_SEARCH_APP(
		"Bing Search App"
	),

	/**
	 * Nintendo DS Browser.
	 */
	NINTENDO_BROWSER(
		"NintendoBrowser"
	),

	/**
	 * Sleipnir.
	 */
	SLEIPNIR(
		"Sleipnir"
	),

	/**
	 * Crazy Browser.
	 */
	CRAZY_BROWSER(
		"Crazy Browser"
	),

	/**
	 * Coc Coc Browser.
	 */
	COC_COC_BROWSER(
		"Coc Coc Browser"
	),

	/**
	 * LG Browser.
	 */
	LG_BROWSER(
		"LG Browser"
	),

	/**
	 * Quark Browser
	 */
	QUARK(
		"Quark Browser"
	),

	/**
	 * Surf.
	 */
	SURF(
		"Surf"
	),

	/**
	 * Huawei Browser.
	 */
	HUAWEIBROWSER(
		"Huawei Browser"
	),

	/**
	 * Elements Browser.
	 */
	ELEMENTS_BROWSER(
		"Elements Browser"
	),

	/**
	 * Naver Whale.
	 */
	NAVER_WHALE(
			"Naver Whale"
	),

	/**
	 * Amigo.
	 */
	AMIGO(
		"Amigo"
	),

	/**
	 * Meizu Browser.
	 */
	MZBROWSER(
		"Meizu Browser"
	),

	/**
	 * Stainless.
	 */
	STAINLESS(
		"Stainless"
	),

	/**
	 * OviBrowser.
	 */
	OVIBROWSER(
		"OviBrowser"
	),

	/**
	 * Baidu.
	 */
	BAIDU_BROWSER(
		"Baidu"
	),

	/**
	 * Puffin Browser.
	 */
	PUFFIN(
		"Puffin Browser"
	),

	/**
	 * Minefield Browser.
	 */
	MINEFIELD(
		"Minefield Browser"
	),

	/**
	 * Shiretoko Browser.
	 */
	SHIRETOKO(
		"Shiretoko Browser"
	),

	/**
	 * Namoroka Browser.
	 */
	NAMOROKA(
		"Namoroka Browser"
	),

	/**
	 * Vivo Browser.
	 */
	VIVOBROWSER(
		"VivoBrowser"
	),

	/**
	 * HeyTapBrowser.
	 */
	HEYTAPBROWSER(
		"HeyTapBrowser"
	),

	/**
	 * OppoBrowser.
	 */
	OPPOBROWSER(
		"OppoBrowser"
	),

	/**
	 * Superbird.
	 */
	SUPERBIRD(
		"Superbird"
	),

	/**
	 * Lunascape.
	 */
	LUNASCAPE(
		"Lunascape"
	);

	/**
	 * Название браузера.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает название браузера.
	 *
	 * @param name название браузера.
	 */
	BrowserType(@Nullable final String name)
	{
		this.name = name;
	}

	/**
	 * Возвращает название браузера.
	 *
	 * @return название браузера.
	 */
	@Nullable
	public String getName()
	{
		return this.name;
	}

	/**
	 * Возвращает названия всех браузеров.
	 *
	 * @return коллекцию с названиями браузеров.
	 */
	@NotNull
	public static List<@NotNull String> getAllNames()
	{
		List<String> browsers = new ArrayList<>();

		for (BrowserType browser : BrowserType.values())
		{
			if (browser != BrowserType.UNKNOWN) {
				browsers.add(browser.getName());
			}
		}

		return browsers;
	}
}
