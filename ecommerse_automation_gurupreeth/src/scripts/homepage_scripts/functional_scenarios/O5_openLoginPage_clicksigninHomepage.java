package scripts.homepage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class O5_openLoginPage_clicksigninHomepage extends OpenClose
{
SoftAssert sa = new SoftAssert();
	
	
	@Test(enabled = true, invocationCount = 1)
	public void clickOnSignInLink() throws InterruptedException
	{
		String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		 
		Homepage hp = new Homepage(driver);
		hp.clickOnSignInLink();
		
		String expectedLoginInPageTitle = (String)Excel.getData("LoginPage", 0, 0); 
		AllVerifications.verifyTitle(expectedLoginInPageTitle, driver, sa);
		sa.assertAll();
	}
}
