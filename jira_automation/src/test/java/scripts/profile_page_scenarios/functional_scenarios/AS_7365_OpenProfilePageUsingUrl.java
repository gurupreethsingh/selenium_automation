package scripts.profile_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ProfilePage;

public class AS_7365_OpenProfilePageUsingUrl extends OpenClose {

	@Test
	public void testOpenProfilePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ProfilePage", 1, 0);

		driver.get(URL_PROFILE_BASE + "66d849960093c94b4cee0381");

		ProfilePage page = new ProfilePage(driver);
		page.verifyProfilePageTitle(expectedTitle);
	}
}
