package dev.kalenchukov.useragent.parsing;

import dev.kalenchukov.useragent.parsing.resources.OperatingSystemType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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
		Assert.assertEquals(OperatingSystemType.values().length - 1, operatingSystems.size());
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