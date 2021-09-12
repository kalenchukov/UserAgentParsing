/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс определяющий браузер.
 */
public class Browser
{
	/**
	 * Строка user-agent.
	 */
	@Nullable
	private String userAgent = null;

	/**
	 * Версия браузера.
	 */
	@Nullable
	private String version = null;

	/**
	 * Тип браузера.
	 *
	 * @see BrowserType
	 */
	private BrowserType browser = BrowserType.UNKNOWN;

	/**
	 * Список регулярных выражений для определения типа браузера.
	 *
	 * @see #getMapRegExp()
	 */
	private final Map<String, BrowserType> mapRegExp = this.getMapRegExp();

	Browser() {}

	/**
	 * Возвращает название браузера по идентификатору
	 *
	 * @param id идентификатор браузера
	 * @return название браузера
	 */
	@Nullable
	public static String getById(@NotNull String id)
	{
		for (BrowserType elm: BrowserType.values())
		{
			if (elm != BrowserType.UNKNOWN && elm.getId().equals(id))
			{
				return elm.getName();
			}
		}

		return null;
	}

	/**
	 * Возвращает идентификатор браузера по названию
	 *
	 * @param name название браузера
	 * @return идентификатор браузера
	 */
	@Nullable
	public static String getByName(@NotNull String name)
	{
		for (BrowserType elm: BrowserType.values())
		{
			if (elm != BrowserType.UNKNOWN && elm.getName().equals(name))
			{
				return elm.getId();
			}
		}

		return null;
	}

	/**
	 * Возвращает все типы браузеров
	 *
	 * @return идентификатор и название браузера
	 */
	public static Map<String, String> getAll()
	{
		Map<String, String> types = new HashMap<>();

		for (BrowserType elm: BrowserType.values())
		{
			if (elm != BrowserType.UNKNOWN)
			{
				types.put(elm.getId(), elm.getName());
			}
		}

		return types;
	}

	/**
	 * Устанавливает строку user-agent.
	 *
	 * @param userAgent строка user-agent
	 */
	void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
		this.browser = BrowserType.UNKNOWN;
		this.version = null;

