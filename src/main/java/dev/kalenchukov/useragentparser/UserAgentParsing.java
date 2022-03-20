/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Интерфейс для парсеров.
 */
public interface UserAgentParsing
{
	/**
	 * Должен принимать строку user-agent о которой необходимо возвращать информацию.
	 *
	 * @param userAgent строка user-agent
	 */
	void setUserAgent(@NotNull String userAgent);

	/**
	 * Должен возвращать все значения.
	 */
	@NotNull
	Map<String, String> getAll();

	/**
	 * Должен возвращать ID браузера.
	 */
	@Nullable
	Long getBrowserId();

	/**
	 * Должен возвращать название браузера.
	 */
	@Nullable
	String getBrowserName();

	/**
	 * Должен возвращать версию браузера.
	 */
	@Nullable
	String getBrowserVersion();

	/**
	 * Должен возвращать ID устройства.
	 */
	@Nullable
	Long getDeviceId();

	/**
	 * Должен возвращать тип устройства.
	 */
	@Nullable
	String getDeviceType();

	/**
	 * Должен возвращать модель устройства.
	 */
	@Nullable
	String getDeviceModel();

	/**
	 * Должен возвращать ID операционной системы.
	 */
	@Nullable
	Long getOperatingSystemId();

	/**
	 * Должен возвращать название операционной системы.
	 */
	@Nullable
	String getOperatingSystemName();

	/**
	 * Должен возвращать версию операционной системы.
	 */
	@Nullable
	String getOperatingSystemVersion();
}
