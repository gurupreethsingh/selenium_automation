package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1660_printAllCategoryNamesUsingJavascriptInSubheading extends OpenClose {

	@Test
	public void testPrintingAllCategoryNames() throws IOException {

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
}