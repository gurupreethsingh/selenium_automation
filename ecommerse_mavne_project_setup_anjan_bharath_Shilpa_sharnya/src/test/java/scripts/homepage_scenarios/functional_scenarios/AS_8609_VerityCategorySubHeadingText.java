package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_8609_VerityCategorySubHeadingText extends OpenClose {
	@Test
	public void testVerityCategorySubHeadingText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the Sub heading of the category section.
		String expectedCategorySubHeading = (String) Excel.getData("HomePage", 1, 6);
		System.out.println("Data from excel sheet " + expectedCategorySubHeading);
		hp.verifyCategorySubHeadingText();

		Assert.assertEquals(hp.verifyCategorySubHeadingText(), expectedCategorySubHeading,
				"Verifying the Sub heading text of category");

	}
}
