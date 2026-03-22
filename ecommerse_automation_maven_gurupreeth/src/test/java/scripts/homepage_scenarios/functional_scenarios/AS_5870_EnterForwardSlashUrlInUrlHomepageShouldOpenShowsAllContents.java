package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5870_EnterForwardSlashUrlInUrlHomepageShouldOpenShowsAllContents extends OpenClose {

	@Test
	public void testEnterForwardSlashUrlInUrlHomepageShouldOpenShowsAllContents()
			throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();

		driver.navigate().to(URL_HOME_ALT_1);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		sa.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Title verification with /home in url failed");

		sa.assertAll();
	}
}