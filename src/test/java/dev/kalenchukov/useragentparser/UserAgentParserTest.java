package dev.kalenchukov.useragentparser;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserAgentParserTest
{
	private static final String USER_AGENT =
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 " +
			"(KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36";

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

	@Test
	public void getAll()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		Map<String, String> allInfo = userAgentParser.getAll();

		assertEquals("Google Chrome", allInfo.get("browser_name"));
		assertEquals("89.0.4389.105", allInfo.get("browser_version"));

		assertEquals("Mobile", allInfo.get("device_type"));
		assertEquals("SM-A300FU", allInfo.get("device_model"));

		assertEquals("Android", allInfo.get("operating_system_name"));
		assertEquals("6.0.1", allInfo.get("operating_system_version"));
	}

	@Test
	public void getBrowserName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("Google Chrome", userAgentParser.getBrowserName());
	}

	@Test
	public void getBrowserVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("89.0.4389.105", userAgentParser.getBrowserVersion());
	}

	@Test
	public void getDeviceType()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("Mobile", userAgentParser.getDeviceType());
	}

	@Test
	public void getDeviceModel()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("SM-A300FU", userAgentParser.getDeviceModel());
	}

	@Test
	public void getOperatingSystemName()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("Android", userAgentParser.getOperatingSystemName());
	}

	@Test
	public void getOperatingSystemVersion()
	{
		UserAgentParsing userAgentParser = new UserAgentParser();
		userAgentParser.setUserAgent(USER_AGENT);

		assertEquals("6.0.1", userAgentParser.getOperatingSystemVersion());
	}
}