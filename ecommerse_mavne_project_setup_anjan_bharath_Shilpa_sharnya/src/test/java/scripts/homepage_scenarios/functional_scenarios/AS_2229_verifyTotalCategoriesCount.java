package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2229_verifyTotalCategoriesCount extends OpenClose {
	@Test
	public void testVerifyTotalCategoriesCount() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the category count
		int expectedCategoryCount = 10;
		hp.verifyTotalCategoriesItemsCount(expectedCategoryCount);

		Assert.assertEquals(hp.verifyTotalCategoriesItemsCount(expectedCategoryCount), true,
				"Verifying the total Category Count of category section Failed.");

	}

}
