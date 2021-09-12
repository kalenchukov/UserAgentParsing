/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализация интерфейса парсинга.
 */
public class UserAgentParser implements UserAgentParsing
{
	private final Browser browser = new Browser();
	private final Device device = new Device();
	private final OperatingSystem operatingSystem = new OperatingSystem();

	/**
	 * Устанавливает строку user-agent.
	 *
	 * @param userAgent строка user-agent
	 */
	@Override
	public void setUserAgent(String userAgent)
	{
		userAgent = (userAgent != null) ? format(userAgent) : "";

		this.device.setUserAgent(userAgent);
		this.browser.setUserAgent(userAgent);
		this.operatingSystem.setUserAgent(userAgent);
	}

	@Override
	public Map<String, String> getAll()
	{
		Map<String, String> all = new HashMap<>();

		all.put("browser_id", this.browser.getId());
		all.put("browser_name", this.browser.getName());
		all.put("browser_version", this.browser.getVersion());

		all.put("device_id", this.device.getId());
		all.put("device_type", this.device.getType());
		all.put("device_model", this.device.getModel());

		all.put("operating_system_id", this.operatingSystem.getId());
		all.put("operating_system_name", this.operatingSystem.getName());
		all.put("operating_system_version", this.operatingSystem.getVersion());

		return all;
	}

	@Override
	@Nullable
	public String getBrowserId()
	{
		return this.browser.getId();
	}

	@Override
	@Nullable
	public String getBrowserName()
	{
		return this.browser.getName();
	}

	@Override
	@Nullable
	public String getBrowserVersion()
	{
		return this.browser.getVersion();
	}

	@Override
	@Nullable
	public String getDeviceId()
	{
		return this.device.getId();
	}

	@Override
	@Nullable
	public String getDeviceType()
	{
		return this.device.getType();
	}

	@Override
	@Nullable
	public String getDeviceModel()
	{
		return this.device.getModel();
	}

	@Override
	@Nullable
	public String getOperatingSystemId()
	{
		return this.operatingSystem.getId();
	}

	@Override
	@Nullable
	public String getOperatingSystemName()
	{
		return this.operatingSystem.getName();
	}

	@Override
	@Nullable
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
	private String format(@NotNull String userAgent)
	{
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
