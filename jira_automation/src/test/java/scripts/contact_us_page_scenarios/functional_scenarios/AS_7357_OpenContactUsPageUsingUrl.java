package scripts.contact_us_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ContactUsPage;

public class AS_7357_OpenContactUsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenContactUsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ContactUsPage", 1, 0);

		driver.get(URL_CONTACT);

		ContactUsPage page = new ContactUsPage(driver);
		page.verifyContactUsPageTitle(expectedTitle);
	}
}
