package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_01_enterMultipleValueIntoSearchFieldHeader extends OpenClose {
	@Test
	public void testEnterValueIntoSearchFieldHeaderOfHomepage() throws IOException, InterruptedException {

		for (int i = 6; i <= 8; i++) {
			HomePage hp = new HomePage(driver);

			String valueToEnter = (String) Excel.getData("HomePage", i, 0);

			hp.enterValueIntoHeaderSearchInputField(valueToEnter, "Search products, brands, categories...",
					"Header Search Field");

			Thread.sleep(1000);
			hp.clickOnSearchButtonOfHeader();

			Thread.sleep(1000);
			driver.navigate().to(BASE_URL);
		}

	}
}
