package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class ET_1256_EnterCategoryNameInSearchFieldAllProductsBelongingToThatCategoryShouldBeShown extends OpenClose {

	@Test
	public void testEnterCategoryNameInSearchFieldAllProductsBelongingToThatCategoryShouldBeShown()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String categoryName = (String) Excel.getData("SearchProductsPage", 6, 0);
		hp.enterValueIntoSearchField(categoryName);
		Thread.sleep(1000);
		hp.clickSearchButtonDesktop();
		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl().toLowerCase();
		Assert.assertTrue(currentUrl.contains(categoryName.toLowerCase()),
				"Search results page url is not updated with searched category name.");

		String pageSource = driver.getPageSource().toLowerCase();
		Assert.assertTrue(pageSource.contains(categoryName.toLowerCase()),
				"Products related to entered category are not shown in search results page.");
	}
}