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

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link UserAgentParser}.
 *
 * @author Алексей Каленчуков
 */
public class UserAgentParserTest
{
	private static final String USER_AGENT =
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 " +
			"(KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36";

	/**
	 * Проверка метода {@link UserAgentParser#setUserAgent(String)}.
	 */
	@Test
	public void setUserAgent()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();

		assertNull(userAgentParser.getDeviceType());
		assertNull(userAgentParser.getDeviceModel());

		assertNull(userAgentParser.getBrowserName());
		assertNull(userAgentParser.getBrowserVersion());

		assertNull(userAgentParser.getOperatingSystemName());
		assertNull(userAgentParser.getOperatingSystemVersion());

		userAgentParser.setUserAgent(USER_AGENT);

		assertNotNull(userAgentParser.getDeviceType());
		assertNotNull(userAgentParser.getDeviceModel());

		assertNotNull(userAgentParser.getBrowserName());
		assertNotNull(userAgentParser.getBrowserVersion());

		assertNotNull(userAgentParser.getOperatingSystemName());
		assertNotNull(userAgentParser.getOperatingSystemVersion());
	}

	/**
	 * Проверка метода {@link UserAgentParser#getAll()}.
	 */
	@Test
	public void getAll()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		Map<String, String> actual = userAgentParser.getAll();

		assertEquals("Google Chrome", actual.get("browser_name"));
		assertEquals("89.0.4389.105", actual.get("browser_version"));

		assertEquals("Mobile", actual.get("device_type"));
		assertEquals("SM-A300FU", actual.get("device_model"));

		assertEquals("Android", actual.get("operating_system_name"));
		assertEquals("6.0.1", actual.get("operating_system_version"));
	}

	/**
	 * Проверка метода {@link UserAgentParser#getBrowserName()}.
	 */
	@Test
	public void getBrowserName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getBrowserName();

		assertEquals("Google Chrome", actual);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getBrowserVersion()}.
	 */
	@Test
	public void getBrowserVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getBrowserVersion();

		assertEquals("89.0.4389.105", actual);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getDeviceType()}.
	 */
	@Test
	public void getDeviceType()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getDeviceType();

		assertEquals("Mobile", actual);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getDeviceModel()}.
	 */
	@Test
	public void getDeviceModel()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getDeviceModel();

		assertEquals("SM-A300FU", actual);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getOperatingSystemName()}.
	 */
	@Test
	public void getOperatingSystemName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getOperatingSystemName();

		assertEquals("Android", actual);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getOperatingSystemVersion()}.
	 */
	@Test
	public void getOperatingSystemVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actual = userAgentParser.getOperatingSystemVersion();

		assertEquals("6.0.1", actual);
	}
}