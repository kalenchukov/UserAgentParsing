/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Реализация интерфейса парсинга.
 */
public final class UserAgentParser implements UserAgentParsing
{
	@NotNull
	private final Browser browser = new Browser();

	@NotNull
	private final Device device = new Device();

	@NotNull
	private final OperatingSystem operatingSystem = new OperatingSystem();

	/**
	 * Устанавливает строку user-agent.
	 *
	 * @param userAgent строка user-agent
	 */
	@Override
	public void setUserAgent(@NotNull String userAgent)
	{
		Objects.requireNonNull(userAgent);

		userAgent = format(userAgent);

		this.device.setUserAgent(userAgent);
		this.browser.setUserAgent(userAgent);
		this.operatingSystem.setUserAgent(userAgent);
	}

	@NotNull
	@Override
	public Map<@NotNull String, @NotNull String> getAll()
	{
		Map<String, String> allUserAgentInfo = new HashMap<>();

		allUserAgentInfo.put("browser_id", String.valueOf(this.browser.getId()));
		allUserAgentInfo.put("browser_name", this.browser.getName());
		allUserAgentInfo.put("browser_version", this.browser.getVersion());

		allUserAgentInfo.put("device_id", String.valueOf(this.device.getId()));
		allUserAgentInfo.put("device_type", this.device.getType());
		allUserAgentInfo.put("device_model", this.device.getModel());

		allUserAgentInfo.put("operating_system_id", String.valueOf(this.operatingSystem.getId()));
		allUserAgentInfo.put("operating_system_name", this.operatingSystem.getName());
		allUserAgentInfo.put("operating_system_version", this.operatingSystem.getVersion());

		return allUserAgentInfo;
	}

	@Nullable
	@Override
	public Long getBrowserId()
	{
		return this.browser.getId();
	}

	@Nullable
	@Override
	public String getBrowserName()
	{
		return this.browser.getName();
	}

	@Nullable
	@Override
	public String getBrowserVersion()
	{
		return this.browser.getVersion();
	}

	@Nullable
	@Override
	public Long getDeviceId()
	{
		return this.device.getId();
	}

	@Nullable
	@Override
	public String getDeviceType()
	{
		return this.device.getType();
	}

	@Nullable
	@Override
	public String getDeviceModel()
	{
		return this.device.getModel();
	}

	@Nullable
	@Override
	public Long getOperatingSystemId()
	{
		return this.operatingSystem.getId();
	}

	@Nullable
	@Override
	public String getOperatingSystemName()
	{
		return this.operatingSystem.getName();
	}

	@Nullable
	@Override
	public String getOperatingSystemVersion()
	{
		return this.operatingSystem.getVersion();
	}

	/**
	 * Форматирует user agent.
	 * Удаляет пробелы между определёнными символами.
	 * Удаляет множественные пробелы.
	 *
	 * @param userAgent
	 * @return userAgent
	 */
	@NotNull
	private String format(@NotNull final String userAgent)
	{
		Objects.requireNonNull(userAgent);

		return userAgent
			.replaceAll("(\s+)?\\.(\s+)?", ".")
			.replaceAll("(\s+)?-(\s+)?", "-")
			.replaceAll("(\s+)?_(\s+)?", "_")
			.replaceAll("(\s+)?#(\s+)?", "#")
			.replaceAll("(\s+)?/(\s+)?", "/")
			.replaceAll("(\s+)?:(\s+)?", ":")
			.replaceAll("(\s+)?;(\s+)?", ";")
			.replaceAll("(\s+)?,(\s+)?", ",")
			.replaceAll("(\s+)?\\((\s+)?", "(")
			.replaceAll("(\s+)?\\)(\s+)?", ")")
			.replaceAll("(\s+)?\\[(\s+)?", "[")
			.replaceAll("(\s+)?\\](\s+)?", "]")

			.replaceAll("\s+", " ")

			.toUpperCase()
			.trim();
	}
}