		if (userAgent != null && !userAgent.equals(""))
		{
			this.execute();
		}
	}

	@Nullable
	String getId()
	{
		return this.browser.getId();
	}

	@Nullable
	String getName()
	{
		return this.browser.getName();
	}

	@Nullable
	String getVersion()
	{
		return this.version;
	}

	/**
	 * Выполняет поиск шаблона регулярного выражения в строке user-agent.
	 */
	private void execute()
	{
		Pattern pattern;
		Matcher matcher;

		for (Map.Entry<String, BrowserType> regExp : mapRegExp.entrySet())
		{
			pattern = Pattern.compile(regExp.getKey(), Pattern.CASE_INSENSITIVE);
			matcher = pattern.matcher(this.userAgent);

			if (matcher.matches())
			{
				if (matcher.groupCount() > 0)
				{
					this.version = matcher.group("version")
										  .replace("_", ".")
										  .trim();
				}

				this.browser = regExp.getValue();
				break;
			}
		}
	}

	/**
	 * Возвращает список регулярных выражений для определения браузера.
	 */
	private Map<String, BrowserType> getMapRegExp()
	{
		Map<String, BrowserType> mapRegExp = new LinkedHashMap<>();

		mapRegExp.put(".*Lunascape/(?<version>[0-9.]+);.*", BrowserType.LUNASCAPE);
		mapRegExp.put(".*ThunderBrowse/(?<version>[0-9.]+);.*", BrowserType.THUNDERBROWSE);
		mapRegExp.put(".*K\\-Ninja/(?<version>[0-9.]+);.*", BrowserType.K_NINJA);
		mapRegExp.put(".*Superbird/(?<version>[0-9.]+).*", BrowserType.SUPERBIRD);
		mapRegExp.put(".*OppoBrowser/(?<version>[0-9.]+).*", BrowserType.OPPOBROWSER);
		mapRegExp.put(".*HeyTapBrowser/(?<version>[0-9.]+).*", BrowserType.HEYTAPBROWSER);
		mapRegExp.put(".*VivoBrowser/(?<version>[0-9.]+).*", BrowserType.VIVOBROWSER);
		mapRegExp.put(".*Namoroka/(?<version>[0-9.]+).*", BrowserType.NAMOROKA);
		mapRegExp.put(".*Shiretoko/(?<version>[0-9.]+).*", BrowserType.SHIRETOKO);
		mapRegExp.put(".*Minefield/(?<version>[0-9.]+).*", BrowserType.MINEFIELD);
		mapRegExp.put(".*Puffin/(?<version>[0-9.]+).*", BrowserType.PUFFIN);
		mapRegExp.put(".*OviBrowser/(?<version>[0-9.]+).*", BrowserType.OVIBROWSER);
		mapRegExp.put(".*Stainless/(?<version>[0-9.]+).*", BrowserType.STAINLESS);
		mapRegExp.put(".*MZBrowser/(?<version>[0-9.]+).*", BrowserType.MZBROWSER);
		mapRegExp.put(".*Amigo/(?<version>[0-9.]+).*", BrowserType.AMIGO);
		mapRegExp.put(".*Whale/(?<version>[0-9.]+).*", BrowserType.NAVER_WHALE);
		mapRegExp.put(".*Elements Browser/(?<version>[0-9.]+).*", BrowserType.ELEMENTS_BROWSER);
		mapRegExp.put(".*HuaweiBrowser/(?<version>[0-9.]+).*", BrowserType.HUAWEIBROWSER);
		mapRegExp.put(".*LG Browser/(?<version>[0-9.]+).*", BrowserType.LG_BROWSER);
		mapRegExp.put(".*bingweb/(?<version>[0-9.]+).*", BrowserType.BING_SEARCH_APP);
		mapRegExp.put(".*sputnikbrowser/(?<version>[0-9.]+).*", BrowserType.SPUTNIK_BROWSER);
		mapRegExp.put(".*nintendobrowser/(?<version>[0-9.]+).*", BrowserType.NINTENDO_BROWSER);
		mapRegExp.put(".*Crazy Browser/(?<version>[0-9.]+).*", BrowserType.CRAZY_BROWSER);
		mapRegExp.put(".*Crazy Browser (?<version>[0-9.]+).*", BrowserType.CRAZY_BROWSER);
		mapRegExp.put(".*coc_coc_browser/(?<version>[0-9.]+).*", BrowserType.COC_COC_BROWSER);
		mapRegExp.put(".*Sleipnir/(?<version>[0-9.]+).*", BrowserType.SLEIPNIR);
		mapRegExp.put(".*vivaldi/(?<version>[0-9.]+).*", BrowserType.VIVALDI);
		mapRegExp.put(".*FxiOS/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		mapRegExp.put(".*yabrowser/(?<version>[0-9.]+).*", BrowserType.YANDEX_BROWSER);
		mapRegExp.put(".*YaSearchBrowser/(?<version>[0-9.]+).*", BrowserType.YANDEX_BROWSER);
		mapRegExp.put(".*otter/(?<version>[0-9.]+).*", BrowserType.OTTER_BROWSER);
		mapRegExp.put(".*maxthon/(?<version>[0-9.]+).*", BrowserType.MAXTHON);
		mapRegExp.put(".*konqueror/(?<version>[0-9.]+).*", BrowserType.KONQUEROR);
		mapRegExp.put(".*iron/(?<version>[0-9.]+).*", BrowserType.SRWARE_IRON);
		mapRegExp.put(".*seamonkey/(?<version>[0-9.]+).*", BrowserType.SEAMONKEY);
		mapRegExp.put(".*aol/(?<version>[0-9.]+).*", BrowserType.AOL_BROWSER);
		mapRegExp.put(".*iceweasel/(?<version>[0-9.]+).*", BrowserType.ICEWEASEL);
		mapRegExp.put(".*epiphany/(?<version>[0-9.]+).*", BrowserType.EPIPHANY);
		mapRegExp.put(".*kazehakase/(?<version>[0-9.]+).*", BrowserType.KAZEHAKASE);
		mapRegExp.put(".*flock/(?<version>[0-9.]+).*", BrowserType.FLOCK);
		mapRegExp.put(".*netscape/(?<version>[0-9.]+).*", BrowserType.NETSCAPE_NAVIGATOR);
		mapRegExp.put(".*phoenix/(?<version>[0-9.]+).*", BrowserType.PHOENIX_BROWSER);
		mapRegExp.put(".*arora/(?<version>[0-9.]+).*", BrowserType.ARORA);
		mapRegExp.put(".*minimo/(?<version>[0-9.]+).*", BrowserType.MINIMO);
		mapRegExp.put(".*version/(?<version>[0-9.]+) omniweb/[0-9.]+.*", BrowserType.OMNIWEB);
		mapRegExp.put(".*omniweb/v(?<version>[0-9.]+).*", BrowserType.OMNIWEB);
		mapRegExp.put(".*shiira/(?<version>[0-9.]+).*", BrowserType.SHIIRA);
		mapRegExp.put(".*sunrisebrowser/(?<version>[0-9.]+).*", BrowserType.SUNRISE_BROWSER);
		mapRegExp.put(".*galeon/(?<version>[0-9.]+).*", BrowserType.GALEON);
		mapRegExp.put(".*icecat/(?<version>[0-9.]+).*", BrowserType.ICECAT);
		mapRegExp.put(".*nokiabrowser/(?<version>[0-9.]+).*", BrowserType.NOKIA_BROWSER);
		mapRegExp.put(".*camino/(?<version>[0-9.]+).*", BrowserType.CAMINO);
		mapRegExp.put(".*chimera/(?<version>[0-9.]+).*", BrowserType.CHIMERA);
		mapRegExp.put(".*iceape/(?<version>[0-9.]+).*", BrowserType.ICEAPE);
		mapRegExp.put(".*midori/(?<version>[0-9.]+).*", BrowserType.MIDORI);
		mapRegExp.put(".*leechcraft/(?<version>[0-9.]+).*", BrowserType.LEECHCRAFT);
		mapRegExp.put(".*miuibrowser/(?<version>[0-9.]+).*", BrowserType.MIUI_BROWSER);
		mapRegExp.put(".*miui/v(?<version>[0-9.]+).*", BrowserType.MIUI_BROWSER);
		mapRegExp.put(".*baiduhd/(?<version>[0-9.]+).*", BrowserType.BAIDU_BROWSER_HD);
		mapRegExp.put(".*palemoon/(?<version>[0-9.]+).*", BrowserType.PALE_MOON);
		mapRegExp.put(".*alohabrowser/(?<version>[0-9.]+).*", BrowserType.ALOHA_BROWSER);
		mapRegExp.put(".*samsungbrowser/(?<version>[0-9.]+).*", BrowserType.SAMSUNG_BROWSER);
		mapRegExp.put(".*dolphin/(?<version>[0-9.]+).*", BrowserType.DOLPHIN_BROWSER);
		mapRegExp.put(".*mercury/(?<version>[0-9.]+).*", BrowserType.MERCURY);
		mapRegExp.put(".*k-meleon/(?<version>[0-9.]+).*", BrowserType.K_MELEON);
		mapRegExp.put(".*qqbrowser/(?<version>[0-9.]+).*", BrowserType.QQBROWSER);
		mapRegExp.put(".*ucbrowser/(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		mapRegExp.put(".*UBrowser/(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		mapRegExp.put(".*uc browser(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		mapRegExp.put(".*ucbrowser(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		mapRegExp.put(".*netfront/(?<version>[0-9.]+).*", BrowserType.NETFRONT);
		mapRegExp.put(".*BIDUBrowser/(?<version>[0-9.]+).*", BrowserType.BAIDU_BROWSER);
		mapRegExp.put(".*iemobile (?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		mapRegExp.put(".*iemobile/(?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		mapRegExp.put(".*EdgiOS/(?<version>[0-9.]+).*", BrowserType.EDGE);
		mapRegExp.put(".*Edge/(?<version>[0-9.]+).*", BrowserType.EDGE);
		mapRegExp.put(".*EdgA/(?<version>[0-9.]+).*", BrowserType.EDGE);
		mapRegExp.put(".*EdgW/(?<version>[0-9.]+).*", BrowserType.EDGE);
		mapRegExp.put(".*Edg/(?<version>[0-9.]+).*", BrowserType.EDGE);
		mapRegExp.put(".*opera mini/[0-9.]+.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		mapRegExp.put(".*opera mini/.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		mapRegExp.put(".*opera mini/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		mapRegExp.put(".*opera mobi/.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MOBI);
		mapRegExp.put(".*opera mobi/(?<version>[0-9.]+).*", BrowserType.OPERA_MOBI);
		mapRegExp.put(".*opios/(?<version>[0-9.]+).*", BrowserType.OPERA);
		mapRegExp.put(".*opr/(?<version>[0-9.]+).*", BrowserType.OPERA);
		mapRegExp.put(".*opt/(?<version>[0-9.]+).", BrowserType.OPERA_TOUCH);
		mapRegExp.put(".*opera/[0-9.]+.*version/(?<version>[0-9.]+).*", BrowserType.OPERA);
		mapRegExp.put(".*opera (?<version>[0-9.]+).*", BrowserType.OPERA);
		mapRegExp.put(".*opera/(?<version>[0-9.]+).*", BrowserType.OPERA);
		mapRegExp.put(".*CriOS/(?<version>[0-9.]+).*", BrowserType.GOOGLE_CHROME);
		mapRegExp.put(".*chromium/(?<version>[0-9.]+).*", BrowserType.CHROMIUM);
		mapRegExp.put(".*Quark/(?<version>[0-9.]+).*", BrowserType.QUARK);
		mapRegExp.put(".*Surf/(?<version>[0-9.]+).*", BrowserType.SURF);
		mapRegExp.put(".*Firefox/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		mapRegExp.put(".*fennec/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		mapRegExp.put(".*Focus/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		mapRegExp.put(".*Firebird/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		mapRegExp.put(".*MSIE (?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		mapRegExp.put(".*trident/[0-9.]+.*rv:(?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		mapRegExp.put(".*version/(?<version>[0-9.]+) mobile/[a-z0-9]+ safari/[0-9.]+.*", BrowserType.SAFARI);
		mapRegExp.put(".*version/(?<version>[0-9.]+) mobile safari/[0-9.]+.*", BrowserType.SAFARI);
		mapRegExp.put(".*version/(?<version>[0-9.]+) safari/[0-9.]+.*", BrowserType.SAFARI);
		mapRegExp.put(".*Chrome/(?<version>[0-9.]+) Mobile.*", BrowserType.GOOGLE_CHROME);
		mapRegExp.put(".*Chrome/(?<version>[0-9.]+) Safari.*", BrowserType.GOOGLE_CHROME);

		return mapRegExp;
	}
}
