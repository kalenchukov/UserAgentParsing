package dev.kalenchukov.useragentparser;

import dev.kalenchukov.useragentparser.resources.DeviceType;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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