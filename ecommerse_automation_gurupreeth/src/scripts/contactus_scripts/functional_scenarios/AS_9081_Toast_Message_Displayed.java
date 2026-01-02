package scripts.contactus_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.AllVerifications;
import generic.BaseClass_Shilpa;
import generic.TakingScreenshot;
import pom.ContactUspage;

public class AS_9081_Toast_Message_Displayed extends BaseClass_Shilpa {
	SoftAssert sa = new SoftAssert();

	@Test(enabled = true, priority = 1)
	public void enterAllFieldstoastMessageDisplayed() throws InterruptedException {
		ContactUspage cp = new ContactUspage(driver);

		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);

		String firstNameFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 2);
		cp.enterValueInFirstNameField(firstNameFromExcel);

		String LastNameFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 3);
		cp.enterValueInLastNameField(LastNameFromExcel);

		String emailFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 4);
		cp.enterValueInEmailField(emailFromExcel);

		String phoneNumFromExcel       = (String) Excel_Shilpa.getData("ContactUspage", 1, 5); // <- String now
		cp.enterValueInPhoneField(phoneNumFromExcel);

		String messageFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 6);
		cp.enterValueInMessageAreaField(messageFromExcel);
		
		cp.clickOnIagreeTerms();
		cp.clickOnSubmitForm();

		TakingScreenshot.captureScreenshot(driver);

		sa.assertAll();

	}

}