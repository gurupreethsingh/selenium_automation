package scripts.contactPage_scenarios.sanity_scenarios;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ContactUsPage;

public class AS_CUP_02_SanitiyTestingLastNameInputField extends OpenClose {
	@Test
	public void testEnterValidDetailsInContactFormAndSubmit() throws InterruptedException, IOException {
		// homepage.
		// navigate to contact us page.
		driver.navigate().to("http://localhost:5173/contact-us");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ContactUsPage cp = new ContactUsPage(driver);
		cp.verifyContactUsPageTitle("Contact Us | ECODERS");

		for (int row = 5; row <= 13; row++) {
			String valueToEnter = (String) Excel.getData("ContactUsPage", row, 1);

			cp.enterFirstName("RAj");
			Thread.sleep(200);
			cp.enterLastName(valueToEnter); // narrow.
			Thread.sleep(200);
			cp.enterEmail("raju@gmail.com");
			Thread.sleep(200);
			cp.enterPhoneNumber("798797987");
			Thread.sleep(200);
			cp.enterMessage("Hello can i do business in your ecommerce website");
			Thread.sleep(200);
			cp.clickAgreementCheckbox();

			Thread.sleep(200);
			cp.clickSubmitFormButton();

			Thread.sleep(300);
		}

	}

}
