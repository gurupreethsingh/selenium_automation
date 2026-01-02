package scripts.homepage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;

public class O1_OpenHomepageUsingUrl extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openHomepageUsingUrl()
   {
		String expectedHomepageTitle = (String)Excel.getData("Homepage",0,0);
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		sa.assertAll();
   }
	
}
