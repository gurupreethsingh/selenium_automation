package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_4343_ClickLogoImageFromHeaderReloadHomepage extends OpenClose {

	@Test
	public void testClickOnLogoApplicationNameHomepageReloadHomepage() throws IOException {

		HomePage hp = new HomePage(driver);
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoAppNameAndPrintText();
		hp.verifyHomepageTitle(expectedTitle);

	}
}
