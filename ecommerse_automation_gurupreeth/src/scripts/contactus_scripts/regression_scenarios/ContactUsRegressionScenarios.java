package scripts.contactus_scripts.regression_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.BaseClass_Shilpa;
import generic.TakingScreenshot;

import pom.ContactUspage;

public class ContactUsRegressionScenarios extends BaseClass_Shilpa {
	
SoftAssert sa = new SoftAssert();

	
	@Test(enabled = true, priority = 1)
   public void openContactpageUsingUrl()
   {
		String expectedContactpageTitle = (String)Excel_Shilpa.getData("ContactUspage",1,0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);
		sa.assertAll();
   }
	
	@Test(enabled = true, priority = 2)
	public void fillAllFields_toastMessageDisplayed() throws InterruptedException {
		
		ContactUspage cp = new ContactUspage(driver);
//		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
//		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);

		String firstNameFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 2);
		cp.enterValueInFirstNameField(firstNameFromExcel);

		String LastNameFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 3);
		cp.enterValueInLastNameField(LastNameFromExcel);

		String emailFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 4);
		cp.enterValueInEmailField(emailFromExcel);

		String phoneNumFromExcel = cp.toPlainString(Excel_Shilpa.getData("ContactUspage", 1, 5)); // <- String now
		cp.enterValueInPhoneField(phoneNumFromExcel);

		String messageFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 6);
		cp.enterValueInMessageAreaField(messageFromExcel);

		cp.clickOnSubmitForm();

		TakingScreenshot.captureScreenshot(driver);

		sa.assertAll();

	}
	@Test(enabled = true, priority = 3)
	public void toastMessageDisplayedInEmailField() throws InterruptedException {
	
ContactUspage cp = new ContactUspage(driver);
		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);
		
		
		String firstNameFromExcel = (String) Excel_Shilpa.getData("ContactUspage", 1, 2);
		cp.enterValueInFirstNameField(firstNameFromExcel);
		
		cp.clickOnSubmitForm();
		Thread.sleep(1000);

		TakingScreenshot.captureScreenshot(driver);

		sa.assertAll();

	}
	
	@Test(enabled = true, priority = 4)
	public void toastMessageDisplayedInFirstNameField() throws InterruptedException {
		ContactUspage cp = new ContactUspage(driver);

		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);

		cp.clickOnSubmitForm();
		Thread.sleep(1000);

		TakingScreenshot.captureScreenshot(driver);

		sa.assertAll();

	}
	@Test(enabled = true, priority = 5,invocationCount = 1)
	public void reloadContactpageClickContactLink() throws InterruptedException {
		String expectedContactpageTitle = (String) Excel_Shilpa.getData("ContactUspage", 1, 0);
		AllVerifications.verifyTitle(expectedContactpageTitle, driver, sa);
		ContactUspage cp = new ContactUspage(driver);

		cp.clickOnFooterContactUsLink();
		
		String expectedContactpageUrl = (String) Excel_Shilpa.getData("ContactUspage", 1, 1);
		AllVerifications.verifyUrl(expectedContactpageUrl, driver, sa);
		Thread.sleep(1000);

		sa.assertAll();
	}

}
