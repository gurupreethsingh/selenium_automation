package scripts.homepage_scenarios.functional_scenarios;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;
import pom.Shoppage;

public class AS_6496_ClickShopAllLinkFromHeaderOpenShopPage extends OpenClose {

	@Test
	public void testClickShopAllLinkFromHeaderOpenShopPage() {

		Homepage hp = new Homepage(driver);
		String expectedHomeTitle = Excel.getData1("Homepage", 1, 0);
		hp.verifyHomepageTitle(expectedHomeTitle);

		// update row/col as per your excel
		hp.clickOnShopAllLink();

		Shoppage sp = new Shoppage(driver);
		String expectedShopTitle = Excel.getData1("Shoppage", 1, 0);
		sp.verifyShoppageTitle(expectedShopTitle);

	}
}
