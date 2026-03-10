package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5870_EnterForwardSlashUrlInUrlHomepageShouldOpenShowsAllContents extends OpenClose {

	@Test
	public void testEnterForwardSlashUrlInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		String homepageUrlWithForwardSlash = (String) Excel.getData("HomePage", 1, 1);
		driver.get(homepageUrlWithForwardSlash);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main parent container / root container of homepage is displayed
		hp.isHomePageRootDisplayed();
	}
}