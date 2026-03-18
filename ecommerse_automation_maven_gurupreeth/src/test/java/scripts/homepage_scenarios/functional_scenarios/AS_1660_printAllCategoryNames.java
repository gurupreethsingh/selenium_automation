package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1660_printAllCategoryNames extends OpenClose {

	@Test
	public void testPrintingAllCategoryNames() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		List<String> allCategoryNames = hp.printAllCategoryNamesFromSlider();

		Assert.assertTrue(allCategoryNames.size() > 0, "No category names were fetched from the slider");
	}
}