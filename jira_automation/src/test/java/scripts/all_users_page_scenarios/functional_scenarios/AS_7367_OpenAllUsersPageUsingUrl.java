package scripts.all_users_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AllUsersPage;

public class AS_7367_OpenAllUsersPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAllUsersPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AllUsersPage", 1, 0);

		driver.get(URL_ALL_USERS);

		AllUsersPage page = new AllUsersPage(driver);
		page.verifyAllUsersPageTitle(expectedTitle);
	}
}
