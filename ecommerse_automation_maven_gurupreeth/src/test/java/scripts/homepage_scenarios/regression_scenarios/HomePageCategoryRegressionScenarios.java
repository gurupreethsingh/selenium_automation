package scripts.homepage_scenarios.regression_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class HomePageCategoryRegressionScenarios extends OpenClose {
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void textVerifyCategoryMainHeadingText() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the main category heading text.
		String expectedCategoryMainHeadingText = (String) Excel.getData("HomePage", 1, 5);
		hp.verifyCategoryMainHeadingText(expectedCategoryMainHeadingText);

	}

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void textVerifyCategorySubHeadingText() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the Sub category heading text.
		String expectedCategorySubHeadingText = (String) Excel.getData("HomePage", 1, 6);
		hp.verifyCategorySubHeadingText(expectedCategorySubHeadingText);

	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void textVerifyCategoryCountText() throws IOException {
		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the Sub category heading text.
		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		hp.verifyCategoryCountText(expectedCategoryCountText);

	}

}
