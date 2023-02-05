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

import dev.kalenchukov.useragent.parsing.resources.OperatingSystemType;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OperatingSystemTest
{
	private static final String USER_AGENT =
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 " +
			"(KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36";

	@Test
	public void testGetAll()
	{
		List<String> operatingSystems = OperatingSystem.getAll();

		// Отнимается 1 так как в результат OperatingSystem.getAll() не попадает OperatingSystemType.UNKNOWN
		assertEquals(OperatingSystemType.values().length - 1, operatingSystems.size());
	}

	@Test
	public void testSetUserAgent()
	{
		OperatingSystem operatingSystem = new OperatingSystem();

		assertNull(operatingSystem.getName());
		assertNull(operatingSystem.getVersion());

		operatingSystem.setUserAgent(USER_AGENT);

		assertNotNull(operatingSystem.getName());
		assertNotNull(operatingSystem.getVersion());
	}

	@Test
	public void testGetName()
	{
		OperatingSystem operatingSystem = new OperatingSystem();
		operatingSystem.setUserAgent(USER_AGENT);

		assertEquals("Android", operatingSystem.getName());
	}

	@Test
	public void testGetVersion()
	{
		OperatingSystem operatingSystem = new OperatingSystem();
		operatingSystem.setUserAgent(USER_AGENT);

		assertEquals("6.0.1", operatingSystem.getVersion());
	}
}