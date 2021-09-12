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
 * Класс определяющий операционную систему.
 */
public class OperatingSystem
{
	/**
	 * Строка user-agent.
	 */
	@Nullable
	private String userAgent = null;

	/**
	 * Версия операционной системы.
	 */
	@Nullable
	private String version = null;

	/**
	 * Тип операционной системы.
	 *
	 * @see OperatingSystemType
	 */
	private OperatingSystemType operatingSystem = OperatingSystemType.UNKNOWN;

	/**
	 * Список регулярных выражений для определения типа операционной системы.
	 *
	 * @see #getMapRegExp()
	 */
	private final Map<String, OperatingSystemType> mapRegExp = this.getMapRegExp();

	OperatingSystem() {}

	/**
	 * Возвращает название операционной системы по идентификатору
	 *
	 * @param id идентификатор операционной системы
	 * @return название операционной системы
	 */
	@Nullable
	public static String getById(@NotNull String id)
	{
		for (OperatingSystemType elm: OperatingSystemType.values())
		{
			if (elm != OperatingSystemType.UNKNOWN && elm.getId().equals(id))
			{
				return elm.getName();
			}
		}

		return null;
	}

	/**
	 * Возвращает идентификатор операционной системы по названию
	 *
	 * @param name название операционной системы
	 * @return идентификатор операционной системы
	 */
	@Nullable
	public static String getByName(@NotNull String name)
	{
		for (OperatingSystemType elm: OperatingSystemType.values())
		{
			if (elm != OperatingSystemType.UNKNOWN && elm.getName().equals(name))
			{
				return elm.getId();
			}
		}

		return null;
	}

