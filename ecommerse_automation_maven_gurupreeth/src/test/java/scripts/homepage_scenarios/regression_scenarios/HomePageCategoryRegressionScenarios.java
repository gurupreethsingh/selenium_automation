package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;
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

		// Step 1: Get expected data
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		// Step 2: Initialize POM
		HomePage hp = new HomePage(driver);

		// Step 3: Verify Title (Soft Assert)
		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		// Step 4: Verify Category Parent Container
		boolean isCategoryContainerVisible = hp.verifyCategoryParentContainerIsDisplayed();

		softAssert.assertTrue(isCategoryContainerVisible, "Category Parent Container is NOT visible on Homepage");

		// Step 5: IMPORTANT (Without this SoftAssert won't work)
		softAssert.assertAll();
	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testVerifyCategoryMainHeadingText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		// Step 1: Expected homepage title
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		// Step 2: Verify homepage title
		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		// Step 3: Verify Category Main Heading
		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);

		boolean isMainHeadingCorrect = hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText);

		softAssert.assertTrue(isMainHeadingCorrect, "Category Main Heading text mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testVerifyCategorySubHeadingText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		// Step 1: Expected homepage title
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		// Step 2: Verify homepage title
		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");

		// Step 3: Verify Category Sub Heading
		String expectedCategorySubHeadingText = (String) Excel.getData("HomePage", 1, 6);

		boolean isSubHeadingCorrect = hp.verifyCategorySubHeadingText(expectedCategorySubHeadingText);

		softAssert.assertTrue(isSubHeadingCorrect, "Category Sub Heading text mismatch");

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = true, invocationCount = 1)
	public void testVerifyCategoryCountText() throws IOException {

		SoftAssert softAssert = new SoftAssert();
		// Step 1: Expected homepage title
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);
		HomePage hp = new HomePage(driver);
		// Step 2: Verify homepage title
		boolean isTitleCorrect = hp.verifyHomepageTitle(homepageExpectedText);
		softAssert.assertTrue(isTitleCorrect, "Homepage title verification failed");
		// Step 3: Verify Category Count Text
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

	// print all the category names without javascript
	@Test(priority = 6, enabled = true, invocationCount = 1)
	public void testPrintingAllCategoryNames() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		// Verify homepage title
		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		// Get category elements
		List<WebElement> categories = hp.printAllCategoryNames();

		// Null check
		softAssert.assertNotNull(categories, "Category WebElement list is NULL");

		// Empty check (safe)
		softAssert.assertTrue(categories != null && !categories.isEmpty(), "Category names list is empty");

		softAssert.assertAll();
	}

	// print all the category names with javascript.
	@Test(priority = 7, enabled = true, invocationCount = 1)
	public void testPrintAllCategoryNamesUsingJavascript() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		// Verify homepage title
		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		// Get category names (String list)
		List<String> categories = hp.printAllCategoryNamesUsingJavascript();

		// Null check
		softAssert.assertNotNull(categories, "Category String list is NULL");

		// Empty check (safe)
		softAssert.assertTrue(categories != null && !categories.isEmpty(), "Category names list is empty");

		softAssert.assertAll();
	}

	// verify the main heading in the search products page.
	@Test(priority = 8, enabled = true, invocationCount = 1)
	public void testClick1CategoryVerifyMainHeadingInSearchProduct() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		Assert.assertTrue(hp.clickOnCategory(), "Category click on Electronics failed.");

		// now after click user navigates to search products page.
		SearchProductsPage spp = new SearchProductsPage(driver);

		String searchProductsPageExpectedText = (String) Excel.getData("SearchProductsPage", 1, 0);

		Assert.assertTrue(spp.verifySearchProductsPageTitle(searchProductsPageExpectedText),
				"Search products page title verification failed");

		String categoryName = "Electronics";
		String expectedSearchProductsPageUrl = "http://localhost:5173/search-products?query=" + categoryName;

		Assert.assertTrue(spp.verifyUrlOfWebpage(expectedSearchProductsPageUrl));

		// verity the main heading in the search products page.
		softAssert.assertTrue(spp.verifyMainHeadingTextContainsBrandName(categoryName),
				"Search products main heading verification failed");
		softAssert.assertAll();

	}

}
