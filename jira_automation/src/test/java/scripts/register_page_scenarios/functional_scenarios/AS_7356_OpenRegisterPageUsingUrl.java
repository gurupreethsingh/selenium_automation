package scripts.register_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.RegisterPage;

public class AS_7356_OpenRegisterPageUsingUrl extends OpenClose {

	@Test
	public void testOpenRegisterPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("RegisterPage", 1, 0);

		driver.get(URL_REGISTER);

		RegisterPage page = new RegisterPage(driver);
		page.verifyRegisterPageTitle(expectedTitle);
	}
}
