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

package dev.kalenchukov.useragent.parsing;

import dev.kalenchukov.useragent.parsing.resources.BrowserType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс определяющий браузер.
 */
public final class Browser
{
	/**
	 * Строка user-agent.
	 */
	@Nullable
	private String userAgent;

	/**
	 * Версия браузера.
	 */
	@Nullable
	private String version;

	/**
	 * Тип браузера.
	 *
	 * @see BrowserType
	 */
	@NotNull
	private BrowserType browser;

	/**
	 * Конструктор для {@code Browser}.
	 */
	public Browser()
	{
		this.userAgent = null;
		this.version = null;
		this.browser = BrowserType.UNKNOWN;
	}

	/**
	 * Список регулярных выражений для определения типа браузера.
	 *
	 * @see #getRegExpBrowsers()
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull BrowserType> regExpBrowsers = this.getRegExpBrowsers();

	/**
	 * Возвращает названия всех браузеров.
	 *
	 * @return Коллекцию с названиями браузеров.
	 */
	@NotNull
	public static List<@NotNull String> getAll()
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

	/**
	 * Устанавливает строку user-agent.
	 *
	 * @param userAgent Строка user-agent.
	 */
	public void setUserAgent(@NotNull final String userAgent)
	{
		Objects.requireNonNull(userAgent);

		this.userAgent = userAgent;
		this.browser = BrowserType.UNKNOWN;
		this.version = null;

		if (!userAgent.isEmpty()) {
			execute();
		}
	}

	/**
	 * Возвращает название браузера.
	 *
	 * @return Название браузера.
	 */
	@Nullable
	public String getName()
	{
		return this.browser.getName();
	}

	/**
	 * Возвращает версию браузера.
	 *
	 * @return Версия браузера.
	 */
	@Nullable
	public String getVersion()
	{
		return this.version;
	}

	/**
	 * Выполняет поиск шаблона регулярного выражения в строке user-agent, и присваивает значения полям класса.
	 */
	private void execute()
	{
		if (this.userAgent != null)
		{
			Pattern pattern;
			Matcher matcher;

			for (Map.Entry<String, BrowserType> regExp : regExpBrowsers.entrySet())
			{
				pattern = Pattern.compile(regExp.getKey(), Pattern.CASE_INSENSITIVE);
				matcher = pattern.matcher(this.userAgent);

				if (matcher.matches())
				{
					if (matcher.groupCount() > 0) {
						this.version = matcher.group("version").replace("_", ".").trim();
					}

					this.browser = regExp.getValue();
					break;
				}
			}
		}
	}

