package scripts.homepage_scenarios.functional_scenarios.header_scenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class ET_8881_WithoutEnteringAnythingClickSearchIconFromHomepageUserShouldStayInCurrentPage extends OpenClose {

	@Test
	public void testWithoutEnteringAnythingClickSearchIconFromHomepageUserShouldStayInCurrentPage()
			throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);

		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomepageTitle(expectedHomePageTitle);

		String urlBeforeClick = driver.getCurrentUrl();

		hp.clickSearchButtonDesktop();
		Thread.sleep(1000);

		String urlAfterClick = driver.getCurrentUrl();

		Assert.assertEquals(urlAfterClick, urlBeforeClick,
				"User got navigated to another page after clicking search without entering any text.");

		hp.verifyHomepageTitle(expectedHomePageTitle);
	}
}