package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;
import pom.LoginPage;

public class AS_ET_7933_ClickUserAvatarIconFromHeaderOfHompageUserShouldNavigateToLoginPage extends OpenClose {

	@Test
	public void testClickUserAvatarIconFromHeaderOfHompageUserShouldNavigateToLoginPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		hp.clickSignInAvatarDesktop();

		LoginPage lp = new LoginPage(driver);
		String expectedLoginPageTitle = (String) Excel.getData("LoginPage", 1, 0);
		lp.verifyLoginPageTitle(expectedLoginPageTitle);
	}
}