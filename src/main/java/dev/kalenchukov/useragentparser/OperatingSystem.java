/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import dev.kalenchukov.useragentparser.resources.OperatingSystemType;
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
	@NotNull
	private OperatingSystemType operatingSystem = OperatingSystemType.UNKNOWN;

	/**
	 * Список регулярных выражений для определения типа операционной системы.
	 *
	 * @see #getRegExpOperatingSystems()
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull OperatingSystemType> regExpOperatingSystems = this.getRegExpOperatingSystems();

	OperatingSystem() {}

	/**
	 * Возвращает название операционной системы по идентификатору
	 *
	 * @param id идентификатор операционной системы
	 * @return название операционной системы
	 */
	@Nullable
	public static String getById(@NotNull final Long id)
	{
		for (OperatingSystemType operatingSystem: OperatingSystemType.values())
		{
			if (operatingSystem.getId() != null)
			{
				if (operatingSystem != OperatingSystemType.UNKNOWN && operatingSystem.getId().equals(id))
				{
					return operatingSystem.getName();
				}
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
	public static Long getByName(@NotNull final String name)
	{
		for (OperatingSystemType operatingSystem: OperatingSystemType.values())
		{
			if (operatingSystem.getName() != null)
			{
				if (operatingSystem != OperatingSystemType.UNKNOWN && operatingSystem.getName().equals(name))
				{
					return operatingSystem.getId();
				}
			}
		}

		return null;
	}

	/**
	 * Возвращает все типы операционных систем
	 *
	 * @return идентификатор и название операционной системы
	 */
	@NotNull
	public static Map<@NotNull Long, @NotNull String> getAll()
	{
		Map<Long, String> typesOperatingSystem = new HashMap<>();

		for (OperatingSystemType operatingSystem: OperatingSystemType.values())
		{
			if (operatingSystem != OperatingSystemType.UNKNOWN)
			{
				typesOperatingSystem.put(operatingSystem.getId(), operatingSystem.getName());
			}
		}

		return typesOperatingSystem;
	}

	/**
	 * Устанавливает строку user-agent.
	 *
	 * @param userAgent строка user-agent
	 */
	void setUserAgent(@NotNull final String userAgent)
	{
		this.userAgent = userAgent;
		this.operatingSystem = OperatingSystemType.UNKNOWN;
		this.version = null;

		if (!userAgent.equals(""))
		{
			this.execute();
		}
	}

	@Nullable
	Long getId()
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
		if (this.userAgent != null)
		{
			Pattern pattern;
			Matcher matcher;

			for (Map.Entry<String, OperatingSystemType> regExp : regExpOperatingSystems.entrySet())
			{
				pattern = Pattern.compile(regExp.getKey(), Pattern.CASE_INSENSITIVE);
				matcher = pattern.matcher(this.userAgent);

				if (matcher.matches())
				{
					if (matcher.groupCount() > 0)
					{
						this.version = matcher.group("version").replace("_", ".").trim();
					}

					this.operatingSystem = regExp.getValue();
					break;
				}
			}
		}
	}

	/**
	 * Возвращает список шаблонов регулярных выражений для определения операционной системы.
	 */
	@NotNull
	private Map<@NotNull String, @NotNull OperatingSystemType> getRegExpOperatingSystems()
	{
		Map<String, OperatingSystemType> regExpOperatingSystems = new LinkedHashMap<>();

		regExpOperatingSystems.put(".*Tizen/(?<version>[0-9.]+).*", OperatingSystemType.TIZEN);
		regExpOperatingSystems.put(".*KAIOS/(?<version>[0-9.]+).*", OperatingSystemType.KAIOS);
		regExpOperatingSystems.put(".*SunOS (?<version>[0-9.]+).*", OperatingSystemType.SOLARIS);
		regExpOperatingSystems.put(".*webOS.TV-(?<version>[0-9.]+).*", OperatingSystemType.WEBOS);
		regExpOperatingSystems.put(".*webOS/(?<version>[0-9.]+).*", OperatingSystemType.WEBOS);
		regExpOperatingSystems.put(".*kubuntu/(?<version>[0-9.]+).*", OperatingSystemType.KUBUNTU);
		regExpOperatingSystems.put(".*mandriva linux/(?<version>[0-9.]+).*", OperatingSystemType.MANDRIVA_LINUX);
		regExpOperatingSystems.put(".*asplinux/(?<version>[0-9.]+).*", OperatingSystemType.ASPLINUX);
		regExpOperatingSystems.put(".*suse/(?<version>[0-9.]+).*", OperatingSystemType.OPENSUSE);
		regExpOperatingSystems.put(".*bada/(?<version>[0-9.]+).*", OperatingSystemType.BADA);
		regExpOperatingSystems.put(".*darwin (?<version>[0-9.]+).*", OperatingSystemType.DARWIN);
		regExpOperatingSystems.put(".*darwin/(?<version>[0-9.]+).*", OperatingSystemType.DARWIN);
		regExpOperatingSystems.put(".*netbsd (?<version>[0-9.]+).*", OperatingSystemType.NETBSD);
		regExpOperatingSystems.put(".*amigaos (?<version>[0-9.]+).*", OperatingSystemType.AMIGAOS);
		regExpOperatingSystems.put(".*windows phone os (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_PHONE);
		regExpOperatingSystems.put(".*windows phone (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_PHONE);
		regExpOperatingSystems.put(".*windows ce (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS_CE);
		regExpOperatingSystems.put(".*fedora/(?<version>[0-9.]+).*", OperatingSystemType.FEDORA);
		regExpOperatingSystems.put(".*linux mint/(?<version>[0-9.]+).*", OperatingSystemType.LINUX_MINT);
		regExpOperatingSystems.put(".*profile/midp-(?<version>[0-9.]+).*", OperatingSystemType.MIDP);
		regExpOperatingSystems.put(".*midp-(?<version>[0-9.]+).*", OperatingSystemType.MIDP);
		regExpOperatingSystems.put(".*centos/(?<version>[0-9.]+).*", OperatingSystemType.CENTOS);
		regExpOperatingSystems.put(".*red hat/(?<version>[0-9.]+).*", OperatingSystemType.RED_HAT);
		regExpOperatingSystems.put(".*CPU OS (?<version>[0-9._]+).*", OperatingSystemType.TV_OS);
		regExpOperatingSystems.put(".*ubuntu/(?<version>[0-9.]+).*", OperatingSystemType.UBUNTU);
		regExpOperatingSystems.put(".*iPad;CPU OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*iPod;CPU OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*iPhone OS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*iPhone/(?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*iPad/(?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*iOS (?<version>[0-9_]+).*", OperatingSystemType.IOS);
		regExpOperatingSystems.put(".*macintosh;os x (?<version>[0-9._]+).*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*mac os x (?<version>[0-9._]+).*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*windowsnt(?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*win(?<version>95).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*win(?<version>98).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*winnt(?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*windows nt (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*windows (?<version>[0-9.]+).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*windows (?<version>me).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*windows (?<version>xp).*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*android (?<version>[0-9.]+).*", OperatingSystemType.ANDROID);

		regExpOperatingSystems.put(".*Tizen.*", OperatingSystemType.TIZEN);
		regExpOperatingSystems.put(".*MAUI.*", OperatingSystemType.MAUI);
		regExpOperatingSystems.put(".*CrOS.*", OperatingSystemType.CHROME_OS);
		regExpOperatingSystems.put(".*mac_powerpc.*", OperatingSystemType.MAC_OS_9);
		regExpOperatingSystems.put(".*PPC Mac OS X;.*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*webOS.*", OperatingSystemType.WEBOS);
		regExpOperatingSystems.put(".*j2me/midp.*", OperatingSystemType.MIDP);
		regExpOperatingSystems.put(".*profile/midp.*", OperatingSystemType.MIDP);
		regExpOperatingSystems.put(".*fedora.*", OperatingSystemType.FEDORA);
		regExpOperatingSystems.put(".*openbsd.*", OperatingSystemType.OPENBSD);
		regExpOperatingSystems.put(".*linux mint.*", OperatingSystemType.LINUX_MINT);
		regExpOperatingSystems.put(".*freebsd.*", OperatingSystemType.FREEBSD);
		regExpOperatingSystems.put(".*gentoo.*", OperatingSystemType.LINUX_GENTOO);
		regExpOperatingSystems.put(".*slackware.*", OperatingSystemType.SLACKWARE_LINUX);
		regExpOperatingSystems.put(".*windows ce.*", OperatingSystemType.WINDOWS_CE);
		regExpOperatingSystems.put(".*beos.*", OperatingSystemType.BEOS);
		regExpOperatingSystems.put(".*windows phone.*", OperatingSystemType.WINDOWS_PHONE);
		regExpOperatingSystems.put(".*symbian.*", OperatingSystemType.SYMBIAN_OS);
		regExpOperatingSystems.put(".*symbos.*", OperatingSystemType.SYMBIAN_OS);
		regExpOperatingSystems.put(".*SunOS.*", OperatingSystemType.SOLARIS);
		regExpOperatingSystems.put(".*opensolaris.*", OperatingSystemType.SOLARIS);
		regExpOperatingSystems.put(".*amigaos.*", OperatingSystemType.AMIGAOS);
		regExpOperatingSystems.put(".*haiku.*", OperatingSystemType.HAIKU);
		regExpOperatingSystems.put(".*windows mobile.*", OperatingSystemType.WINDOWS_MOBILE);
		regExpOperatingSystems.put(".*darwin.*", OperatingSystemType.DARWIN);
		regExpOperatingSystems.put(".*netbsd.*", OperatingSystemType.NETBSD);
		regExpOperatingSystems.put(".*blackberry.*", OperatingSystemType.BLACKBERRY_OS);
		regExpOperatingSystems.put(".*bada.*", OperatingSystemType.BADA);
		regExpOperatingSystems.put(".*kubuntu.*", OperatingSystemType.KUBUNTU);
		regExpOperatingSystems.put(".*centos.*", OperatingSystemType.CENTOS);
		regExpOperatingSystems.put(".*red hat.*", OperatingSystemType.RED_HAT);
		regExpOperatingSystems.put(".*ppc mac os x.*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*mac os x.*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*macintosh.*", OperatingSystemType.MAC_OS_X);
		regExpOperatingSystems.put(".*ubuntu.*", OperatingSystemType.UBUNTU);
		regExpOperatingSystems.put(".*windows.*", OperatingSystemType.WINDOWS);
		regExpOperatingSystems.put(".*android.*", OperatingSystemType.ANDROID);
		regExpOperatingSystems.put(".*linux.*", OperatingSystemType.LINUX);

		return regExpOperatingSystems;
	}
}
