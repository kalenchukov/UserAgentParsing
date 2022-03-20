/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.tests;

import dev.kalenchukov.useragentparser.UserAgentParser;
import dev.kalenchukov.useragentparser.UserAgentParsing;

class TestGet
{
	public static void main(String[] args)
	{
		UserAgentParsing userAgentParser = new UserAgentParser();

		// Устанавливает строку user-agent для которой необходимо получить данные
		userAgentParser.setUserAgent(
			"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
		);

		// Возвращает ID браузера
		System.out.println("browser_id: " + userAgentParser.getBrowserId());

		// Возвращает название браузера
		System.out.println("browser_name: " + userAgentParser.getBrowserName());

		// Возвращает версию браузера
		System.out.println("browser_version: " + userAgentParser.getBrowserVersion());

		// Возвращает ID устройства
		System.out.println("device_id: " + userAgentParser.getDeviceId());

		// Возвращает тип устройства
		System.out.println("device_type: " + userAgentParser.getDeviceType());

		// Возвращает модель устройства
		System.out.println("device_model: " + userAgentParser.getDeviceModel());

		// Возвращает ID операционной системы
		System.out.println("operating_system_id: " + userAgentParser.getOperatingSystemId());

		// Возвращает название операционной системы
		System.out.println("operating_system_name: " + userAgentParser.getOperatingSystemName());

		// Возвращает версию операционной системы
		System.out.println("operating_system_version: " + userAgentParser.getOperatingSystemVersion());
	}
}
