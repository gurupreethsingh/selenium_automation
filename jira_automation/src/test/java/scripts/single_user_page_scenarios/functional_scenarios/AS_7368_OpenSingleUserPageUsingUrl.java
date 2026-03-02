package scripts.single_user_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleUserPage;

public class AS_7368_OpenSingleUserPageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleUserPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleUserPage", 1, 0);

		driver.get(URL_SINGLE_USER_BASE + "66d849960093c94b4cee0381");

		SingleUserPage page = new SingleUserPage(driver);
		page.verifySingleUserPageTitle(expectedTitle);
	}
}
