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

import dev.kalenchukov.useragent.parsing.resources.DeviceType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс определяющий устройство.
 */
public final class Device
{
	/**
	 * Строка user-agent.
	 */
	@Nullable
	private String userAgent;

	/**
	 * Модель устройства.
	 */
	@Nullable
	private String model;

	/**
	 * Тип устройства.
	 *
	 * @see DeviceType
	 */
	@NotNull
	private DeviceType device;

	/**
	 * Список регулярных выражений для определения типа устройства.
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull DeviceType> regExpDevices;

	/**
	 * Конструктор для {@code Device}.
	 */
	public Device()
	{
		this.userAgent = null;
		this.model = null;
		this.device = DeviceType.UNKNOWN;
		this.regExpDevices = this.getRegExpDevices();
	}
	/**
	 * Возвращает все типы устройств.
	 *
	 * @return Коллекцию с типами устройств.
	 */
	@NotNull
	public static List<@NotNull String> getAll()
	{
		List<String> devices = new ArrayList<>();

		for (DeviceType device : DeviceType.values())
		{
			if (device != DeviceType.UNKNOWN) {
				devices.add(device.getType());
			}
		}

		return devices;
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
		this.device = DeviceType.UNKNOWN;
		this.model = null;

		if (!userAgent.isEmpty()) {
			this.execute();
		}
	}

	/**
	 * Возвращает тип устройства.
	 *
	 * @return Тип устройства.
	 */
	@Nullable
	public String getType()
	{
		return this.device.getType();
	}

