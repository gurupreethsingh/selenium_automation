package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_7178_ClickLogoFromHeaderReloadHomepage extends OpenClose {

	@Test
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() throws IOException {

		HomePage hp = new HomePage(driver);
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoHome();
		hp.verifyHomepageTitle(expectedTitle);

	}
}
