package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5870_EnterOnlyForwardSlashInUrlofHomeOpensHpShowsAllContents extends OpenClose {

	@Test
	public void testEnterForwardSlashUrlInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		SoftAssert sa = new SoftAssert();

		driver.navigate().to(URL_HOME);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);

		sa.assertTrue(hp.verifyHomepageTitle(expectedHomePageTitle), "Title verification with / in url failed");

		sa.assertAll();
	}
}