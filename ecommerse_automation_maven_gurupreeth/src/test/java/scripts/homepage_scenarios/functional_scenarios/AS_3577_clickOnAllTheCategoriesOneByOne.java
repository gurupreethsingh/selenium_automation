package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_3577_clickOnAllTheCategoriesOneByOne extends OpenClose {

	@Test
	public void testClickingOnAllCategoryShopButtonsOneByOne() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		Assert.assertTrue(hp.clickOnEachCategoryShopButtons(), "Failed to click all category shop buttons one by one");
	}
}