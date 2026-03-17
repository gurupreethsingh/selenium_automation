package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5243_VerifyCategoryMainHeadingText extends OpenClose {
	@Test
	public void textVerifyCategoryMainHeadingText() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the main category heading text.
		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);
		hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText);

	}
}
