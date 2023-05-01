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

package dev.kalenchukov.useragent.parsing.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных устройств.
 *
 * @author Aleksey Kalenchukov
 */
public enum DeviceType
{
	/**
	 * Не определён.
	 */
	UNKNOWN(
		null
	),

	/**
	 * Персональный компьютер.
	 */
	PC(
		"PC"
	),

	/**
	 * Мобильное устройство.
	 */
	MOBILE(
		"Mobile"
	),

	/**
	 * Планшетное устройство.
	 */
	TABLET(
		"Tablet"
	),

	/**
	 * Игровая консоль.
	 */
	GAME_CONSOLE(
		"Game console"
	),

	/**
	 * Телевизор.
	 */
	TV(
		"TV"
	),

	/**
	 * Виртуальный помощник.
	 */
	VIRTUAL_ASSISTANT(
		"Virtual assistant"
	);

	/**
	 * Тип устройства.
	 */
	@Nullable
	private final String type;

	/**
	 * Устанавливает тип устройства.
	 *
	 * @param type тип устройства.
	 */
	DeviceType(@Nullable final String type)
	{
		this.type = type;
	}

	/**
	 * Возвращает тип устройства.
	 *
	 * @return тип устройства.
	 */
	@Nullable
	public String getType()
	{
		return this.type;
	}
}
