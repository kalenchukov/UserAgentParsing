/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragent.parsing;

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
	 * @return Название браузера, или {@code null} если браузер не определён.
	 */
	@Nullable
	String getBrowserName();

	/**
	 * Возвращает версию браузера.
	 *
	 * @return Версия браузера, или {@code null} если версия браузера не определена.
	 */
	@Nullable
	String getBrowserVersion();

	/**
	 * Возвращает тип устройства.
	 *
	 * @return Тип устройства, или {@code null} если устройство не определено.
	 */
	@Nullable
	String getDeviceType();

	/**
	 * Возвращает модель устройства.
	 *
	 * @return Модель устройства, или {@code null} если устройство не определено.
	 */
	@Nullable
	String getDeviceModel();

	/**
	 * Возвращает название операционной системы.
	 *
	 * @return Название операционной системы, или {@code null} если операционная система не определена.
	 */
	@Nullable
	String getOperatingSystemName();

	/**
	 * Возвращает версию операционной системы.
	 *
	 * @return Версия операционной системы, или {@code null} если версия операционной системы не определена.
	 */
	@Nullable
	String getOperatingSystemVersion();
}
