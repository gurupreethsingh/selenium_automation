package scripts.homepage_scenarios.functional_scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.OpenClose;
import pom.HomePage;

public class AS_EPMT_HP_7513_ClickQAAutomationFromHeroSection extends OpenClose {

	@Test
	public void testClickQAAutomationLink() throws InterruptedException {

		driver.get(URL_HOME);

		HomePage homePage = new HomePage(driver);

		Assert.assertTrue(homePage.clickOnQaAutomationLink(), "Click on QA autoamtion link failed");

		Thread.sleep(2000);
		Assert.assertTrue(homePage.verifyHomePageUrl("qa-automation"), "User is NOT navigated to QA Automation page");
	}
}