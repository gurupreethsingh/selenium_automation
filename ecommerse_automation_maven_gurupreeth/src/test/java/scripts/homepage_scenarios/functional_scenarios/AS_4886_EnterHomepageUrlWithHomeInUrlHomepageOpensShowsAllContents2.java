package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_4886_EnterHomepageUrlWithHomeInUrlHomepageOpensShowsAllContents2 extends OpenClose {

	@Test
	public void testEnterHomepageUrlWithHomeInBrowserHomepageShouldOpenShowingAllContents()
			throws IOException, InterruptedException {

		String homepageUrlWithHome = (String) Excel.getData("HomePage", 1, 2);
		driver.get(homepageUrlWithHome);

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		// verify the main parent container / root container of homepage is displayed
		hp.isHomePageRootDisplayed();
	}
}