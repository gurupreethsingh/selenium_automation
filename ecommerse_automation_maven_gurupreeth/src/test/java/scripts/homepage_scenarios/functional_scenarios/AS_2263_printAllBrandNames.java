package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_2263_printAllBrandNames extends OpenClose {

	@Test
	public void testPrintAllBrandNames() throws IOException {
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		HomePage hp = new HomePage(driver);

		Assert.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Homepage title verification failed");

		List<String> brands = hp.printAllBrandNamesUsingJavascript();
//		hp.printAllBrandNames();

		Assert.assertFalse(brands.isEmpty(), "Brand names list is empty");

	}
}