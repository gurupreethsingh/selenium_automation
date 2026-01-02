package scripts.contactus_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.AllVerifications;
import generic.BaseClass_Shilpa;
import generic.TakingScreenshot;
import pom.ContactUspage;

public class AS_2907_EmptyFieldsToastMessageDisplayedInFirstNameField extends BaseClass_Shilpa {
	SoftAssert sa = new SoftAssert();

	@Test(enabled = true, priority = 1)
	public void toastMessageDisplayedInFirstNameField() throws InterruptedException {
		ContactUspage cp = new ContactUspage(driver);

		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);

		cp.clickOnSubmitForm();
		Thread.sleep(1000);

		TakingScreenshot.captureScreenshot(driver);

		sa.assertAll();

	}

}