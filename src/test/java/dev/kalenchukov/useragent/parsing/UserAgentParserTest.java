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
		Map<String, String> data = userAgentParser.getAll();

		String actualBrowserName = data.get("browser_name");
		String actualBrowserVersion = data.get("browser_version");
		String actualDeviceType = data.get("device_type");
		String actualDeviceModel = data.get("device_model");
		String actualOperatingSystemName = data.get("operating_system_name");
		String actualOperatingSystemVersion = data.get("operating_system_version");

		assertEquals("Google Chrome", actualBrowserName);
		assertEquals("89.0.4389.105", actualBrowserVersion);
		assertEquals("Mobile", actualDeviceType);
		assertEquals("SM-A300FU", actualDeviceModel);
		assertEquals("Android", actualOperatingSystemName);
		assertEquals("6.0.1", actualOperatingSystemVersion);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getBrowserName()}.
	 */
	@Test
	public void getBrowserName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualBrowserName = userAgentParser.getBrowserName();

		assertEquals("Google Chrome", actualBrowserName);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getBrowserVersion()}.
	 */
	@Test
	public void getBrowserVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualBrowserVersion = userAgentParser.getBrowserVersion();

		assertEquals("89.0.4389.105", actualBrowserVersion);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getDeviceType()}.
	 */
	@Test
	public void getDeviceType()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualDeviceType = userAgentParser.getDeviceType();

		assertEquals("Mobile", actualDeviceType);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getDeviceModel()}.
	 */
	@Test
	public void getDeviceModel()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualDeviceModel = userAgentParser.getDeviceModel();

		assertEquals("SM-A300FU", actualDeviceModel);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getOperatingSystemName()}.
	 */
	@Test
	public void getOperatingSystemName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualOperatingSystemName = userAgentParser.getOperatingSystemName();

		assertEquals("Android", actualOperatingSystemName);
	}

	/**
	 * Проверка метода {@link UserAgentParser#getOperatingSystemVersion()}.
	 */
	@Test
	public void getOperatingSystemVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		String actualOperatingSystemVersion = userAgentParser.getOperatingSystemVersion();

		assertEquals("6.0.1", actualOperatingSystemVersion);
	}
}