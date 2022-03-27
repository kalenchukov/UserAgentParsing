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
 * Класс парсинга строки user-agent.
 */
public final class UserAgentParser implements UserAgentParsing
{
	/**
	 * Объект браузера по умолчанию.
	 */
	@NotNull
	private final Browser browser = new Browser();

	/**
	 * Объект устройства по умолчанию.
	 */
	@NotNull
	private final Device device = new Device();

	/**
	 * Объект операционной системы по умолчанию.
	 */
	@NotNull
	private final OperatingSystem operatingSystem = new OperatingSystem();

	/**
	 * @see UserAgentParsing#setUserAgent(String)
	 */
	@Override
	public void setUserAgent(@NotNull String userAgent)
	{
		Objects.requireNonNull(userAgent);

		userAgent = this.format(userAgent);

		this.device.setUserAgent(userAgent);
		this.browser.setUserAgent(userAgent);
		this.operatingSystem.setUserAgent(userAgent);
	}

	/**
	 * @see UserAgentParsing#getAll()
	 */
	@NotNull
	@Override
	public Map<@NotNull String, @Nullable String> getAll()
	{
		Map<String, String> allInfo = new HashMap<>();

		allInfo.put("browser_name", this.browser.getName());
		allInfo.put("browser_version", this.browser.getVersion());

		allInfo.put("device_type", this.device.getType());
		allInfo.put("device_model", this.device.getModel());

		allInfo.put("operating_system_name", this.operatingSystem.getName());
		allInfo.put("operating_system_version", this.operatingSystem.getVersion());

		return allInfo;
	}

	/**
	 * @see UserAgentParsing#getBrowserName()
	 */
	@Nullable
	@Override
	public String getBrowserName()
	{
		return this.browser.getName();
	}

	/**
	 * @see UserAgentParsing#getBrowserVersion()
	 */
	@Nullable
	@Override
	public String getBrowserVersion()
	{
		return this.browser.getVersion();
	}

	/**
	 * @see UserAgentParsing#getDeviceType()
	 */
	@Nullable
	@Override
	public String getDeviceType()
	{
		return this.device.getType();
	}

	/**
	 * @see UserAgentParsing#getDeviceModel()
	 */
	@Nullable
	@Override
	public String getDeviceModel()
	{
		return this.device.getModel();
	}

	/**
	 * @see UserAgentParsing#getOperatingSystemName()
	 */
	@Nullable
	@Override
	public String getOperatingSystemName()
	{
		return this.operatingSystem.getName();
	}

	/**
	 * @see UserAgentParsing#getOperatingSystemVersion()
	 */
	@Nullable
	@Override
	public String getOperatingSystemVersion()
	{
		return this.operatingSystem.getVersion();
	}

	/**
	 * Форматирует user-agent.
	 * <ul>
	 *     <li>Удаляет пробелы между определёнными символами</li>
	 *     <li>Удаляет множественные пробелы</li>
	 * </ul>
	 *
	 * @param userAgent Строка user-agent.
	 * @return Отформатированную строку user-agent.
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
