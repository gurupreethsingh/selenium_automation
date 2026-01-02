package scripts.contactus_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.AllVerifications;
import generic.BaseClass_Shilpa;

public class AS_6652_OpenContactUsUsingUrl   extends BaseClass_Shilpa
{
	SoftAssert sa = new SoftAssert();
	
	@Test(enabled = true, priority = 1)
   public void openContactpageUsingUrl()
   {
		String expectedContactpageTitle = (String)Excel_Shilpa.getData("ContactUspage",1,0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);
		sa.assertAll();
   }
	

}