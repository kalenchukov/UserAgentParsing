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
		null,
		null
	),

	GOOGLE_CHROME(
		1L,
		"Google Chrome"
	),

	OPERA(
		2L,
		"Opera"
	),

	FIREFOX(
		3L,
		"Firefox"
	),

	INTERNET_EXPLORER(
		4L,
		"Internet Explorer"
	),

	YANDEX_BROWSER(
		5L,
		"Yandex browser"
	),

	EDGE(
		6L,
		"Edge"
	),

	SAFARI(
		7L,
		"Safari"
	),

	CHROMIUM(
		8L,
		"Chromium"
	),

	OTTER_BROWSER(
		9L,
		"Otter Browser"
	),

	VIVALDI(
		10L,
		"Vivaldi"
	),

	MAXTHON(
		11L,
		"Maxthon"
	),

	KONQUEROR(
		12L,
		"Konqueror"
	),

	SRWARE_IRON(
		13L,
		"SRWare Iron"
	),

	SEAMONKEY(
		14L,
		"SeaMonkey"
	),

	AOL_BROWSER(
		15L,
		"Aol Browser"
	),

	ICEWEASEL(
		16L,
		"IceWeasel"
	),

	EPIPHANY(
		17L,
		"Epiphany"
	),

	KAZEHAKASE(
		18L,
		"Kazehakase"
	),

	GALEON(
		19L,
		"Galeon"
	),

	ICECAT(
		20L,
		"IceCat"
	),

	OPERA_TOUCH(
		21L,
		"Opera Touch"
	),

	FLOCK(
		22L,
		"Flock"
	),

	NETSCAPE_NAVIGATOR(
		23L,
		"Netscape Navigator"
	),

	PHOENIX_BROWSER(
		24L,
		"Phoenix Browser"
	),

	UCBROWSER(
		25L,
		"UCBrowser"
	),

	ARORA(
		26L,
		"Arora"
	),

	MINIMO(
		27L,
		"Minimo"
	),

	OMNIWEB(
		28L,
		"OmniWeb"
	),

	SHIIRA(
		29L,
		"Shiira"
	),

	SUNRISE_BROWSER(
		30L,
		"Sunrise Browser"
	),

	NOKIA_BROWSER(
		31L,
		"Nokia Browser"
	),

	CAMINO(
		32L,
		"Camino"
	),

	CHIMERA(
		33L,
		"Chimera"
	),

	ICEAPE(
		34L,
		"IceApe"
	),

	MIDORI(
		35L,
		"Midori"
	),

	LEECHCRAFT(
		36L,
		"LeechCraft"
	),

	MIUI_BROWSER(
		37L,
		"Miui Browser"
	),

	BAIDU_BROWSER_HD(
		38L,
		"Baidu Browser HD"
	),

	K_NINJA(
		39L,
		"K-Ninja"
	),

	NETFRONT(
		40L,
		"NetFront"
	),

	THUNDERBROWSE(
		41L,
		"ThunderBrowse"
	),

	PALE_MOON(
		42L,
		"Pale Moon"
	),

	ALOHA_BROWSER(
		43L,
		"Aloha Browser"
	),

	SAMSUNG_BROWSER(
		44L,
		"Samsung Browser"
	),

	DOLPHIN_BROWSER(
		45L,
		"Dolphin Browser"
	),

	MERCURY(
		46L,
		"Mercury"
	),

	K_MELEON(
		47L,
		"K-Meleon"
	),

	QQBROWSER(
		48L,
		"QQBrowser"
	),

	OPERA_MINI(
		49L,
		"Opera Mini"
	),

	OPERA_MOBI(
		50L,
		"Opera Mobi"
	),

	SPUTNIK_BROWSER(
		51L,
		"Sputnik Browser"
	),

	BING_SEARCH_APP(
		52L,
		"Bing Search App"
	),

	NINTENDO_BROWSER(
		53L,
		"NintendoBrowser"
	),

	SLEIPNIR(
		54L,
		"Sleipnir"
	),

	CRAZY_BROWSER(
		55L,
		"Crazy Browser"
	),

	COC_COC_BROWSER(
		56L,
		"Coc Coc Browser"
	),

	LG_BROWSER(
		57L,
		"LG Browser"
	),

	QUARK(
		58L,
		"Quark Browser"
	),

	SURF(
		59L,
		"Surf"
	),

	HUAWEIBROWSER(
		60L,
		"Huawei Browser"
	),

	ELEMENTS_BROWSER(
		61L,
		"Elements Browser"
	),

	NAVER_WHALE(
		62L,
			"Naver Whale"
	),

	AMIGO(
		63L,
		"Amigo"
	),

	MZBROWSER(
		64L,
		"Meizu Browser"
	),

	STAINLESS(
		65L,
		"Stainless"
	),

	OVIBROWSER(
		66L,
		"OviBrowser"
	),

	BAIDU_BROWSER(
		67L,
		"Baidu"
	),

	PUFFIN(
		68L,
		"Puffin Browser"
	),

	MINEFIELD(
		69L,
		"Minefield Browser"
	),

	SHIRETOKO(
		70L,
		"Shiretoko Browser"
	),

	NAMOROKA(
		71L,
		"Namoroka Browser"
	),

	VIVOBROWSER(
		72L,
		"VivoBrowser"
	),

	HEYTAPBROWSER(
		73L,
		"HeyTapBrowser"
	),

	OPPOBROWSER(
		74L,
		"OppoBrowser"
	),

	SUPERBIRD(
		75L,
		"Superbird"
	),

	LUNASCAPE(
		76L,
		"Lunascape"
	);

	/**
	 * Идентификатор браузера.
	 */
	@Nullable
	private final Long id;

	/**
	 * Название браузера.
	 */
	@Nullable
	private final String name;

	/**
	 * Устанавливает идентификатор и название браузера.
	 *
	 * @param id Идентификатор браузера.
	 * @param name Название браузера.
	 */
	BrowserType(@Nullable final Long id, @Nullable final String name)
	{
		this.id = id;
		this.name = name;
	}

	/**
	 * Возвращает идентификатор браузера.
	 *
	 * @return Идентификатор браузера.
	 */
	@Nullable
	public Long getId()
	{
		return this.id;
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