	/**
	 * Возвращает модель устройства.
	 *
	 * @return Модель устройства.
	 */
	@Nullable
	public String getModel()
	{
		return this.model;
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

			for (Map.Entry<String, DeviceType> regExp : this.getRegExpDevices().entrySet())
			{
				pattern = Pattern.compile(regExp.getKey(), Pattern.CASE_INSENSITIVE);
				matcher = pattern.matcher(this.userAgent);

				if (matcher.matches())
				{
					if (matcher.groupCount() > 0) {
						this.model = matcher.group("model").trim();
					}

					this.device = regExp.getValue();
					break;
				}
			}
		}
	}

	/**
	 * Возвращает список шаблонов регулярных выражений для определения типа устройства.
	 *
	 * @return Коллекцию регулярных выражений для типов устройств.
	 */
	@NotNull
	private Map<@NotNull String, @NotNull DeviceType> getRegExpDevices()
	{
		Map<String, DeviceType> regExpDevices = new LinkedHashMap<>();

		// Определение с моделью
		regExpDevices.put(".*\\((?<model>iPod);.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\((?<model>iPod) touch;.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\((?<model>iPad);.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\((?<model>iPhone);.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\((?<model>iPhone [a-z0-9]+);.*", DeviceType.MOBILE);

		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\) [a-z0-9]+ [a-z0-9]+ AppleWebKit.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;[a-z];[a-z]{2}\\)Presto/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Maxthon AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;[a-z0-9]+;[a-z0-9]+\\).*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)Release/.*Browser/.*Build/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Release/.*Browser/.*Build/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)Build/.*AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Chrome/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Linux/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Mobile.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)/[0-9.]+ Android/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Gecko.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Mobile;.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)OPR/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Opera.*", DeviceType.MOBILE);

		regExpDevices.put(".*Android [0-9.]+;[a-z]{2};(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;[a-z]{2};(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);

		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;[a-z]{2}(\\-[a-z]+)?\\-[a-z]{2};\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;Tesseract/[0-9.]+\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Tesseract/[0-9.]+\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[[a-z0-9-_./:\s]+\\].*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;[a-z];\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z];[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Mobile;rv:[0-9.]+\\).*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Tablet;rv:[0-9.]+\\).*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*;wv\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*\\).*AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)YandexSearch/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z-_:]+/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\);[a-z-_:]+.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z-_:]+.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[ip.*\\]", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[FBAN.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Chrome/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Source/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z]+", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*Chrome/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)OPR/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Opera.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)$", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);HMSCore.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)MIUI/.*", DeviceType.MOBILE);

		regExpDevices.put(".*Android [0-9.]+;WebView/[0-9.]+;Microsoft;(?<model>(?!Build)[a-z0-9\s]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;Microsoft;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;arm_64;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;Mobile;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*rv:.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;arm;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;arm_64;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android [0-9.]+;NOKIA;(?<model>(?!Build)[a-z0-9\s]+)\\)AppleWebKit/.*", DeviceType.MOBILE);

		regExpDevices.put(".*Windows Phone [0-9.]+;Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,;)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*BlackBerry;[a-z];(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\-[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*BlackBerry;[a-z];(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Linux;Tizen [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		regExpDevices.put(".*rv:[0-9.]+;IEMobile.*NOKIA;(?<model>(?!Build)[a-z0-9\s]+);[a-z0-9]+\\).*", DeviceType.MOBILE);
		regExpDevices.put(".*Android;Mobile;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);rv:.*Gecko/.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\(SAMSUNG;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z];Bada/.*", DeviceType.MOBILE);
		regExpDevices.put(".*IEMobile.*Microsoft;(?<model>(?!Build)[a-z0-9\s]+)\\).*", DeviceType.MOBILE);
		regExpDevices.put(".*IEMobile.*NOKIA;(?<model>(?!Build)[a-z0-9\s]+)\\).*", DeviceType.MOBILE);

		// Определение без модели
		regExpDevices.put(".*Tablet;rv:.*", DeviceType.TABLET);
		regExpDevices.put(".*tablet_PC\\).*", DeviceType.TABLET);

		regExpDevices.put(".*Cortana.*", DeviceType.VIRTUAL_ASSISTANT);
		regExpDevices.put(".*YaSearchBrowser.*", DeviceType.VIRTUAL_ASSISTANT);
		regExpDevices.put(".*HomePod.*", DeviceType.VIRTUAL_ASSISTANT);

		regExpDevices.put(".*Nintendo.*", DeviceType.GAME_CONSOLE);
		regExpDevices.put(".*PlayStation.*", DeviceType.GAME_CONSOLE);

		regExpDevices.put(".*AppleTV.*", DeviceType.TV);
		regExpDevices.put(".*DuneHD.*", DeviceType.TV);
		regExpDevices.put(".*Dune HD TV.*", DeviceType.TV);
		regExpDevices.put(".*DuneHD-CWMP.*", DeviceType.TV);
		regExpDevices.put(".*GoogleTV.*", DeviceType.TV);
		regExpDevices.put(".*HbbTV.*", DeviceType.TV);
		regExpDevices.put(".*LG NetCast\\.TV.*", DeviceType.TV);
		regExpDevices.put(".*Viera.*", DeviceType.TV);
		regExpDevices.put(".*PHILIPSTV.*", DeviceType.TV);
		regExpDevices.put(".*POV_TV.*", DeviceType.TV);
		regExpDevices.put(".*Roku/DVP.*", DeviceType.TV);
		regExpDevices.put(".*SMART-TV.*", DeviceType.TV);
		regExpDevices.put(".*SmartTV.*", DeviceType.TV);
		regExpDevices.put(".*Smartlabs.*", DeviceType.TV);
		regExpDevices.put(".*TSBNetTV.*", DeviceType.TV);
		regExpDevices.put(".*MTSTVBOX.*", DeviceType.TV);
		regExpDevices.put(".*Sony-KDL.*", DeviceType.TV);

		regExpDevices.put(".*Windows Mobile.*", DeviceType.MOBILE);
		regExpDevices.put(".*SamsungBrowser.*", DeviceType.MOBILE);
		regExpDevices.put(".*Windows Phone.*", DeviceType.MOBILE);
		regExpDevices.put(".*AlohaBrowser.*", DeviceType.MOBILE);
		regExpDevices.put(".*NokiaBrowser.*", DeviceType.MOBILE);
		regExpDevices.put(".*MiuiBrowser.*", DeviceType.MOBILE);
		regExpDevices.put(".*Opera Mobi.*", DeviceType.MOBILE);
		regExpDevices.put(".*Opera Mini.*", DeviceType.MOBILE);
		regExpDevices.put(".*UC Browser.*", DeviceType.MOBILE);
		regExpDevices.put(".*Windows CE.*", DeviceType.MOBILE);
		regExpDevices.put(".*Blackberry.*", DeviceType.MOBILE);
		regExpDevices.put(".*UCBrowser.*", DeviceType.MOBILE);
		regExpDevices.put(".*NetFront.*", DeviceType.MOBILE);
		regExpDevices.put(".*Dolphin.*", DeviceType.MOBILE);
		regExpDevices.put(".*BaiduHD.*", DeviceType.MOBILE);
		regExpDevices.put(".*BingWeb.*", DeviceType.MOBILE);
		regExpDevices.put(".*Mobile/.*", DeviceType.MOBILE);
		regExpDevices.put(".*Minimo.*", DeviceType.MOBILE);
		regExpDevices.put(".*Kindle.*", DeviceType.MOBILE);
		regExpDevices.put(".*Focus.*", DeviceType.MOBILE);
		regExpDevices.put(".*MIUI.*", DeviceType.MOBILE);
		regExpDevices.put(".*Bada.*", DeviceType.MOBILE);
		regExpDevices.put(".*IEMobile.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\(iPod;.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\(iPod touch;.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\(iPad;.*", DeviceType.MOBILE);
		regExpDevices.put(".*\\(iPhone;.*", DeviceType.MOBILE);
		regExpDevices.put(".*Android.*", DeviceType.MOBILE);

		regExpDevices.put(".*Mac_PowerPC.*", DeviceType.PC);
		regExpDevices.put(".*Macintosh.*", DeviceType.PC);
		regExpDevices.put(".*AmigaOS.*", DeviceType.PC);
		regExpDevices.put(".*NetBSD.*", DeviceType.PC);
		regExpDevices.put(".*Darwin.*", DeviceType.PC);
		regExpDevices.put(".*Haiku.*", DeviceType.PC);
		regExpDevices.put(".*OS/2.*", DeviceType.PC);
		regExpDevices.put(".*Suse.*", DeviceType.PC);
		regExpDevices.put(".*Kubuntu.*", DeviceType.PC);
		regExpDevices.put(".*Ubuntu.*", DeviceType.PC);
		regExpDevices.put(".*Linux.*", DeviceType.PC);
		regExpDevices.put(".*Mac OS.*", DeviceType.PC);
		regExpDevices.put(".*Windows.*", DeviceType.PC);
		regExpDevices.put(".*Win.*", DeviceType.PC);

		return regExpDevices;
	}
}
