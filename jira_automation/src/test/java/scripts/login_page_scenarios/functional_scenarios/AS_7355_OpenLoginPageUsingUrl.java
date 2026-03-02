package scripts.login_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.LoginPage;

public class AS_7355_OpenLoginPageUsingUrl extends OpenClose {

	@Test
	public void testOpenLoginPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("LoginPage", 1, 0);

		driver.get(URL_LOGIN);

		LoginPage page = new LoginPage(driver);
		page.verifyLoginPageTitle(expectedTitle);
	}
}
