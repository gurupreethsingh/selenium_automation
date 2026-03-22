package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_6550_VerifyCategoryCountText extends OpenClose {
	@Test
	public void textVerifyCategoryCountText() throws IOException {
		SoftAssert sa = new SoftAssert();

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		// now verify the Sub category heading text.
		String expectedCategoryCountText = (String) Excel.getData("HomePage", 1, 7);
		sa.assertTrue(hp.verifyCategoryCountText(expectedCategoryCountText), "verification Of Count Text failed");

		sa.assertAll();

	}
}
