/*
 * Copyright © 2022-2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.useragent.parsing;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс для парсинга строки user-agent.
 *
 * @author Алексей Каленчуков
 */
public interface UserAgentParsing
{
	/**
	 * Устанавливает строку user-agent о которой необходимо возвращать информацию.
	 *
	 * @param userAgent строка user-agent.
	 */
	void setUserAgent(@NotNull String userAgent);

	/**
	 * Возвращает всю информацию о строке user-agent.
	 *
	 * @return коллекция с информацией о user-agent.
	 */
	@NotNull
	Map<@NotNull String, @Nullable String> getAll();

	/**
	 * Возвращает название браузера.
	 *
	 * @return название браузера, или {@code null} если браузер не определён.
	 */
	@Nullable
	String getBrowserName();

	/**
	 * Возвращает версию браузера.
	 *
	 * @return версия браузера, или {@code null} если версия браузера не определена.
	 */
	@Nullable
	String getBrowserVersion();

	/**
	 * Возвращает тип устройства.
	 *
	 * @return тип устройства, или {@code null} если устройство не определено.
	 */
	@Nullable
	String getDeviceType();

	/**
	 * Возвращает модель устройства.
	 *
	 * @return модель устройства, или {@code null} если устройство не определено.
	 */
	@Nullable
	String getDeviceModel();

	/**
	 * Возвращает название операционной системы.
	 *
	 * @return название операционной системы, или {@code null} если операционная система не определена.
	 */
	@Nullable
	String getOperatingSystemName();

	/**
	 * Возвращает версию операционной системы.
	 *
	 * @return версия операционной системы, или {@code null} если версия операционной системы не определена.
	 */
	@Nullable
	String getOperatingSystemVersion();
}
