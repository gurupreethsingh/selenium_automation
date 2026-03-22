package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class HomePageCategoryRegressionScenarios extends OpenClose {

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testVerifyCategorySectionParentContainerIsDisplayed() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		boolean isCategoryContainerVisible = hp.verifyCategoryParentContainerIsDisplayed();
		softAssert.assertTrue(isCategoryContainerVisible, "Category Parent Container is NOT visible on Homepage");

		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testVerifyCategoryMainHeadingText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);
		boolean isMainHeadingCorrect = hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText);

		softAssert.assertTrue(isMainHeadingCorrect, "Category Main Heading text mismatch");
		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testVerifyCategorySubHeadingText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		String expectedCategorySubHeadingText = (String) Excel.getData("HomePage", 1, 6);
		boolean isSubHeadingCorrect = hp.verifyCategorySubHeadingText(expectedCategorySubHeadingText);

		softAssert.assertTrue(isSubHeadingCorrect, "Category Sub Heading text mismatch");
		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifyCategoryCountText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		boolean isCountTextCorrect = hp.verifyCategoryCountText(expectedCategoryCountText);

		softAssert.assertTrue(isCountTextCorrect, "Category Count text mismatch");
		softAssert.assertAll();
	}

	@Test(priority = 5, enabled = true, invocationCount = 1)
	public void testVerifyTotalCategoryCount() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		hp.verifyHomepageTitle(homepageExpectedText);

		int expectedCategoriesCount = 10;

		softAssert.assertTrue(hp.verifyTotalCategoryCount(expectedCategoriesCount),
				"Total category count verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testPrintAllCategoryNames_WebElementList() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<WebElement> categories = hp.printAllCategoryNames();

		softAssert.assertNotNull(categories, "Category WebElement list is NULL");
		softAssert.assertTrue(categories != null && !categories.isEmpty(), "Category names list is empty");

		softAssert.assertAll();
	}

	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testPrintAllCategoryNamesUsingJavascript_MainCategories() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<String> categories = hp.printAllCategoryNamesUsingJavascript();

		softAssert.assertNotNull(categories, "Category String list is NULL");
		softAssert.assertTrue(categories != null && !categories.isEmpty(), "Category names list is empty");

		softAssert.assertAll();
	}

	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClick1CategoryVerifyMainHeadingInSearchProduct() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");
		Assert.assertTrue(hp.clickOnCategory(), "Category click on Electronics failed.");

		SearchProductsPage spp = new SearchProductsPage(driver);

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String categoryName = "Electronics";
		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl));

		softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
				"Search products main heading verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 9, enabled = true, invocationCount = 1)
	public void testClick1CategoryNavigateToSearchProduct_DynamicCategory() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String categoryName = hp.fetchSingleCategoryNameText();
		Assert.assertFalse(categoryName.isEmpty(), "Fetched category name is empty");

		System.out.println("[CLICKING CATEGORY] " + categoryName);

		Assert.assertTrue(hp.clickOnAnyCategory(), "Category click failed for: " + categoryName);

		SearchProductsPage spp = new SearchProductsPage(driver);

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl),
				"URL verification failed for category: " + categoryName);
	}

	@Test(priority = 10, enabled = true, invocationCount = 1)
	public void testPrintingAllCategoryNames_FromFunctionalClass() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<WebElement> categories = hp.printAllCategoryNames();

		Assert.assertFalse(categories.isEmpty(), "Category names list is empty");
	}

	@Test(priority = 11, enabled = true, invocationCount = 1)
	public void testPrintingAllCategoryNamesInSubHeading_WebElementList() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<WebElement> categories = hp.printAllCategorySubHeadingNames();

		Assert.assertFalse(categories.isEmpty(), "Category names list is empty");

		String commonExpectedText = "Discover top-rated items in ";

		for (int i = 0; i < categories.size(); i++) {
			String actualText = categories.get(i).getText().trim();

			System.out.println("Category Paragraph " + (i + 1) + " : " + actualText);

			softAssert.assertTrue(actualText.startsWith(commonExpectedText),
					"Paragraph does not start with expected common text at index " + i + " | Actual Text: "
							+ actualText);

			String dynamicCategoryName = actualText.replace(commonExpectedText, "").trim();

			softAssert.assertFalse(dynamicCategoryName.isEmpty(),
					"Dynamic category name is missing at index " + i + " | Actual Text: " + actualText);
		}

		softAssert.assertAll();
	}

	@Test(priority = 12, enabled = true, invocationCount = 1)
	public void testPrintingAllCategoryNamesUsingJavascript_InSubheading() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<String> categories = hp.printAllCategorySubHeadingNamesUsingJavascript();

		Assert.assertFalse(categories.isEmpty(), "Category names list is empty");

		String commonExpectedText = "Discover top-rated items in ";

		for (int i = 0; i < categories.size(); i++) {
			String actualText = categories.get(i).trim();

			System.out.println("Category Paragraph " + (i + 1) + " : " + actualText);

			softAssert.assertTrue(actualText.startsWith(commonExpectedText),
					"Paragraph does not start with expected common text at index " + i + " | Actual Text: "
							+ actualText);

			String dynamicCategoryName = actualText.replace(commonExpectedText, "").trim();

			softAssert.assertFalse(dynamicCategoryName.isEmpty(),
					"Dynamic category name is missing at index " + i + " | Actual Text: " + actualText);
		}

		softAssert.assertAll();
	}

	@Test(priority = 13, enabled = true, invocationCount = 1)
	public void testVerifyTotalCategoryCount_Functional() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		int expectedCategoriesCount = 10;

		Assert.assertTrue(hp.verifyTotalCategoryCount(expectedCategoriesCount),
				"Total category count verification failed");
	}

	@Test(priority = 14, enabled = true, invocationCount = 1)
	public void testFetchAllProductsIn1CategoryInSearchProductsPg() throws IOException, InterruptedException {

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		String categoryName = (String) Excel.getData("HomePage", 10, 2);

		System.out.println("Category fetched from Excel: " + categoryName);

		Assert.assertNotNull(categoryName, "Category name from Excel is null");
		Assert.assertFalse(categoryName.trim().isEmpty(), "Category name from Excel is empty");

		Assert.assertTrue(hp.clickCategoryByName(categoryName), "Failed to click category: " + categoryName);

		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);
		spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle);

		Thread.sleep(3000);

		spp.fetchAllProductsOfACategory(categoryName);

		Thread.sleep(3000);
	}

	@Test(priority = 15, enabled = true, invocationCount = 1)
	public void testFetchAllProductsInAllCategoriesInSearchProductsPg() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page"),
				"Home page did not load properly at test start");

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		for (int row = 6; row <= 15; row++) {

			String categoryName = null;

			try {
				categoryName = (String) Excel.getData("HomePage", row, 2);

				System.out.println("\n====================================================");
				System.out.println("Processing Excel Row : " + row);
				System.out.println("Category fetched from Excel : " + categoryName);
				System.out.println("====================================================");

				softAssert.assertNotNull(categoryName, "Category name is null at row: " + row);

				if (categoryName == null || categoryName.trim().isEmpty()) {
					System.out.println("[SKIPPING] Category name is null/empty at row: " + row);
					continue;
				}

				categoryName = categoryName.trim();

				String expectedSearchProductsPageUrl = "/search-products?query=" + categoryName;

				hp = new HomePage(driver);

				softAssert.assertTrue(
						hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page Before Clicking Category"),
						"Homepage was not fully loaded before clicking category: " + categoryName);

				softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
						"Homepage title verification failed before clicking category: " + categoryName);

				boolean clickStatus = hp.clickCategoryByName(categoryName);
				softAssert.assertTrue(clickStatus,
						"Failed to click category: " + categoryName + " at Excel row: " + row);

				if (!clickStatus) {
					continue;
				}

				SearchProductsPage spp = new SearchProductsPage(driver);

				softAssert.assertTrue(
						spp.waitForPageToLoad(expectedSearchProductsPageTitle, expectedSearchProductsPageUrl,
								"Search Products Page"),
						"Search Products page did not load properly for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
						"Search Products page title verification failed for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedSearchProductsPageUrl),
						"Search Products page URL verification failed for category: " + categoryName);

				List<WebElement> fetchedProducts = spp.fetchAllProductsOfACategory(categoryName);

				softAssert.assertNotNull(fetchedProducts,
						"Fetched products list is null for category: " + categoryName);

				if (fetchedProducts != null) {
					softAssert.assertFalse(fetchedProducts.isEmpty(),
							"No products found for category: " + categoryName);

					System.out.println("Total products fetched for [" + categoryName + "] : " + fetchedProducts.size());
				}

				System.out.println("===================================================================");

			} catch (Exception ex) {
				System.out.println(
						"[TEST FLOW FAILED] Category: " + categoryName + " | Row: " + row + " | " + ex.getMessage());
				softAssert.fail(
						"Test flow failed for category: " + categoryName + " at row: " + row + " | " + ex.getMessage());
			} finally {
				try {
					driver.navigate().back();

					hp = new HomePage(driver);

					softAssert.assertTrue(
							hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page After Navigate Back"),
							"Failed to return to homepage after category flow. Category: " + categoryName);

					softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
							"Homepage title verification failed after navigating back. Category: " + categoryName);

				} catch (Exception backEx) {
					System.out.println(
							"[NAVIGATION BACK FAILED] Category: " + categoryName + " | " + backEx.getMessage());
					softAssert.fail("Navigation back to homepage failed after category: " + categoryName + " | "
							+ backEx.getMessage());
				}
			}
		}

		softAssert.assertAll();
	}

	@Test(priority = 16, enabled = true, invocationCount = 1)
	public void testClickingAllCategoryShopButtonsOneByOne() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page"),
				"Home page did not load properly at test start");

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		for (int row = 6; row <= 15; row++) {

			String categoryName = null;

			try {
				categoryName = (String) Excel.getData("HomePage", row, 2);

				System.out.println("\n====================================================");
				System.out.println("Processing Excel Row : " + row);
				System.out.println("Category fetched from Excel : " + categoryName);
				System.out.println("====================================================");

				softAssert.assertNotNull(categoryName, "Category name is null at row: " + row);

				if (categoryName == null || categoryName.trim().isEmpty()) {
					System.out.println("[SKIPPING] Category name is null/empty at row: " + row);
					continue;
				}

				categoryName = categoryName.trim();

				String expectedSearchProductsPageUrl = "/search-products?query=" + categoryName;

				hp = new HomePage(driver);

				softAssert.assertTrue(
						hp.waitForPageToLoad(expectedHomePageTitle, null,
								"Home Page Before Clicking Category Shop Button"),
						"Homepage was not fully loaded before clicking category shop button: " + categoryName);

				softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
						"Homepage title verification failed before clicking category shop button: " + categoryName);

				boolean clickStatus = hp.clickShopButtonByCategoryName(categoryName);
				softAssert.assertTrue(clickStatus,
						"Failed to click shop button for category: " + categoryName + " at Excel row: " + row);

				if (!clickStatus) {
					continue;
				}

				SearchProductsPage spp = new SearchProductsPage(driver);

				softAssert.assertTrue(
						spp.waitForPageToLoad(expectedSearchProductsPageTitle, expectedSearchProductsPageUrl,
								"Search Products Page"),
						"Search Products page did not load properly for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
						"Search Products page title verification failed for category: " + categoryName);

				softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedSearchProductsPageUrl),
						"Search Products page URL verification failed for category: " + categoryName);

				List<WebElement> fetchedProducts = spp.fetchAllProductsOfACategory(categoryName);

				softAssert.assertNotNull(fetchedProducts,
						"Fetched products list is null for category: " + categoryName);

				if (fetchedProducts != null) {
					softAssert.assertFalse(fetchedProducts.isEmpty(),
							"No products found for category: " + categoryName);

					System.out.println("Total products fetched for [" + categoryName + "] : " + fetchedProducts.size());
				}

				System.out.println("===================================================================");

			} catch (Exception ex) {
				System.out.println(
						"[TEST FLOW FAILED] Category: " + categoryName + " | Row: " + row + " | " + ex.getMessage());
				softAssert.fail(
						"Test flow failed for category: " + categoryName + " at row: " + row + " | " + ex.getMessage());
			} finally {
				try {
					driver.navigate().back();

					hp = new HomePage(driver);

					softAssert.assertTrue(
							hp.waitForPageToLoad(expectedHomePageTitle, null, "Home Page After Navigate Back"),
							"Failed to return to homepage after category flow. Category: " + categoryName);

					softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle),
							"Homepage title verification failed after navigating back. Category: " + categoryName);

				} catch (Exception backEx) {
					System.out.println(
							"[NAVIGATION BACK FAILED] Category: " + categoryName + " | " + backEx.getMessage());
					softAssert.fail("Navigation back to homepage failed after category: " + categoryName + " | "
							+ backEx.getMessage());
				}
			}
		}

		softAssert.assertAll();
	}

	@Test(priority = 17, enabled = true, invocationCount = 1)
	public void testClickAnyShopButtonOnCategoryCard() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String categoryName = hp.fetchSingleCategoryNameText();
		Assert.assertFalse(categoryName.isEmpty(), "Fetched category name is empty");

		System.out.println("[CLICKING CATEGORY] " + categoryName);

		Assert.assertTrue(hp.clickOnAnyShopButtonOfCategory(),
				"Category shop button click failed for: " + categoryName);

		SearchProductsPage spp = new SearchProductsPage(driver);

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl),
				"URL verification failed for category: " + categoryName);
	}

	@Test(priority = 18, enabled = true, invocationCount = 1)
	public void testEnterHomepageUrlWithHomeInBrowserHomepageShouldOpenShowingAllContents() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageUrlWithHome = (String) Excel.getData("HomePage", 1, 2);
		driver.get(homepageUrlWithHome);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		softAssert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		softAssert.assertTrue(hp.verifyHomePageRootContainerIsDisplayedAndEnabled(),
				"Homepage root container is not displayed and enabled");

		softAssert.assertAll();
	}

	@Test(priority = 19, enabled = true, invocationCount = 1)
	public void textVerifyCategoryMainHeadingText_FunctionalVersion() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);

		softAssert.assertTrue(hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText),
				"Category main heading text verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 20, enabled = true, invocationCount = 1)
	public void testVerifyCategoryHighlightedInSearchProducts() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String categoryName = (String) Excel.getData("HomePage", 10, 2);

		softAssert.assertTrue(hp.clickAllCategoriesByName(categoryName),
				"Failed to click category from homepage: " + categoryName);

		SearchProductsPage spp = new SearchProductsPage(driver);
		String expectedTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedTitle),
				"Search products page title verification failed");

		String expectedUrl = "http://localhost:5173/search-products?query=" + categoryName;

		softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedUrl),
				"Search products page URL verification failed");

		softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
				"Search products main heading verification failed for category: " + categoryName);

		softAssert.assertTrue(spp.verifyCategoryDropdownIsDisplayed(), "Category dropdown is not displayed");

		spp.fetchAndPrintAllCategoryDropdownOptions();

		softAssert.assertTrue(spp.verifyCategoryExistsInDropdown(categoryName),
				"Expected category does not exist in dropdown: " + categoryName);

		softAssert.assertTrue(spp.verifySelectedCategoryHighlightedInDropdown(categoryName),
				"Selected category is NOT highlighted in orange in dropdown: " + categoryName);

		spp.fetchAndPrintAllExpandedCategoryOptions();

		softAssert.assertAll();
	}

	@Test(priority = 21, enabled = true, invocationCount = 1)
	public void testVerifyCategoryHighlightedInSearchProductsForAllCategories() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		String expectedSearchProductsPageTitle = (String) Excel.getData("SearchProductsPage", 1, 0);

		for (int row = 6; row <= 15; row++) {

			System.out.println("============================================================");
			System.out.println("[TEST STARTED FOR CATEGORY ROW] " + row);
			System.out.println("============================================================");

			driver.get("http://localhost:5173/");

			HomePage hp = new HomePage(driver);

			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed at row: " + row);

			String categoryName = (String) Excel.getData("HomePage", row, 2);

			System.out.println("[CATEGORY FROM EXCEL] Row: " + row + " | Category: " + categoryName);

			softAssert.assertTrue(hp.clickAllCategoriesByName(categoryName),
					"Failed to click category from homepage: " + categoryName + " at row: " + row);

			SearchProductsPage spp = new SearchProductsPage(driver);

			softAssert.assertTrue(spp.verifySearchProductsPageTitle(expectedSearchProductsPageTitle),
					"Search products page title verification failed for category: " + categoryName + " at row: " + row);

			String expectedUrl = "http://localhost:5173/search-products?query=" + categoryName;

			softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedUrl),
					"Search products page URL verification failed for category: " + categoryName + " at row: " + row);

			softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
					"Search products main heading verification failed for category: " + categoryName + " at row: "
							+ row);

			softAssert.assertTrue(spp.verifyCategoryDropdownIsDisplayed(),
					"Category dropdown is not displayed for category: " + categoryName + " at row: " + row);

			spp.fetchAndPrintAllCategoryDropdownOptions();

			softAssert.assertTrue(spp.verifyCategoryExistsInDropdown(categoryName),
					"Expected category does not exist in dropdown: " + categoryName + " at row: " + row);

			softAssert.assertTrue(spp.verifySelectedCategoryHighlightedInDropdown(categoryName),
					"Selected category is NOT highlighted in orange in dropdown: " + categoryName + " at row: " + row);

			spp.fetchAndPrintAllExpandedCategoryOptions();

			System.out.println("============================================================");
			System.out.println("[TEST COMPLETED FOR CATEGORY] " + categoryName + " | Row: " + row);
			System.out.println("============================================================");
		}

		softAssert.assertAll();
	}

	@Test(priority = 22, enabled = true, invocationCount = 1)
	public void testEnterForwardSlashHomepageInUrlHomeOpenHpShowsAllContents() throws IOException {

		SoftAssert sa = new SoftAssert();

		driver.navigate().to(URL_HOME_ALT_2);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		sa.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Title verification with /homepage in url failed");

		sa.assertAll();
	}

	@Test(priority = 23, enabled = true, invocationCount = 1)
	public void testEnterForwardSlashUrlInUrlHomepageShouldOpenShowsAllContents() throws IOException {

		SoftAssert sa = new SoftAssert();

		driver.navigate().to(URL_HOME_ALT_1);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		sa.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Title verification with /home in url failed");

		sa.assertAll();
	}

	@Test(priority = 24, enabled = true, invocationCount = 1)
	public void testEnterOnlyForwardSlashInUrlofHomeOpensHpShowsAllContents() throws IOException {

		SoftAssert sa = new SoftAssert();

		driver.navigate().to(URL_HOME);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		sa.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Title verification with / in url failed");

		sa.assertAll();
	}

	@Test(priority = 25, enabled = true, invocationCount = 1)
	public void textVerifyCategoryCountText_FunctionalVersion() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		softAssert.assertTrue(hp.verifyCategoryCountText(expectedCategoryCountText),
				"Category count text verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 26, enabled = true, invocationCount = 1)
	public void textVerifyCategorySubHeadingText_FunctionalVersion() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String expectedCategorySubHeadingText = (String) Excel.getData("HomePage", 1, 6);
		softAssert.assertTrue(hp.verifyCategorySubHeadingText(expectedCategorySubHeadingText),
				"Category sub heading text verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 27, enabled = true, invocationCount = 1)
	public void testClick1CategoryVerifyMainHeadingInSearchProduct_FunctionalVersion() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		Assert.assertTrue(hp.clickOnCategory(), "Category click on Electronics failed.");

		SearchProductsPage spp = new SearchProductsPage(driver);

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String categoryName = "Electronics";
		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl));

		softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
				"Search products main heading verification failed");

		softAssert.assertAll();
	}

	@Test(priority = 28, enabled = true, invocationCount = 1)
	public void testClickAllCategoryVerifyMainHeadingInSearchProduct() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<String> expectedCategories = new ArrayList<>();

		for (int row = 6; row <= 15; row++) {
			String categoryName = (String) Excel.getData("HomePage", row, 2);

			if (categoryName != null && !categoryName.trim().isEmpty()) {
				expectedCategories.add(categoryName.trim());
			}
		}

		softAssert.assertFalse(expectedCategories.isEmpty(), "Expected category list from Excel is empty");

		System.out.println("==================================================");
		System.out.println("[CATEGORY LOOP START]");
		System.out.println("Total Categories To Test: " + expectedCategories.size());
		System.out.println("==================================================");

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		for (int i = 0; i < expectedCategories.size(); i++) {

			String categoryName = expectedCategories.get(i);

			System.out.println("--------------------------------------------------");
			System.out.println("[TESTING CATEGORY] " + (i + 1) + ". " + categoryName);
			System.out.println("--------------------------------------------------");

			hp = new HomePage(driver);

			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed before clicking category: " + categoryName);

			boolean clicked = hp.clickAllCategoriesByName(categoryName);

			softAssert.assertTrue(clicked, "Failed to click category: " + categoryName);

			if (!clicked) {
				continue;
			}

			SearchProductsPage spp = new SearchProductsPage(driver);

			softAssert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
					"Search products page title verification failed for category: " + categoryName);

			String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

			softAssert.assertTrue(spp.verifySearchProductsPageUrl(expectedSearchProductsPageUrl),
					"Search products page URL verification failed for category: " + categoryName);

			softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
					"Search products main heading verification failed for category: " + categoryName);

			driver.navigate().back();

			hp = new HomePage(driver);

			softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText),
					"Homepage title verification failed after navigating back from category: " + categoryName);

			softAssert.assertTrue(hp.verifyCategoryParentContainerIsDisplayed(),
					"Homepage category section not visible after navigating back from category: " + categoryName);
		}

		System.out.println("==================================================");
		System.out.println("[CATEGORY LOOP COMPLETED]");
		System.out.println("==================================================");

		softAssert.assertAll();
	}
}