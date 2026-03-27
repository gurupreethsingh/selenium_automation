package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.Header;
import pom.HomePage;
import pom.SearchProductsPage;

public class HomePageHeaderFullRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testEnterCategoryNameInSearchFieldFetchAllProducts() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		String valueToEnter = (String) Excel.getData("HomePage", 6, 2);
		Header header = new Header(driver);
		Thread.sleep(3000);

		header.enterValueIntoSearchInputField(valueToEnter);
		Thread.sleep(3000);

		boolean clickStatus = header.clickSearchButtonDesktop();
		softAssert.assertTrue(clickStatus, "Click on search button failed.");

		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
				"Search products page title verification failed.");

		String categoryName = valueToEnter;
		List<WebElement> products = spp.fetchAllProductsOfACategory(categoryName);

		softAssert.assertTrue(products != null && !products.isEmpty(),
				"No products were fetched for category: " + categoryName);

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testEnterCategoryNameInSearchFieldHitEnterFetchAllProducts() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		String valueToEnter = (String) Excel.getData("HomePage", 6, 2);
		Header header = new Header(driver);
		Thread.sleep(1000);

		header.enterValueIntoSearchInputField(valueToEnter);
		Thread.sleep(1000);

		header.getSearchInputField().sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		SearchProductsPage spp = new SearchProductsPage(driver);
		softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
				"Search products page title verification failed.");

		String categoryName = valueToEnter;
		List<WebElement> products = spp.fetchAllProductsOfACategory(categoryName);

		softAssert.assertTrue(products != null && !products.isEmpty(),
				"No products were fetched after pressing ENTER for category: " + categoryName);

		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testHoverOnWishlistCheckShadowChange() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		WebElement wishlistIcon = header.fetchWishlistIcon();
		String boxShadowBeforeHover = wishlistIcon.getCssValue("box-shadow");

		System.out.println("============================================================");
		System.out.println("Box Shadow Before Hover : " + boxShadowBeforeHover);
		System.out.println("============================================================");

		boolean hoverStatus = header.hoverOnWishlistIconDesktop();
		softAssert.assertTrue(hoverStatus, "Hover on wishlist icon failed.");

		Thread.sleep(1000);

		String boxShadowAfterHover = wishlistIcon.getCssValue("box-shadow");

		System.out.println("============================================================");
		System.out.println("Box Shadow After Hover  : " + boxShadowAfterHover);
		System.out.println("============================================================");

		softAssert.assertNotEquals(boxShadowAfterHover, boxShadowBeforeHover,
				"Wishlist icon box-shadow did not change after hover.");
		softAssert.assertFalse(boxShadowAfterHover == null || boxShadowAfterHover.trim().isEmpty(),
				"Wishlist icon box-shadow after hover is empty.");

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testClickOnLogoHomepageShouldReload() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = (String) Excel.getData("HomePage", 1, 1);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before click.");

		Header header = new Header(driver);
		Thread.sleep(2000);

		boolean clickStatus = header.clickHeaderLogoHome();
		softAssert.assertTrue(clickStatus, "Click on header logo failed.");

		softAssert.assertTrue(
				hp.verifyPageReload(expectedHomePageTitle, expectedHomePageUrl,
						"Homepage Reload After Clicking Header Logo"),
				"Homepage did not reload after clicking header logo.");

		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testClickOnCartIconMiniCartShouldExpandAndBecomeVisible() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking cart icon.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		header.openMiniCart();
		Thread.sleep(3000);

		softAssert.assertTrue(header.isMiniCartOpen(),
				"Mini cart did not expand or become visible after clicking cart icon.");

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testClickOnShopAllLinkShopPageShouldOpen() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking SHOP ALL.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		boolean clickStatus = header.clickHeaderShopAllDesktop();
		softAssert.assertTrue(clickStatus, "Click on SHOP ALL link failed.");

		String expectedShopPageTitle = (String) Excel.getData("ShopPage", 1, 0);
		String expectedShopPageUrl = (String) Excel.getData("ShopPage", 1, 1);

		softAssert.assertTrue(header.waitForPageToLoad(expectedShopPageTitle, expectedShopPageUrl,
				"Shop Page After Clicking SHOP ALL"), "Shop page did not open after clicking SHOP ALL.");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testEnterProductNameInSearchFieldRelatedProductsShouldBeShown()
			throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String searchQuery = (String) Excel.getData("HomePage", 6, 2);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before search.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		header.enterValueIntoSearchInputField(searchQuery);

		softAssert.assertTrue(
				header.verifyInputFieldValue(header.getSearchInputField(), searchQuery, "Header Search Input Field"),
				"Search input field value verification failed.");

		boolean clickStatus = header.clickSearchButtonDesktop();
		softAssert.assertTrue(clickStatus, "Click on desktop search button failed.");

		SearchProductsPage spp = new SearchProductsPage(driver);

		softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
				"Search products page title verification failed.");

		List<WebElement> actualProducts = spp.fetchAllProductsOfACategory(searchQuery);

		softAssert.assertTrue(actualProducts != null && !actualProducts.isEmpty(),
				"No products were displayed for the search query.");

		List<String> actualProductNames = new ArrayList<>();
		for (WebElement product : actualProducts) {
			String actualName = product.getText() == null ? "" : product.getText().trim();
			if (!actualName.isEmpty()) {
				actualProductNames.add(actualName);
			}
		}

		List<String> expectedProductNames = new ArrayList<>();
		for (int row = 5; row <= 19; row++) {
			Object cellValue = Excel.getData("SearchProductsPage", row, 1);
			String expectedName = cellValue == null ? "" : cellValue.toString().trim();
			if (!expectedName.isEmpty()) {
				expectedProductNames.add(expectedName);
			}
		}

		System.out.println("=======================================================================================");
		System.out.printf("%-5s %-50s %-50s%n", "No", "EXPECTED PRODUCTS FROM EXCEL", "ACTUAL PRODUCTS FROM UI");
		System.out.println("==============================================================================");

		int maxSize = Math.max(expectedProductNames.size(), actualProductNames.size());

		for (int i = 0; i < maxSize; i++) {
			String expected = i < expectedProductNames.size() ? expectedProductNames.get(i) : "---";
			String actual = i < actualProductNames.size() ? actualProductNames.get(i) : "---";

			System.out.printf("%-5d %-50s %-50s%n", (i + 1), expected, actual);
		}

		System.out.println("=====================================================================================");

		for (String expectedProduct : expectedProductNames) {
			boolean matchFound = false;

			for (String actualProduct : actualProductNames) {
				if (actualProduct.trim().equalsIgnoreCase(expectedProduct.trim())) {
					matchFound = true;
					break;
				}
			}

			softAssert.assertTrue(matchFound, "Expected product not found in search results: " + expectedProduct);
		}

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClickOnUserAvatarIconUserShouldNavigateToLoginPage() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedLoginPageTitle = (String) Excel.getData("LoginPage", 1, 0);
		String expectedLoginPageUrl = (String) Excel.getData("LoginPage", 1, 1);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking user avatar.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		boolean clickStatus = header.clickSignInAvatarDesktop();
		softAssert.assertTrue(clickStatus, "Click on sign in avatar failed.");

		softAssert.assertTrue(
				header.waitForPageToLoad(expectedLoginPageTitle, expectedLoginPageUrl,
						"Login Page After Clicking User Avatar"),
				"Login page did not open after clicking user avatar.");

		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testClickOnSignInLinkUserShouldNavigateToLoginPage() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedLoginPageTitle = (String) Excel.getData("LoginPage", 1, 0);
		String expectedLoginPageUrl = (String) Excel.getData("LoginPage", 1, 1);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking sign in link.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		boolean clickStatus = header.clickSignInTextDesktop();
		softAssert.assertTrue(clickStatus, "Click on Sign in link failed.");

		softAssert.assertTrue(
				header.waitForPageToLoad(expectedLoginPageTitle, expectedLoginPageUrl,
						"Login Page After Clicking Sign In Link"),
				"Login page did not open after clicking Sign in link.");

		softAssert.assertAll();
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testClickOnSearchIconWithoutEnteringAnythingUserShouldStayOnCurrentPage()
			throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedHomePageUrl = (String) Excel.getData("HomePage", 1, 1);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking empty search.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		softAssert.assertTrue(header.clearInputField(header.getSearchInputField(), "Header Search Input Field"),
				"Unable to clear header search input field.");

		softAssert.assertTrue(
				header.verifyInputFieldValue(header.getSearchInputField(), "", "Header Search Input Field"),
				"Header search input field is not empty before clicking search button.");

		boolean clickStatus = header.clickSearchButtonDesktop();
		softAssert.assertTrue(clickStatus, "Click on empty search button failed.");

		Thread.sleep(1000);

		softAssert.assertTrue(header.verifyTitleOfWebpage(expectedHomePageTitle),
				"User did not stay on homepage after clicking empty search.");

		softAssert.assertTrue(header.verifyUrlOfWebpage(expectedHomePageUrl),
				"User was navigated away from homepage after clicking empty search.");

		softAssert.assertAll();
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testClickOnWishlistIconUserShouldNavigateToWishlistPage() throws IOException, InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedWishlistPageTitle = (String) Excel.getData("WishlistPage", 1, 0);
		String expectedWishlistPageUrl = (String) Excel.getData("WishlistPage", 1, 1);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
				"Homepage title verification failed before clicking wishlist icon.");

		Header header = new Header(driver);
		Thread.sleep(1000);

		boolean clickStatus = header.clickWishlistIconDesktop();
		softAssert.assertTrue(clickStatus, "Click on wishlist icon failed.");

		softAssert.assertTrue(
				header.waitForPageToLoad(expectedWishlistPageTitle, expectedWishlistPageUrl,
						"Wishlist Page After Clicking Wishlist Icon"),
				"Wishlist page did not open after clicking wishlist icon.");

		softAssert.assertAll();
	}
}