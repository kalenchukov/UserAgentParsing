/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragent.parsing.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных устройств.
 */
public enum DeviceType
{
	UNKNOWN(
		null
	),

	PC(
		"PC"
	),

	MOBILE(
		"Mobile"
	),

	TABLET(
		"Tablet"
	),

	GAME_CONSOLE(
		"Game console"
	),

	TV(
		"TV"
	),

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
	 * @param type Тип устройства.
	 */
	DeviceType(@Nullable final String type)
	{
		this.type = type;
	}

	/**
	 * Возвращает тип устройства.
	 *
	 * @return Тип устройства.
	 */
	@Nullable
	public String getType()
	{
		return this.type;
	}
}
