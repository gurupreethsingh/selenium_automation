package scripts.shoppage_scripts.functional_scenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ShopPage;

public class AS_SP_01_openShopUsingUrl extends OpenClose {

	// add a test function to do the automation.

	@Test
	public void testOpenShopUsingUrl() throws InterruptedException {
		// you will be in homepage.
		driver.navigate().to(URL_SHOP);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		ShopPage sp = new ShopPage(driver);
		sp.verifyShopPageTitle("Shop | ECODERS");
		Thread.sleep(2000);
	}
}
