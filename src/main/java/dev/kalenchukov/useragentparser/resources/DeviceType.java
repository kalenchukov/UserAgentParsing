/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser.resources;

import org.jetbrains.annotations.Nullable;

/**
 * Типы возможных устройств.
 */
public enum DeviceType
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
	 * Идентификатор устройства.
	 */
	@Nullable
	private final Long id;

	/**
	 * Тип устройства.
	 */
	@Nullable
	private final String type;

	/**
	 * Устанавливает идентификатор и тип устройства.
	 *
	 * @param id Идентификатор устройства.
	 * @param type Тип устройства.
	 */
	DeviceType(@Nullable final Long id, @Nullable final String type)
	{
		this.id = id;
		this.type = type;
	}

	/**
	 * Возвращает идентификатор устройства.
	 *
	 * @return Идентификатор устройства.
	 */
	@Nullable
	public Long getId()
	{
		return this.id;
	}

	/**
	 * Возвращает название устройства.
	 *
	 * @return Название устройства.
	 */
	@Nullable
	public String getType()
	{
		return this.type;
	}
}
