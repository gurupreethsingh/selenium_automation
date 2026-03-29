
package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Header;
import pom.HomePage;

public class AS_ET_4135_ClickCartIconMiniCartShouldExpandAndBecomeVisible extends OpenClose {

	@Test
	public void testClickCartIconMiniCartShouldExpandAndBecomeVisible() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		Header header = new Header(driver);
		header.clickMiniCartViewCart();
		Thread.sleep(1000);

		header.openMiniCart();
		Thread.sleep(2000);
		Assert.assertTrue(header.isMiniCartOpen(), "Mini cart is not expanded / visible after clicking cart icon.");
	}
}