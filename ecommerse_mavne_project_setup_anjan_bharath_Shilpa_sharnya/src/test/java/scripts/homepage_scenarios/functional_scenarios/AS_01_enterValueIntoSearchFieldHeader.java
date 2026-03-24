package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_01_enterValueIntoSearchFieldHeader extends OpenClose {
	@Test
	public void testEnterValueIntoSearchFieldHeaderOfHomepage() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String valueToEnter = (String) Excel.getData("HomePage", 6, 0);
		hp.enterValueIntoHeaderSearchInputField(valueToEnter, "Search products, brands, categories...",
				"Header Search Field");

		Thread.sleep(2000);
		hp.clickOnSearchButtonOfHeader();

		Thread.sleep(3000);

	}
}
