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

import dev.kalenchukov.useragent.parsing.resources.DeviceType;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceTest
{
	private static final String USER_AGENT =
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 " +
			"(KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36";

	@Test
	public void testGetAll()
	{
		List<String> devices = Device.getAll();

		// Отнимается 1 так как в результат Device.getAll() не попадает DeviceType.UNKNOWN
		assertEquals(DeviceType.values().length - 1, devices.size());
	}

	@Test
	public void testSetUserAgent()
	{
		Device device = new Device();

		assertNull(device.getType());
		assertNull(device.getModel());

		device.setUserAgent(USER_AGENT);

		assertNotNull(device.getType());
		assertNotNull(device.getModel());
	}

	@Test
	public void getType()
	{
		Device device = new Device();
		device.setUserAgent(USER_AGENT);

		assertEquals("Mobile", device.getType());
	}

	@Test
	public void getModel()
	{
		Device device = new Device();
		device.setUserAgent(USER_AGENT);

		assertEquals("SM-A300FU", device.getModel());
	}
}