package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5243_VerifyCategoryMainHeadingText extends OpenClose {

	@Test
	public void textVerifyCategoryMainHeadingText() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		softAssert.assertTrue(hp.verifyHomepageTitle(homepageExpectedText), "Homepage title verification failed");

		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);
		// now verify the main category heading text.
		softAssert.assertTrue(hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText),
				"Category main heading text verification failed");

		softAssert.assertAll();
	}
}