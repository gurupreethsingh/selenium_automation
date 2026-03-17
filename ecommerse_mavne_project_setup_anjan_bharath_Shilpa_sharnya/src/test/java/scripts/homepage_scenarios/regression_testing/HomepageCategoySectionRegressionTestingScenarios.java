package scripts.homepage_scenarios.regression_testing;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class HomepageCategoySectionRegressionTestingScenarios extends OpenClose {

	// category scenarios
	@Test(priority = 1, invocationCount = 1, enabled = true)
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

	@Test(priority = 2, invocationCount = 1, enabled = true)
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

	@Test(priority = 3, invocationCount = 1, enabled = true)
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

	@Test(priority = 4, invocationCount = 1, enabled = true)
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

	@Test(priority = 5, invocationCount = 1, enabled = true)
	public void testPrintAllCategoryNames() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.printAllCategoryNames();

	}

}
