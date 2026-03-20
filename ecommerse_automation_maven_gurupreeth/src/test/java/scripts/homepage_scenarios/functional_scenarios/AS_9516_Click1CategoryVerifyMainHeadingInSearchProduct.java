package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.SearchProductsPage;

public class AS_9516_Click1CategoryVerifyMainHeadingInSearchProduct extends OpenClose {

	@Test
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
