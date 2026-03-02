package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_4343_ClickLogoImageFromHeaderReloadHomepage extends OpenClose {

	@Test
	public void testClickOnLogoApplicationNameHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoAppNameAndPrintText();
		hp.verifyHomepageTitle(expectedTitle);

	}
}