	/**
	 * Возвращает список регулярных выражений для определения браузера.
	 *
	 * @return Коллекцию строк регулярных выражений для браузеров.
	 */
	@NotNull
	private Map<@NotNull String, @NotNull BrowserType> getRegExpBrowsers()
	{
		Map<String, BrowserType> regExpBrowsers = new LinkedHashMap<>();

		regExpBrowsers.put(".*Lunascape/(?<version>[0-9.]+);.*", BrowserType.LUNASCAPE);
		regExpBrowsers.put(".*ThunderBrowse/(?<version>[0-9.]+);.*", BrowserType.THUNDERBROWSE);
		regExpBrowsers.put(".*K\\-Ninja/(?<version>[0-9.]+);.*", BrowserType.K_NINJA);
		regExpBrowsers.put(".*Superbird/(?<version>[0-9.]+).*", BrowserType.SUPERBIRD);
		regExpBrowsers.put(".*OppoBrowser/(?<version>[0-9.]+).*", BrowserType.OPPOBROWSER);
		regExpBrowsers.put(".*HeyTapBrowser/(?<version>[0-9.]+).*", BrowserType.HEYTAPBROWSER);
		regExpBrowsers.put(".*VivoBrowser/(?<version>[0-9.]+).*", BrowserType.VIVOBROWSER);
		regExpBrowsers.put(".*Namoroka/(?<version>[0-9.]+).*", BrowserType.NAMOROKA);
		regExpBrowsers.put(".*Shiretoko/(?<version>[0-9.]+).*", BrowserType.SHIRETOKO);
		regExpBrowsers.put(".*Minefield/(?<version>[0-9.]+).*", BrowserType.MINEFIELD);
		regExpBrowsers.put(".*Puffin/(?<version>[0-9.]+).*", BrowserType.PUFFIN);
		regExpBrowsers.put(".*OviBrowser/(?<version>[0-9.]+).*", BrowserType.OVIBROWSER);
		regExpBrowsers.put(".*Stainless/(?<version>[0-9.]+).*", BrowserType.STAINLESS);
		regExpBrowsers.put(".*MZBrowser/(?<version>[0-9.]+).*", BrowserType.MZBROWSER);
		regExpBrowsers.put(".*Amigo/(?<version>[0-9.]+).*", BrowserType.AMIGO);
		regExpBrowsers.put(".*Whale/(?<version>[0-9.]+).*", BrowserType.NAVER_WHALE);
		regExpBrowsers.put(".*Elements Browser/(?<version>[0-9.]+).*", BrowserType.ELEMENTS_BROWSER);
		regExpBrowsers.put(".*HuaweiBrowser/(?<version>[0-9.]+).*", BrowserType.HUAWEIBROWSER);
		regExpBrowsers.put(".*LG Browser/(?<version>[0-9.]+).*", BrowserType.LG_BROWSER);
		regExpBrowsers.put(".*bingweb/(?<version>[0-9.]+).*", BrowserType.BING_SEARCH_APP);
		regExpBrowsers.put(".*sputnikbrowser/(?<version>[0-9.]+).*", BrowserType.SPUTNIK_BROWSER);
		regExpBrowsers.put(".*nintendobrowser/(?<version>[0-9.]+).*", BrowserType.NINTENDO_BROWSER);
		regExpBrowsers.put(".*Crazy Browser/(?<version>[0-9.]+).*", BrowserType.CRAZY_BROWSER);
		regExpBrowsers.put(".*Crazy Browser (?<version>[0-9.]+).*", BrowserType.CRAZY_BROWSER);
		regExpBrowsers.put(".*coc_coc_browser/(?<version>[0-9.]+).*", BrowserType.COC_COC_BROWSER);
		regExpBrowsers.put(".*Sleipnir/(?<version>[0-9.]+).*", BrowserType.SLEIPNIR);
		regExpBrowsers.put(".*vivaldi/(?<version>[0-9.]+).*", BrowserType.VIVALDI);
		regExpBrowsers.put(".*FxiOS/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		regExpBrowsers.put(".*yabrowser/(?<version>[0-9.]+).*", BrowserType.YANDEX_BROWSER);
		regExpBrowsers.put(".*YaSearchBrowser/(?<version>[0-9.]+).*", BrowserType.YANDEX_BROWSER);
		regExpBrowsers.put(".*otter/(?<version>[0-9.]+).*", BrowserType.OTTER_BROWSER);
		regExpBrowsers.put(".*maxthon/(?<version>[0-9.]+).*", BrowserType.MAXTHON);
		regExpBrowsers.put(".*konqueror/(?<version>[0-9.]+).*", BrowserType.KONQUEROR);
		regExpBrowsers.put(".*iron/(?<version>[0-9.]+).*", BrowserType.SRWARE_IRON);
		regExpBrowsers.put(".*seamonkey/(?<version>[0-9.]+).*", BrowserType.SEAMONKEY);
		regExpBrowsers.put(".*aol/(?<version>[0-9.]+).*", BrowserType.AOL_BROWSER);
		regExpBrowsers.put(".*iceweasel/(?<version>[0-9.]+).*", BrowserType.ICEWEASEL);
		regExpBrowsers.put(".*epiphany/(?<version>[0-9.]+).*", BrowserType.EPIPHANY);
		regExpBrowsers.put(".*kazehakase/(?<version>[0-9.]+).*", BrowserType.KAZEHAKASE);
		regExpBrowsers.put(".*flock/(?<version>[0-9.]+).*", BrowserType.FLOCK);
		regExpBrowsers.put(".*netscape/(?<version>[0-9.]+).*", BrowserType.NETSCAPE_NAVIGATOR);
		regExpBrowsers.put(".*phoenix/(?<version>[0-9.]+).*", BrowserType.PHOENIX_BROWSER);
		regExpBrowsers.put(".*arora/(?<version>[0-9.]+).*", BrowserType.ARORA);
		regExpBrowsers.put(".*minimo/(?<version>[0-9.]+).*", BrowserType.MINIMO);
		regExpBrowsers.put(".*version/(?<version>[0-9.]+) omniweb/[0-9.]+.*", BrowserType.OMNIWEB);
		regExpBrowsers.put(".*omniweb/v(?<version>[0-9.]+).*", BrowserType.OMNIWEB);
		regExpBrowsers.put(".*shiira/(?<version>[0-9.]+).*", BrowserType.SHIIRA);
		regExpBrowsers.put(".*sunrisebrowser/(?<version>[0-9.]+).*", BrowserType.SUNRISE_BROWSER);
		regExpBrowsers.put(".*galeon/(?<version>[0-9.]+).*", BrowserType.GALEON);
		regExpBrowsers.put(".*icecat/(?<version>[0-9.]+).*", BrowserType.ICECAT);
		regExpBrowsers.put(".*nokiabrowser/(?<version>[0-9.]+).*", BrowserType.NOKIA_BROWSER);
		regExpBrowsers.put(".*camino/(?<version>[0-9.]+).*", BrowserType.CAMINO);
		regExpBrowsers.put(".*chimera/(?<version>[0-9.]+).*", BrowserType.CHIMERA);
		regExpBrowsers.put(".*iceape/(?<version>[0-9.]+).*", BrowserType.ICEAPE);
		regExpBrowsers.put(".*midori/(?<version>[0-9.]+).*", BrowserType.MIDORI);
		regExpBrowsers.put(".*leechcraft/(?<version>[0-9.]+).*", BrowserType.LEECHCRAFT);
		regExpBrowsers.put(".*miuibrowser/(?<version>[0-9.]+).*", BrowserType.MIUI_BROWSER);
		regExpBrowsers.put(".*miui/v(?<version>[0-9.]+).*", BrowserType.MIUI_BROWSER);
		regExpBrowsers.put(".*baiduhd/(?<version>[0-9.]+).*", BrowserType.BAIDU_BROWSER_HD);
		regExpBrowsers.put(".*palemoon/(?<version>[0-9.]+).*", BrowserType.PALE_MOON);
		regExpBrowsers.put(".*alohabrowser/(?<version>[0-9.]+).*", BrowserType.ALOHA_BROWSER);
		regExpBrowsers.put(".*samsungbrowser/(?<version>[0-9.]+).*", BrowserType.SAMSUNG_BROWSER);
		regExpBrowsers.put(".*dolphin/(?<version>[0-9.]+).*", BrowserType.DOLPHIN_BROWSER);
		regExpBrowsers.put(".*mercury/(?<version>[0-9.]+).*", BrowserType.MERCURY);
		regExpBrowsers.put(".*k-meleon/(?<version>[0-9.]+).*", BrowserType.K_MELEON);
		regExpBrowsers.put(".*qqbrowser/(?<version>[0-9.]+).*", BrowserType.QQBROWSER);
		regExpBrowsers.put(".*ucbrowser/(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		regExpBrowsers.put(".*UBrowser/(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		regExpBrowsers.put(".*uc browser(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		regExpBrowsers.put(".*ucbrowser(?<version>[0-9.]+).*", BrowserType.UCBROWSER);
		regExpBrowsers.put(".*netfront/(?<version>[0-9.]+).*", BrowserType.NETFRONT);
		regExpBrowsers.put(".*BIDUBrowser/(?<version>[0-9.]+).*", BrowserType.BAIDU_BROWSER);
		regExpBrowsers.put(".*iemobile (?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		regExpBrowsers.put(".*iemobile/(?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		regExpBrowsers.put(".*EdgiOS/(?<version>[0-9.]+).*", BrowserType.EDGE);
		regExpBrowsers.put(".*Edge/(?<version>[0-9.]+).*", BrowserType.EDGE);
		regExpBrowsers.put(".*EdgA/(?<version>[0-9.]+).*", BrowserType.EDGE);
		regExpBrowsers.put(".*EdgW/(?<version>[0-9.]+).*", BrowserType.EDGE);
		regExpBrowsers.put(".*Edg/(?<version>[0-9.]+).*", BrowserType.EDGE);
		regExpBrowsers.put(".*opera mini/[0-9.]+.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		regExpBrowsers.put(".*opera mini/.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		regExpBrowsers.put(".*opera mini/(?<version>[0-9.]+).*", BrowserType.OPERA_MINI);
		regExpBrowsers.put(".*opera mobi/.*version/(?<version>[0-9.]+).*", BrowserType.OPERA_MOBI);
		regExpBrowsers.put(".*opera mobi/(?<version>[0-9.]+).*", BrowserType.OPERA_MOBI);
		regExpBrowsers.put(".*opios/(?<version>[0-9.]+).*", BrowserType.OPERA);
		regExpBrowsers.put(".*opr/(?<version>[0-9.]+).*", BrowserType.OPERA);
		regExpBrowsers.put(".*opt/(?<version>[0-9.]+).", BrowserType.OPERA_TOUCH);
		regExpBrowsers.put(".*opera/[0-9.]+.*version/(?<version>[0-9.]+).*", BrowserType.OPERA);
		regExpBrowsers.put(".*opera (?<version>[0-9.]+).*", BrowserType.OPERA);
		regExpBrowsers.put(".*opera/(?<version>[0-9.]+).*", BrowserType.OPERA);
		regExpBrowsers.put(".*CriOS/(?<version>[0-9.]+).*", BrowserType.GOOGLE_CHROME);
		regExpBrowsers.put(".*chromium/(?<version>[0-9.]+).*", BrowserType.CHROMIUM);
		regExpBrowsers.put(".*Quark/(?<version>[0-9.]+).*", BrowserType.QUARK);
		regExpBrowsers.put(".*Surf/(?<version>[0-9.]+).*", BrowserType.SURF);
		regExpBrowsers.put(".*Firefox/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		regExpBrowsers.put(".*fennec/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		regExpBrowsers.put(".*Focus/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		regExpBrowsers.put(".*Firebird/(?<version>[0-9.]+).*", BrowserType.FIREFOX);
		regExpBrowsers.put(".*MSIE (?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		regExpBrowsers.put(".*trident/[0-9.]+.*rv:(?<version>[0-9.]+).*", BrowserType.INTERNET_EXPLORER);
		regExpBrowsers.put(".*version/(?<version>[0-9.]+) mobile/[a-z0-9]+ safari/[0-9.]+.*", BrowserType.SAFARI);
		regExpBrowsers.put(".*version/(?<version>[0-9.]+) mobile safari/[0-9.]+.*", BrowserType.SAFARI);
		regExpBrowsers.put(".*version/(?<version>[0-9.]+) safari/[0-9.]+.*", BrowserType.SAFARI);
		regExpBrowsers.put(".*Chrome/(?<version>[0-9.]+) Mobile.*", BrowserType.GOOGLE_CHROME);
		regExpBrowsers.put(".*Chrome/(?<version>[0-9.]+) Safari.*", BrowserType.GOOGLE_CHROME);

		return regExpBrowsers;
	}
}
