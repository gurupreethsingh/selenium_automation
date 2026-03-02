package scripts.about_us_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AboutUsPage;

public class AS_7359_OpenAboutUsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAboutUsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AboutUsPage", 1, 0);

		driver.get(URL_ABOUT_US);

		AboutUsPage page = new AboutUsPage(driver);
		page.verifyAboutUsPageTitle(expectedTitle);
	}
}
