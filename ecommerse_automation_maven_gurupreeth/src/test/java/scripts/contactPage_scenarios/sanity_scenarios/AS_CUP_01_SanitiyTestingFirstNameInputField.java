package scripts.contactPage_scenarios.sanity_scenarios;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ContactUsPage;

public class AS_CUP_01_SanitiyTestingFirstNameInputField extends OpenClose {
	@Test
	public void testEnterValidDetailsInContactFormAndSubmit() throws InterruptedException, IOException {
		// homepage.
		// navigate to contact us page.
		driver.navigate().to("http://localhost:5173/contact-us");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ContactUsPage cp = new ContactUsPage(driver);
		cp.verifyContactUsPageTitle("Contact Us | ECODERS");

		for (int row = 4; row <= 48; row++) {
			String valueToEnter = (String) Excel.getData("ContactUsPage", row, 0);
			cp.enterFirstName(valueToEnter);

			cp.enterLastName("Kumar");
			cp.enterEmail("raju@gmail.com");
			cp.enterPhoneNumber("798797987");
			cp.enterMessage("Hello can i do business in your ecommerce website");
			cp.clickAgreementCheckbox();
			cp.clickSubmitFormButton();
			Thread.sleep(100);
		}

	}
}
