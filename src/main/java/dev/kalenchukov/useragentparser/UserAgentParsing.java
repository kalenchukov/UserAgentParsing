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
 * Интерфейс для парсинга строки user-agent.
 */
public interface UserAgentParsing
{
	/**
	 * Устанавливает строку user-agent о которой необходимо возвращать информацию.
	 *
	 * @param userAgent Строка user-agent.
	 */
	void setUserAgent(@NotNull String userAgent);

	/**
	 * Возвращает всю информацию о строке user-agent.
	 *
	 * @return Коллекция с информацией о user-agent.
	 */
	@NotNull
	Map<@NotNull String, @NotNull String> getAll();

	/**
	 * Возвращает идентификатор браузера.
	 *
	 * @return Идентификатор браузера.
	 */
	@Nullable
	Long getBrowserId();

	/**
	 * Возвращает название браузера.
	 *
	 * @return Название браузера.
	 */
	@Nullable
	String getBrowserName();

	/**
	 * Возвращает версию браузера.
	 *
	 * @return Версия браузера.
	 */
	@Nullable
	String getBrowserVersion();

	/**
	 * Возвращает идентификатор устройства.
	 *
	 * @return Идентификатор устройства.
	 */
	@Nullable
	Long getDeviceId();

	/**
	 * Возвращает тип устройства.
	 *
	 * @return Тип устройства.
	 */
	@Nullable
	String getDeviceType();

	/**
	 * Возвращает модель устройства.
	 *
	 * @return Модель устройства.
	 */
	@Nullable
	String getDeviceModel();

	/**
	 * Возвращает идентификатор операционной системы.
	 *
	 * @return Идентификатор операционной системы.
	 */
	@Nullable
	Long getOperatingSystemId();

	/**
	 * Возвращает название операционной системы.
	 *
	 * @return Название операционной системы.
	 */
	@Nullable
	String getOperatingSystemName();

	/**
	 * Возвращает версию операционной системы.
	 *
	 * @return Версия операционной системы.
	 */
	@Nullable
	String getOperatingSystemVersion();
}
