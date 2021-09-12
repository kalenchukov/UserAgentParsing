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
 * Класс определяющий устройство.
 */
public class Device
{
	/**
	 * Строка user-agent.
	 */
	@Nullable
	private String userAgent = null;

	/**
	 * Модель устройства.
	 */
	@Nullable
	private String model = null;

	/**
	 * Тип устройства.
	 *
	 * @see DeviceType
	 */
	private DeviceType device = DeviceType.UNKNOWN;

	/**
	 * Список регулярных выражений для определения типа устройства.
	 *
	 * @see #getMapRegExp()
	 */
	private final Map<String, DeviceType> mapRegExp = this.getMapRegExp();

	Device() {}

	/**
	 * Возвращает тип устройства по идентификатору
	 *
	 * @param id идентификатор устройства
	 * @return тип устройства
	 */
	@Nullable
	public static String getById(@NotNull String id)
	{
		for (DeviceType elm: DeviceType.values())
		{
			if (elm != DeviceType.UNKNOWN && elm.getId().equals(id))
			{
				return elm.getType();
			}
		}

		return null;
	}

	/**
	 * Возвращает идентификатор устройства по типу
	 *
	 * @param type тип устройства
	 * @return идентификатор устройства
	 */
	@Nullable
	public static String getByType(@NotNull String type)
	{
		for (DeviceType elm: DeviceType.values())
		{
			if (elm != DeviceType.UNKNOWN && elm.getType().equals(type))
			{
				return elm.getId();
			}
		}

		return null;
	}

