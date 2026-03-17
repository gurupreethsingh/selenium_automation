package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_5243_VerityCategoryMainHeadingText extends OpenClose {
	@Test
	public void testVerityCategoryMainHeadingText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main heading of the category section.
		String expectedCategoryMainHeading = (String) Excel.getData("HomePage", 1, 5);
		System.out.println("Data from excel sheet " + expectedCategoryMainHeading);
		hp.verifyCategoryMainHeadingText();

		Assert.assertEquals(hp.verifyCategoryMainHeadingText(), expectedCategoryMainHeading,
				"Verifying the Main heading text of category");

	}
}
