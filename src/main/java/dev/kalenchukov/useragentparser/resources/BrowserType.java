/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных браузеров.
 */
public enum BrowserType
{
	UNKNOWN(
		null
	),

	GOOGLE_CHROME(
		"Google Chrome"
	),

	OPERA(
		"Opera"
	),

	FIREFOX(
		"Firefox"
	),

	INTERNET_EXPLORER(
		"Internet Explorer"
	),

	YANDEX_BROWSER(
		"Yandex browser"
	),

	EDGE(
		"Edge"
	),

	SAFARI(
		"Safari"
	),

	CHROMIUM(
		"Chromium"
	),

	OTTER_BROWSER(
		"Otter Browser"
	),

	VIVALDI(
		"Vivaldi"
	),

	MAXTHON(
		"Maxthon"
	),

	KONQUEROR(
		"Konqueror"
	),

	SRWARE_IRON(
		"SRWare Iron"
	),

	SEAMONKEY(
		"SeaMonkey"
	),

	AOL_BROWSER(
		"Aol Browser"
	),

	ICEWEASEL(
		"IceWeasel"
	),

	EPIPHANY(
		"Epiphany"
	),

	KAZEHAKASE(
		"Kazehakase"
	),

	GALEON(
		"Galeon"
	),

	ICECAT(
		"IceCat"
	),

	OPERA_TOUCH(
		"Opera Touch"
	),

	FLOCK(
		"Flock"
	),

	NETSCAPE_NAVIGATOR(
		"Netscape Navigator"
	),

	PHOENIX_BROWSER(
		"Phoenix Browser"
	),

	UCBROWSER(
		"UCBrowser"
	),

	ARORA(
		"Arora"
	),

	MINIMO(
		"Minimo"
	),

	OMNIWEB(
		"OmniWeb"
	),

	SHIIRA(
		"Shiira"
	),

	SUNRISE_BROWSER(
		"Sunrise Browser"
	),

	NOKIA_BROWSER(
		"Nokia Browser"
	),

	CAMINO(
		"Camino"
	),

	CHIMERA(
		"Chimera"
	),

	ICEAPE(
		"IceApe"
	),

	MIDORI(
		"Midori"
	),

	LEECHCRAFT(
		"LeechCraft"
	),

	MIUI_BROWSER(
		"Miui Browser"
	),

	BAIDU_BROWSER_HD(
		"Baidu Browser HD"
	),

	K_NINJA(
		"K-Ninja"
	),

	NETFRONT(
		"NetFront"
	),

	THUNDERBROWSE(
		"ThunderBrowse"
	),

	PALE_MOON(
		"Pale Moon"
	),

	ALOHA_BROWSER(
		"Aloha Browser"
	),

	SAMSUNG_BROWSER(
		"Samsung Browser"
	),

	DOLPHIN_BROWSER(
		"Dolphin Browser"
	),

	MERCURY(
		"Mercury"
	),

	K_MELEON(
		"K-Meleon"
	),

	QQBROWSER(
		"QQBrowser"
	),

	OPERA_MINI(
		"Opera Mini"
	),

	OPERA_MOBI(
		"Opera Mobi"
	),

	SPUTNIK_BROWSER(
		"Sputnik Browser"
	),

	BING_SEARCH_APP(
		"Bing Search App"
	),

	NINTENDO_BROWSER(
		"NintendoBrowser"
	),

	SLEIPNIR(
		"Sleipnir"
	),

	CRAZY_BROWSER(
		"Crazy Browser"
	),

	COC_COC_BROWSER(
		"Coc Coc Browser"
	),

	LG_BROWSER(
		"LG Browser"
	),

	QUARK(
		"Quark Browser"
	),

	SURF(
		"Surf"
	),

	HUAWEIBROWSER(
		"Huawei Browser"
	),

	ELEMENTS_BROWSER(
		"Elements Browser"
	),

	NAVER_WHALE(
			"Naver Whale"
	),

	AMIGO(
		"Amigo"
	),

	MZBROWSER(
		"Meizu Browser"
	),

	STAINLESS(
		"Stainless"
	),

	OVIBROWSER(
		"OviBrowser"
	),

	BAIDU_BROWSER(
		"Baidu"
	),

	PUFFIN(
		"Puffin Browser"
	),

	MINEFIELD(
		"Minefield Browser"
	),

	SHIRETOKO(
		"Shiretoko Browser"
	),

	NAMOROKA(
		"Namoroka Browser"
	),

	VIVOBROWSER(
		"VivoBrowser"
	),

	HEYTAPBROWSER(
		"HeyTapBrowser"
	),

	OPPOBROWSER(
		"OppoBrowser"
	),

	SUPERBIRD(
		"Superbird"
	),

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
	 * @param name Название браузера.
	 */
	BrowserType(@Nullable final String name)
	{
		this.name = name;
	}

	/**
	 * Возвращает название браузера.
	 *
	 * @return Название браузера.
	 */
	@Nullable
	public String getName()
	{
		return this.name;
	}
}
