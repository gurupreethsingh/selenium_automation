package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.Shoppage;

public class HomepageRegressionTestingScenarios extends OpenClose {

	@Test(priority = 1)
	public void testOpenHomepageUsingUrl() throws IOException {
		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		System.out.println("Title from excel sheet : " + expectedTitle);
		String expectedUrl = (String) Excel.getData("Homepage", 1, 1);
		System.out.println("Url from excel sheet : " + expectedUrl);

		int password = ((Double) Excel.getData("Homepage", 1, 4)).intValue();// 12345.0
		System.out.println(password);

		hp.verifyHomepageTitle(expectedTitle);
		hp.verifyHomepageUrl(expectedUrl);

	}

	@Test(priority = 2, enabled = false)
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() {

		Homepage hp = new Homepage(driver);
		String expectedTitle = Excel.getData1("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickOnLogo();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 3, invocationCount = 5)
	public void testClickShopAllLinkFromHeaderOpenShopPage() {

		Homepage hp = new Homepage(driver);
		String expectedHomeTitle = Excel.getData1("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedHomeTitle);

		// update row/col as per your excel
		hp.clickOnShopAllLink();

		Shoppage sp = new Shoppage(driver);
		String expectedShopTitle = Excel.getData1("Shoppage", 1, 0);
		sp.verifyShoppageTitle(expectedShopTitle);

	}

}
