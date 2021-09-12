/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных браузеров.
 */
enum BrowserType
{
	UNKNOWN(
		null,
		null
	),

	GOOGLE_CHROME(
		"1",
		"Google Chrome"
	),

	OPERA(
		"2",
		"Opera"
	),

	FIREFOX(
		"3",
		"Firefox"
	),

	INTERNET_EXPLORER(
		"4",
		"Internet Explorer"
	),

	YANDEX_BROWSER(
		"5",
		"Yandex browser"
	),

	EDGE(
		"6",
		"Edge"
	),

	SAFARI(
		"7",
		"Safari"
	),

	CHROMIUM(
		"8",
		"Chromium"
	),

	OTTER_BROWSER(
		"9",
		"Otter Browser"
	),

	VIVALDI(
		"10",
		"Vivaldi"
	),

	MAXTHON(
		"11",
		"Maxthon"
	),

	KONQUEROR(
		"12",
		"Konqueror"
	),

	SRWARE_IRON(
		"13",
		"SRWare Iron"
	),

	SEAMONKEY(
		"14",
		"SeaMonkey"
	),

	AOL_BROWSER(
		"15",
		"Aol Browser"
	),

	ICEWEASEL(
		"16",
		"IceWeasel"
	),

	EPIPHANY(
		"17",
		"Epiphany"
	),

	KAZEHAKASE(
		"18",
		"Kazehakase"
	),

	GALEON(
		"19",
		"Galeon"
	),

	ICECAT(
		"20",
		"IceCat"
	),

	OPERA_TOUCH(
		"21",
		"Opera Touch"
	),

	FLOCK(
		"22",
		"Flock"
	),

	NETSCAPE_NAVIGATOR(
		"23",
		"Netscape Navigator"
	),

	PHOENIX_BROWSER(
		"24",
		"Phoenix Browser"
	),

	UCBROWSER(
		"25",
		"UCBrowser"
	),

	ARORA(
		"26",
		"Arora"
	),

	MINIMO(
		"27",
		"Minimo"
	),

	OMNIWEB(
		"28",
		"OmniWeb"
	),

	SHIIRA(
		"29",
		"Shiira"
	),

	SUNRISE_BROWSER(
		"30",
		"Sunrise Browser"
	),

	NOKIA_BROWSER(
		"31",
		"Nokia Browser"
	),

	CAMINO(
		"32",
		"Camino"
	),

	CHIMERA(
		"33",
		"Chimera"
	),

	ICEAPE(
		"34",
		"IceApe"
	),

	MIDORI(
		"35",
		"Midori"
	),

	LEECHCRAFT(
		"36",
		"LeechCraft"
	),

	MIUI_BROWSER(
		"37",
		"Miui Browser"
	),

	BAIDU_BROWSER_HD(
		"38",
		"Baidu Browser HD"
	),

	K_NINJA(
		"39",
		"K-Ninja"
	),

	NETFRONT(
		"40",
		"NetFront"
	),

	THUNDERBROWSE(
		"41",
		"ThunderBrowse"
	),

	PALE_MOON(
		"42",
		"Pale Moon"
	),

	ALOHA_BROWSER(
		"43",
		"Aloha Browser"
	),

	SAMSUNG_BROWSER(
		"44",
		"Samsung Browser"
	),

	DOLPHIN_BROWSER(
		"45",
		"Dolphin Browser"
	),

	MERCURY(
		"46",
		"Mercury"
	),

	K_MELEON(
		"47",
		"K-Meleon"
	),

	QQBROWSER(
		"48",
		"QQBrowser"
	),

	OPERA_MINI(
		"49",
		"Opera Mini"
	),

	OPERA_MOBI(
		"50",
		"Opera Mobi"
	),

	SPUTNIK_BROWSER(
		"51",
		"Sputnik Browser"
	),

	BING_SEARCH_APP(
		"52",
		"Bing Search App"
	),

	NINTENDO_BROWSER(
		"53",
		"NintendoBrowser"
	),

	SLEIPNIR(
		"54",
		"Sleipnir"
	),

	CRAZY_BROWSER(
		"55",
		"Crazy Browser"
	),

	COC_COC_BROWSER(
		"56",
		"Coc Coc Browser"
	),

	LG_BROWSER(
		"57",
		"LG Browser"
	),

	QUARK(
		"58",
		"Quark Browser"
	),

	SURF(
		"59",
		"Surf"
	),

	HUAWEIBROWSER(
		"60",
		"Huawei Browser"
	),

	ELEMENTS_BROWSER(
		"61",
		"Elements Browser"
	),

	NAVER_WHALE(
		"62",
			"Naver Whale"
	),

	AMIGO(
		"63",
		"Amigo"
	),

	MZBROWSER(
		"64",
		"Meizu Browser"
	),

	STAINLESS(
		"65",
		"Stainless"
	),

	OVIBROWSER(
		"66",
		"OviBrowser"
	),

	BAIDU_BROWSER(
		"67",
		"Baidu"
	),

	PUFFIN(
		"68",
		"Puffin Browser"
	),

	MINEFIELD(
		"69",
		"Minefield Browser"
	),

	SHIRETOKO(
		"70",
		"Shiretoko Browser"
	),

	NAMOROKA(
		"71",
		"Namoroka Browser"
	),

	VIVOBROWSER(
		"72",
		"VivoBrowser"
	),

	HEYTAPBROWSER(
		"73",
		"HeyTapBrowser"
	),

	OPPOBROWSER(
		"74",
		"OppoBrowser"
	),

	SUPERBIRD(
		"75",
		"Superbird"
	),

	LUNASCAPE(
		"76",
		"Lunascape"
	);

	/**
	 * ID браузера.
	 */
	@Nullable
	private final String id;

	/**
	 * Название браузера.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает ID браузера.
	 * Устанавливает название браузера.
	 *
	 * @param id ID браузера
	 * @param name название браузера
	 */
	BrowserType(String id, String name)
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
