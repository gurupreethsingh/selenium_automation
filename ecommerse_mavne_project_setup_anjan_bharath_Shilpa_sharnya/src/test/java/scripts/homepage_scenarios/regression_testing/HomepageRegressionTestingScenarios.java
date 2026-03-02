package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.ShopPage;

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

	@Test(priority = 2, enabled = true)
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoHome();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 3, enabled = true)
	public void testClickOnLogoApplicationNameHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoAppNameAndPrintText();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 4, invocationCount = 1)
	public void testClickShopAllLinkFromHeaderOpenShopPage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedHomeTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedHomeTitle);

		// update row/col as per your excel
		hp.clickHeaderShopAllDesktop();

		ShopPage sp = new ShopPage(driver);
		String expectedShopTitle = (String) Excel.getData("Shoppage", 1, 0);
		sp.verifyShopPageTitle(expectedShopTitle);

	}
}
