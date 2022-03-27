/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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
	Map<@NotNull String, @Nullable String> getAll();

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
