package scripts.subscriptions_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SubscriptionsPage;

public class AS_7369_OpenSubscriptionsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSubscriptionsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SubscriptionsPage", 1, 0);

		driver.get(URL_ALL_SUBSCRIPTIONS);

		SubscriptionsPage page = new SubscriptionsPage(driver);
		page.verifySubscriptionsPageTitle(expectedTitle);
	}
}
