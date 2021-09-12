/*
 * Copyright © 2021 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных устройств.
 */
enum DeviceType
{
	UNKNOWN(
		null,
		null
	),

	PC(
		"1",
		"PC"
	),

	MOBILE(
		"2",
		"Mobile"
	),

	TABLET(
		"3",
		"Tablet"
	),

	GAME_CONSOLE(
		"4",
		"Game console"
	),

	TV(
		"5",
		"TV"
	),

	VIRTUAL_ASSISTANT(
		"6",
		"Virtual assistant"
	);

	/**
	 * ID устройства.
	 */
	@Nullable
	private final String id;

	/**
	 * Тип устройства.
	 */
	@Nullable
	private final String type;

	/**
	 * Устанавливает ID устройства.
	 * Устанавливает тип устройства.
	 *
	 * @param id ID устройства
	 * @param type тип устройства
	 */
	DeviceType(String id, String type)
	{
		this.id = id;
		this.type = type;
	}

	@Nullable
	String getId()
	{
		return this.id;
	}

	@Nullable
	String getType()
	{
		return this.type;
	}
}
