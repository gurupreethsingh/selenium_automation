package scripts.web_apps_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.WebAppsPage;

public class AS_7353_OpenWebAppsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenWebAppsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("WebAppsPage", 1, 0);

		driver.get(URL_WEB_APPS);

		WebAppsPage page = new WebAppsPage(driver);
		page.verifyWebAppsPageTitle(expectedTitle);
	}
}
