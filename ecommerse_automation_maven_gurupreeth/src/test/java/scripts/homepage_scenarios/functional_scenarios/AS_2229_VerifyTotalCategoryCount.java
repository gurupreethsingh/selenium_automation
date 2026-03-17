package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2229_VerifyTotalCategoryCount extends OpenClose {
	@Test
	public void testVerifyTotalCategoryCount() throws IOException {

		String homepageExpectedText = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);
		hp.verifyHomepageTitle(homepageExpectedText);

		int expectedCategoriesCount = 10;

		Assert.assertTrue(hp.verifyTotalCategoryCount(expectedCategoriesCount),
				"Total category count verification failed");
	}

}
