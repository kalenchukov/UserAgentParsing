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

import static org.assertj.core.api.Assertions.assertThat;

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

		assertThat(userAgentParser.getDeviceType()).isNull();
		assertThat(userAgentParser.getDeviceModel()).isNull();

		assertThat(userAgentParser.getBrowserName()).isNull();
		assertThat(userAgentParser.getBrowserVersion()).isNull();

		assertThat(userAgentParser.getOperatingSystemName()).isNull();
		assertThat(userAgentParser.getOperatingSystemVersion()).isNull();

		userAgentParser.setUserAgent(USER_AGENT);

		assertThat(userAgentParser.getDeviceType()).isNotNull();
		assertThat(userAgentParser.getDeviceModel()).isNotNull();

		assertThat(userAgentParser.getBrowserName()).isNotNull();
		assertThat(userAgentParser.getBrowserVersion()).isNotNull();

		assertThat(userAgentParser.getOperatingSystemName()).isNotNull();
		assertThat(userAgentParser.getOperatingSystemVersion()).isNotNull();
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

		assertThat(actualBrowserName).isEqualTo("Google Chrome");
		assertThat(actualBrowserVersion).isEqualTo("89.0.4389.105");
		assertThat(actualDeviceType).isEqualTo("Mobile");
		assertThat(actualDeviceModel).isEqualTo("SM-A300FU");
		assertThat(actualOperatingSystemName).isEqualTo("Android");
		assertThat(actualOperatingSystemVersion).isEqualTo("6.0.1");
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

		assertThat(actualBrowserName).isEqualTo("Google Chrome");
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

		assertThat(actualBrowserVersion).isEqualTo("89.0.4389.105");
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

		assertThat(actualDeviceType).isEqualTo("Mobile");
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

		assertThat(actualDeviceModel).isEqualTo("SM-A300FU");
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

		assertThat(actualOperatingSystemName).isEqualTo("Android");
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

		assertThat(actualOperatingSystemVersion).isEqualTo("6.0.1");
	}
}