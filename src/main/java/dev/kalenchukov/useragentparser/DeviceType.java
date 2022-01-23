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
		1L,
		"PC"
	),

	MOBILE(
		2L,
		"Mobile"
	),

	TABLET(
		3L,
		"Tablet"
	),

	GAME_CONSOLE(
		4L,
		"Game console"
	),

	TV(
		5L,
		"TV"
	),

	VIRTUAL_ASSISTANT(
		6L,
		"Virtual assistant"
	);

	/**
	 * ID устройства.
	 */
	@Nullable
	private final Long id;

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
	DeviceType(@Nullable Long id, @Nullable String type)
	{
		this.id = id;
		this.type = type;
	}

	@Nullable
	Long getId()
	{
		return this.id;
	}

	@Nullable
	String getType()
	{
		return this.type;
	}
}
