package dev.kalenchukov.useragent.parsing;

import dev.kalenchukov.useragent.parsing.resources.BrowserType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BrowserTest
{
	private static final String USER_AGENT =
		"Mozilla/5.0 (Linux; Android 6.0.1; SM-A300FU Build/MMB29M; wv) AppleWebKit/537.36 " +
			"(KHTML, like Gecko) Version/4.0 Chrome/89.0.4389.105 Mobile Safari/537.36";

	@Test
	public void testGetAll()
	{
		List<String> browsers = Browser.getAll();

		// Отнимается 1 так как в результат Browser.getAll() не попадает BrowserType.UNKNOWN
		Assert.assertEquals(BrowserType.values().length - 1, browsers.size());
	}

	@Test
	public void testSetUserAgent()
	{
		Browser browser = new Browser();

		assertNull(browser.getName());
		assertNull(browser.getVersion());

		browser.setUserAgent(USER_AGENT);

		assertNotNull(browser.getName());
		assertNotNull(browser.getVersion());
	}

	@Test
	public void testGetName()
	{
		Browser browser = new Browser();
		browser.setUserAgent(USER_AGENT);

		assertEquals("Google Chrome", browser.getName());
	}

	@Test
	public void testGetVersion()
	{
		Browser browser = new Browser();
		browser.setUserAgent(USER_AGENT);

		assertEquals("89.0.4389.105", browser.getVersion());
	}
}