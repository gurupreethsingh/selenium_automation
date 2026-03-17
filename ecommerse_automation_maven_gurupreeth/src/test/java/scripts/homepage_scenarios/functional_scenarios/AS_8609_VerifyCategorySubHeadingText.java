package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_8609_VerifyCategorySubHeadingText extends OpenClose {
	@Test
	public void textVerifyCategorySubHeadingText() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the Sub category heading text.
		String expectedCategorySubHeadingText = (String) Excel.getData("HomePage", 1, 6);
		hp.verifyCategorySubHeadingText(expectedCategorySubHeadingText);

	}
}
