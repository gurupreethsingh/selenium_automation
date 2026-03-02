package scripts.update_profile_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.UpdateProfilePage;

public class AS_7366_OpenUpdateProfilePageUsingUrl extends OpenClose {

	@Test
	public void testOpenUpdateProfilePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("UpdateProfilePage", 1, 0);

		driver.get(URL_UPDATE_PROFILE_BASE + "66d849960093c94b4cee0381");

		UpdateProfilePage page = new UpdateProfilePage(driver);
		page.verifyUpdateProfilePageTitle(expectedTitle);
	}
}