	/**
	 * Возвращает все типы операционных систем
	 *
	 * @return идентификатор и название операционной системы
	 */
	public static Map<String, String> getAll()
	{
		Map<String, String> types = new HashMap<>();

		for (OperatingSystemType elm: OperatingSystemType.values())
		{
			if (elm != OperatingSystemType.UNKNOWN)
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
		this.operatingSystem = OperatingSystemType.UNKNOWN;
		this.version = null;

		if (userAgent != null && !userAgent.equals(""))
		{
			this.execute();
		}
	}

	@Nullable
	String getId()
	{
		return this.operatingSystem.getId();
	}

	@Nullable
	String getName()
	{
		return this.operatingSystem.getName();
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

		for (Map.Entry<String, OperatingSystemType> regExp : mapRegExp.entrySet())
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

				this.operatingSystem = regExp.getValue();
				break;
			}
		}
	}

	/**
	 * Возвращает список шаблонов регулярных выражений для определения операционной системы.
	 */
	private Map<String, OperatingSystemType> getMapRegExp()
	{
		Map<String, OperatingSystemType> mapRegExp = new LinkedHashMap<>();

		mapRegExp.put(".*Tizen/(?<version>[0-9.]+).*", OperatingSystemType.TIZEN);
		mapRegExp.put(".*KAIOS/(?<version>[0-9.]+).*", OperatingSystemType.KAIOS);
		mapRegExp.put(".*SunOS (?<version>[0-9.]+).*", OperatingSystemType.SOLARIS);
		mapRegExp.put(".*webOS.TV-(?<version>[0-9.]+).*", OperatingSystemType.WEBOS);
		mapRegExp.put(".*webOS/(?<version>[0-9.]+).*", OperatingSystemType.WEBOS);
		mapRegExp.put(".*kubuntu/(?<version>[0-9.]+).*", OperatingSystemType.KUBUNTU);
		mapRegExp.put(".*mandriva linux/(?<version>[0-9.]+).*", OperatingSystemType.MANDRIVA_LINUX);
		mapRegExp.put(".*asplinux/(?<version>[0-9.]+).*", OperatingSystemType.ASPLINUX);
		mapRegExp.put(".*suse/(?<version>[0-9.]+).*", OperatingSystemType.OPENSUSE);
		mapRegExp.put(".*bada/(?<version>[0-9.]+).*", OperatingSystemType.BADA);
		mapRegExp.put(".*darwin (?<version>[0-9.]+).*", OperatingSystemType.DARWIN);
		mapRegExp.put(".*darwin/(?<version>[0-9.]+).*", OperatingSystemType.DARWIN);
		mapRegExp.put(".*netbsd (?<version>[0-9.]+).*", OperatingSystemType.NETBSD);
		mapRegExp.put(".*amigaos (?<version>[0-9.]+).*", OperatingSystemType.AMIGAOS);
		mapRegExp.put(".*windows phone os (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_PHONE);
		mapRegExp.put(".*windows phone (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_PHONE);
		mapRegExp.put(".*windows ce (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_CE);
		mapRegExp.put(".*fedora/(?<version>[0-9.]+).*", OperatingSystemType.FEDORA);
		mapRegExp.put(".*linux mint/(?<version>[0-9.]+).*", OperatingSystemType.LINUX_MINT);
		mapRegExp.put(".*profile/midp-(?<version>[0-9.]+).*", OperatingSystemType.MIDP);
		mapRegExp.put(".*midp-(?<version>[0-9.]+).*", OperatingSystemType.MIDP);
		mapRegExp.put(".*centos/(?<version>[0-9.]+).*", OperatingSystemType.CENTOS);
		mapRegExp.put(".*red hat/(?<version>[0-9.]+).*", OperatingSystemType.RED_HAT);
		mapRegExp.put(".*CPU OS (?<version>[0-9._]+).*", OperatingSystemType.TV_OS);
		mapRegExp.put(".*ubuntu/(?<version>[0-9.]+).*", OperatingSystemType.UBUNTU);
		mapRegExp.put(".*iPad;CPU OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*iPod;CPU OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*iPhone OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*iPhone/(?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*iPad/(?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*iOS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		mapRegExp.put(".*macintosh;os x (?<version>[0-9._]+).*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*mac os x (?<version>[0-9._]+).*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*windowsnt(?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*win(?<version>95).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*win(?<version>98).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*winnt(?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*windows nt (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*windows (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*windows (?<version>me).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*windows (?<version>xp).*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*android (?<version>[0-9.]+).*", OperatingSystemType.ANDROID);

		mapRegExp.put(".*Tizen.*", OperatingSystemType.TIZEN);
		mapRegExp.put(".*MAUI.*", OperatingSystemType.MAUI);
		mapRegExp.put(".*CrOS.*", OperatingSystemType.CHROME_OS);
		mapRegExp.put(".*mac_powerpc.*", OperatingSystemType.MAC_OS_9);
		mapRegExp.put(".*PPC Mac OS X;.*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*webOS.*", OperatingSystemType.WEBOS);
		mapRegExp.put(".*j2me/midp.*", OperatingSystemType.MIDP);
		mapRegExp.put(".*profile/midp.*", OperatingSystemType.MIDP);
		mapRegExp.put(".*fedora.*", OperatingSystemType.FEDORA);
		mapRegExp.put(".*openbsd.*", OperatingSystemType.OPENBSD);
		mapRegExp.put(".*linux mint.*", OperatingSystemType.LINUX_MINT);
		mapRegExp.put(".*freebsd.*", OperatingSystemType.FREEBSD);
		mapRegExp.put(".*gentoo.*", OperatingSystemType.LINUX_GENTOO);
		mapRegExp.put(".*slackware.*", OperatingSystemType.SLACKWARE_LINUX);
		mapRegExp.put(".*windows ce.*", OperatingSystemType.WINDOWS_CE);
		mapRegExp.put(".*beos.*", OperatingSystemType.BEOS);
		mapRegExp.put(".*windows phone.*", OperatingSystemType.WINDOWS_PHONE);
		mapRegExp.put(".*symbian.*", OperatingSystemType.SYMBIAN_OS);
		mapRegExp.put(".*symbos.*", OperatingSystemType.SYMBIAN_OS);
		mapRegExp.put(".*SunOS.*", OperatingSystemType.SOLARIS);
		mapRegExp.put(".*opensolaris.*", OperatingSystemType.SOLARIS);
		mapRegExp.put(".*amigaos.*", OperatingSystemType.AMIGAOS);
		mapRegExp.put(".*haiku.*", OperatingSystemType.HAIKU);
		mapRegExp.put(".*windows mobile.*", OperatingSystemType.WINDOWS_MOBILE);
		mapRegExp.put(".*darwin.*", OperatingSystemType.DARWIN);
		mapRegExp.put(".*netbsd.*", OperatingSystemType.NETBSD);
		mapRegExp.put(".*blackberry.*", OperatingSystemType.BLACKBERRY_OS);
		mapRegExp.put(".*bada.*", OperatingSystemType.BADA);
		mapRegExp.put(".*kubuntu.*", OperatingSystemType.KUBUNTU);
		mapRegExp.put(".*centos.*", OperatingSystemType.CENTOS);
		mapRegExp.put(".*red hat.*", OperatingSystemType.RED_HAT);
		mapRegExp.put(".*ppc mac os x.*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*mac os x.*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*macintosh.*", OperatingSystemType.MAC_OS_X);
		mapRegExp.put(".*ubuntu.*", OperatingSystemType.UBUNTU);
		mapRegExp.put(".*windows.*", OperatingSystemType.WINDOWS);
		mapRegExp.put(".*android.*", OperatingSystemType.ANDROID);
		mapRegExp.put(".*linux.*", OperatingSystemType.LINUX);

		return mapRegExp;
	}
}
