package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.SearchProductsPage;
import pom.ShopPage;

public class HomepageFullRegressionTestingScenarios extends OpenClose {

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
	public void testOpenHomepageUsing_forwardslash_homeAsUrl() throws IOException {
		// @BeforeMethod

		driver.get(URL_HOME_ALT_1);

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		// @BeforeMethod
	}

	@Test(priority = 3, enabled = true)
	public void testVerifyRootContainerInHomepageIsDispalyed() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.isHomePageRootDisplayed();

	}

	@Test(priority = 4, enabled = true)
	public void testClickOnLogoFromHeaderOfHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoHome();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 5, enabled = true)
	public void testClickOnLogoApplicationNameHomepageReloadHomepage() throws IOException {

		Homepage hp = new Homepage(driver);
		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedTitle);
		hp.clickHeaderLogoAppNameAndPrintText();
		hp.verifyHomepageTitle(expectedTitle);

	}

	@Test(priority = 6, invocationCount = 1)
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

	@Test(priority = 7, invocationCount = 1)
	public void testSearchProductFromHomepageNavigateToSearchPage() throws IOException {
		// find the input field
		Homepage hp = new Homepage(driver);
//		String productNameTyped = (String)Excel.getData("Homepage", 2, 2);
		// enter some query or product name into the input field.
		hp.enterValueIntoSearchField("samsung");
		// find the seach button.
		// click on the search button.
		hp.clickSearchButtonDesktop();
		// user will navigate to search products page.
		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedTitleOfSearchProductsPage = (String) Excel.getData(EXCEL_SHEET_PATH, 1, 0);
		spp.verifySearchProductsPageTitle(expectedTitleOfSearchProductsPage);
		spp.verifySearchProductsPageUrl("http://localhost:5173/search-products?query=samsung");
		// find the text in the page. and match with the query word typed.
		driver.navigate().back();
		// come back to homepage and close the browser.
	}

	// category scenarios
	@Test(priority = 8, invocationCount = 1, enabled = true)
	public void testVerityCategoryMainHeadingText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main heading of the category section.
		String expectedCategoryMainHeading = (String) Excel.getData("HomePage", 1, 5);
		System.out.println("Data from excel sheet " + expectedCategoryMainHeading);
		hp.verifyCategoryMainHeadingText();

		Assert.assertEquals(hp.verifyCategoryMainHeadingText(), expectedCategoryMainHeading,
				"Verifying the Main heading text of category");

	}

	@Test(priority = 9, invocationCount = 1, enabled = true)
	public void testVerityCategorySubHeadingText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the Sub heading of the category section.
		String expectedCategorySubHeading = (String) Excel.getData("HomePage", 1, 6);
		System.out.println("Data from excel sheet " + expectedCategorySubHeading);
		hp.verifyCategorySubHeadingText();

		Assert.assertEquals(hp.verifyCategorySubHeadingText(), expectedCategorySubHeading,
				"Verifying the Sub heading text of category");

	}

	@Test(priority = 10, invocationCount = 1, enabled = true)
	public void testVerityCategoryCountTextText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the Sub heading of the category section.
		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		System.out.println("Data from excel sheet " + expectedCategoryCountText);
		hp.verifyCategoryCountText();

		Assert.assertEquals(hp.verifyCategoryCountText(), expectedCategoryCountText,
				"Verifying the Category Count text of category section Failed.");

	}

	@Test(priority = 11, invocationCount = 1, enabled = true)
	public void testVerifyTotalCategoriesCount() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the category count
		int expectedCategoryCount = 10;
		hp.verifyTotalCategoriesItemsCount(expectedCategoryCount);

		Assert.assertEquals(hp.verifyTotalCategoriesItemsCount(expectedCategoryCount), true,
				"Verifying the total Category Count of category section Failed.");

	}

	@Test(priority = 12, invocationCount = 1, enabled = true)
	public void testPrintAllCategoryNames() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.printAllCategoryNames();

	}

	// brand scenarios

	@Test(priority = 13, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionMainHeading() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionMainHeading();

		String exptectedBrandMainHeading = (String) Excel.getData("HomePage", 1, 8);
		Assert.assertEquals(hp.verifyBrandSectionMainHeading(), exptectedBrandMainHeading);

	}

	@Test(priority = 14, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionSubHeading() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionSubHeading();

		String exptectedBrandSubHeading = (String) Excel.getData("HomePage", 1, 9);
		Assert.assertEquals(hp.verifyBrandSectionSubHeading(), exptectedBrandSubHeading);

	}

	@Test(priority = 15, invocationCount = 1, enabled = true)
	public void testVerifyBrandSectionCountText() throws IOException {
		// verify whether you are in homepage.
		String exptectedHomepageTitle = (String) Excel.getData("HomePage", 1, 0);
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(exptectedHomepageTitle);

		// find the main heading in the brand section and verfiy whether it is Popular
		// Brands
		hp.verifyBrandSectionCountText();

		String exptectedBrandCountText = (String) Excel.getData("HomePage", 1, 10);
		Assert.assertEquals(hp.verifyBrandSectionCountText(), exptectedBrandCountText);

	}

}
