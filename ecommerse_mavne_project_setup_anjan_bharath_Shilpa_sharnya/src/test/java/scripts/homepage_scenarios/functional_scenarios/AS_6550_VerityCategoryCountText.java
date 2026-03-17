package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_6550_VerityCategoryCountText extends OpenClose {
	@Test
	public void testVerityCategoryCountTextText() throws IOException {
		// open the application and navigate to the homepage.
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the Sub heading of the category section.
		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		System.out.println("Data from excel sheet " + expectedCategoryCountText);
		hp.verifyCategoryCountText();

		Assert.assertEquals(hp.verifyCategoryCountText(), expectedCategoryCountText,
				"Verifying the Category Count text of category section Failed.");

	}
}
