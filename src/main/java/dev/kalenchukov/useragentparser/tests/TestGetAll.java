/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.useragentparser.tests;

import dev.kalenchukov.useragentparser.UserAgentParser;
import dev.kalenchukov.useragentparser.UserAgentParsing;

class TestGetAll
{
	public static void main(String[] args)
	{
		UserAgentParsing userAgentParser = new UserAgentParser();

		// Устанавливает строку user-agent для которой необходимо получить данные
		userAgentParser.setUserAgent(
			"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36"
		);

		// Возвращает карту всех данных
		/*
			Результат выполнения:
			{
				browser_id=1,
				browser_name=Google Chrome,
				browser_version=89.0.4389.105,

				device_id=2,
				device_type=Mobile,
				device_model=SM-A300FU,

				operating_system_id=5,
				operating_system_name=Android,
				operating_system_version=6.0.1
			}
		*/
		System.out.println(userAgentParser.getAll());
	}
}