	/**
	 * Возвращает все типы устройств
	 *
	 * @return идентификатор и тип устройства
	 */
	public static Map<String, String> getAll()
	{
		Map<String, String> types = new HashMap<>();

		for (DeviceType elm: DeviceType.values())
		{
			if (elm != DeviceType.UNKNOWN)
			{
				types.put(elm.getId(), elm.getType());
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
		this.device = DeviceType.UNKNOWN;
		this.model = null;

		if (userAgent != null && !userAgent.equals(""))
		{
			this.execute();
		}
	}

	@Nullable
	String getId()
	{
		return this.device.getId();
	}

	@Nullable
	String getType()
	{
		return this.device.getType();
	}

	@Nullable
	String getModel()
	{
		return this.model;
	}

	/**
	 * Выполняет поиск шаблона регулярного выражения в строке user-agent.
	 */
	private void execute()
	{
		Pattern pattern;
		Matcher matcher;

		for (Map.Entry<String, DeviceType> regExp : this.getMapRegExp().entrySet())
		{
			pattern = Pattern.compile(regExp.getKey(), Pattern.CASE_INSENSITIVE);
			matcher = pattern.matcher(this.userAgent);

			if (matcher.matches())
			{
				if (matcher.groupCount() > 0)
				{
					this.model = matcher.group("model")
										.trim();
				}

				this.device = regExp.getValue();
				break;
			}
		}
	}

	/**
	 * Возвращает список шаблонов регулярных выражений для определения устройства.
	 */
	private Map<String, DeviceType> getMapRegExp()
	{
		Map<String, DeviceType> mapRegExp = new LinkedHashMap<>();

		// Определение с моделью
		mapRegExp.put(".*\\((?<model>iPod);.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\((?<model>iPod) touch;.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\((?<model>iPad);.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\((?<model>iPhone);.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\((?<model>iPhone [a-z0-9]+);.*", DeviceType.MOBILE);

		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\) [a-z0-9]+ [a-z0-9]+ AppleWebKit.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;[a-z];[a-z]{2}\\)Presto/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Maxthon AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;[a-z0-9]+;[a-z0-9]+\\).*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)Release/.*Browser/.*Build/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Release/.*Browser/.*Build/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)Build/.*AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Chrome/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Linux/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Mobile.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)/[0-9.]+ Android/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Gecko.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Mobile;.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)OPR/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2}\\-([a-z]+\\-)?([a-z]{2})?;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Opera.*", DeviceType.MOBILE);

		mapRegExp.put(".*Android [0-9.]+;[a-z]{2};(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;[a-z]{2};(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);

		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;[a-z]{2}(\\-[a-z]+)?\\-[a-z]{2};\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;Tesseract/[0-9.]+\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Tesseract/[0-9.]+\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[[a-z0-9-_./:\s]+\\].*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);Build/.*;[a-z];\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z];[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Mobile;rv:[0-9.]+\\).*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Tablet;rv:[0-9.]+\\).*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*;wv\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*\\).*AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)YandexSearch/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z-_:]+/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\);[a-z-_:]+.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z-_:]+.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[ip.*\\]", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[FBAN.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Chrome/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)Source/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)[a-z]+", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*Chrome/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)OPR/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*;Opera.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)\\[", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)Build/.*\\)$", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);HMSCore.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)MIUI/.*", DeviceType.MOBILE);

		mapRegExp.put(".*Android [0-9.]+;WebView/[0-9.]+;Microsoft;(?<model>(?!Build)[a-z0-9\s]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;Microsoft;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;arm_64;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;Mobile;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+#]+)Build/.*rv:.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;arm;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;arm_64;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android [0-9.]+;NOKIA;(?<model>(?!Build)[a-z0-9\s]+)\\)AppleWebKit/.*", DeviceType.MOBILE);

		mapRegExp.put(".*Windows Phone [0-9.]+;Android [0-9.]+;(?<model>(?!Build)[a-z0-9_.,;)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*BlackBerry;[a-z];(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\-[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*BlackBerry;[a-z];(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z]{2}\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Linux;Tizen [0-9.]+;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+)\\)AppleWebKit/.*", DeviceType.MOBILE);
		mapRegExp.put(".*rv:[0-9.]+;IEMobile.*NOKIA;(?<model>(?!Build)[a-z0-9\s]+);[a-z0-9]+\\).*", DeviceType.MOBILE);
		mapRegExp.put(".*Android;Mobile;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);rv:.*Gecko/.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\(SAMSUNG;(?<model>(?!Build)[a-z0-9_.,)/(\s\\-+]+);[a-z];Bada/.*", DeviceType.MOBILE);
		mapRegExp.put(".*IEMobile.*Microsoft;(?<model>(?!Build)[a-z0-9\s]+)\\).*", DeviceType.MOBILE);
		mapRegExp.put(".*IEMobile.*NOKIA;(?<model>(?!Build)[a-z0-9\s]+)\\).*", DeviceType.MOBILE);

		// Определение без модели
		mapRegExp.put(".*Tablet;rv:.*", DeviceType.TABLET);
		mapRegExp.put(".*tablet_PC\\).*", DeviceType.TABLET);

		mapRegExp.put(".*Cortana.*", DeviceType.VIRTUAL_ASSISTANT);
		mapRegExp.put(".*YaSearchBrowser.*", DeviceType.VIRTUAL_ASSISTANT);
		mapRegExp.put(".*HomePod.*", DeviceType.VIRTUAL_ASSISTANT);

		mapRegExp.put(".*Nintendo.*", DeviceType.GAME_CONSOLE);
		mapRegExp.put(".*PlayStation.*", DeviceType.GAME_CONSOLE);

		mapRegExp.put(".*AppleTV.*", DeviceType.TV);
		mapRegExp.put(".*DuneHD.*", DeviceType.TV);
		mapRegExp.put(".*Dune HD TV.*", DeviceType.TV);
		mapRegExp.put(".*DuneHD-CWMP.*", DeviceType.TV);
		mapRegExp.put(".*GoogleTV.*", DeviceType.TV);
		mapRegExp.put(".*HbbTV.*", DeviceType.TV);
		mapRegExp.put(".*LG NetCast\\.TV.*", DeviceType.TV);
		mapRegExp.put(".*Viera.*", DeviceType.TV);
		mapRegExp.put(".*PHILIPSTV.*", DeviceType.TV);
		mapRegExp.put(".*POV_TV.*", DeviceType.TV);
		mapRegExp.put(".*Roku/DVP.*", DeviceType.TV);
		mapRegExp.put(".*SMART-TV.*", DeviceType.TV);
		mapRegExp.put(".*SmartTV.*", DeviceType.TV);
		mapRegExp.put(".*Smartlabs.*", DeviceType.TV);
		mapRegExp.put(".*TSBNetTV.*", DeviceType.TV);
		mapRegExp.put(".*MTSTVBOX.*", DeviceType.TV);
		mapRegExp.put(".*Sony-KDL.*", DeviceType.TV);

		mapRegExp.put(".*Windows Mobile.*", DeviceType.MOBILE);
		mapRegExp.put(".*SamsungBrowser.*", DeviceType.MOBILE);
		mapRegExp.put(".*Windows Phone.*", DeviceType.MOBILE);
		mapRegExp.put(".*AlohaBrowser.*", DeviceType.MOBILE);
		mapRegExp.put(".*NokiaBrowser.*", DeviceType.MOBILE);
		mapRegExp.put(".*MiuiBrowser.*", DeviceType.MOBILE);
		mapRegExp.put(".*Opera Mobi.*", DeviceType.MOBILE);
		mapRegExp.put(".*Opera Mini.*", DeviceType.MOBILE);
		mapRegExp.put(".*UC Browser.*", DeviceType.MOBILE);
		mapRegExp.put(".*Windows CE.*", DeviceType.MOBILE);
		mapRegExp.put(".*Blackberry.*", DeviceType.MOBILE);
		mapRegExp.put(".*UCBrowser.*", DeviceType.MOBILE);
		mapRegExp.put(".*NetFront.*", DeviceType.MOBILE);
		mapRegExp.put(".*Dolphin.*", DeviceType.MOBILE);
		mapRegExp.put(".*BaiduHD.*", DeviceType.MOBILE);
		mapRegExp.put(".*BingWeb.*", DeviceType.MOBILE);
		mapRegExp.put(".*Mobile/.*", DeviceType.MOBILE);
		mapRegExp.put(".*Minimo.*", DeviceType.MOBILE);
		mapRegExp.put(".*Kindle.*", DeviceType.MOBILE);
		mapRegExp.put(".*Focus.*", DeviceType.MOBILE);
		mapRegExp.put(".*MIUI.*", DeviceType.MOBILE);
		mapRegExp.put(".*Bada.*", DeviceType.MOBILE);
		mapRegExp.put(".*IEMobile.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\(iPod;.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\(iPod touch;.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\(iPad;.*", DeviceType.MOBILE);
		mapRegExp.put(".*\\(iPhone;.*", DeviceType.MOBILE);
		mapRegExp.put(".*Android.*", DeviceType.MOBILE);

		mapRegExp.put(".*Mac_PowerPC.*", DeviceType.PC);
		mapRegExp.put(".*Macintosh.*", DeviceType.PC);
		mapRegExp.put(".*AmigaOS.*", DeviceType.PC);
		mapRegExp.put(".*NetBSD.*", DeviceType.PC);
		mapRegExp.put(".*Darwin.*", DeviceType.PC);
		mapRegExp.put(".*Haiku.*", DeviceType.PC);
		mapRegExp.put(".*OS/2.*", DeviceType.PC);
		mapRegExp.put(".*Suse.*", DeviceType.PC);
		mapRegExp.put(".*Kubuntu.*", DeviceType.PC);
		mapRegExp.put(".*Ubuntu.*", DeviceType.PC);
		mapRegExp.put(".*Linux.*", DeviceType.PC);
		mapRegExp.put(".*Mac OS.*", DeviceType.PC);
		mapRegExp.put(".*Windows.*", DeviceType.PC);
		mapRegExp.put(".*Win.*", DeviceType.PC);

		return mapRegExp;
	}
}
