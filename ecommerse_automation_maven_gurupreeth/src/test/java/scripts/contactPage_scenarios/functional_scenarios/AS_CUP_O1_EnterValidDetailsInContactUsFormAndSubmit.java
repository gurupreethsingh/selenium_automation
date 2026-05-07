package scripts.contactPage_scenarios.functional_scenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ContactUsPage;

public class AS_CUP_O1_EnterValidDetailsInContactUsFormAndSubmit extends OpenClose {
	@Test
	public void testEnterValidDetailsInContactFormAndSubmit() throws InterruptedException {
		// homepage.
		// navigate to contact us page.
		driver.navigate().to("http://localhost:5173/contact-us");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ContactUsPage cp = new ContactUsPage(driver);
		cp.verifyContactUsPageTitle("Contact Us | ECODERS");

		cp.enterFirstName("RAj");
		Thread.sleep(200);
		cp.enterLastName("Kumar");
		Thread.sleep(200);
		cp.enterEmail("raju@gmail.com");
		Thread.sleep(200);
		cp.enterPhoneNumber("798797987");
		Thread.sleep(200);
		cp.enterMessage("Hello can i do business in your ecommerce website");
		Thread.sleep(200);
		cp.clickAgreementCheckbox();

		Thread.sleep(2000);
		cp.clickSubmitFormButton();

		Thread.sleep(3000);

	}

}
