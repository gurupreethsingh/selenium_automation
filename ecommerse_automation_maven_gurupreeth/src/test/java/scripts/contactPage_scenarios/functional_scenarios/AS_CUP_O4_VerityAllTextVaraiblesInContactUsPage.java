package scripts.contactPage_scenarios.functional_scenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.OpenClose;
import pom.ContactUsPage;

public class AS_CUP_O4_VerityAllTextVaraiblesInContactUsPage extends OpenClose {
	@Test
	public void testVerifSubHEadingTextOFContactPageAsGetInTouch() throws InterruptedException {
		// homepage.
		// navigate to contact us page.
		driver.navigate().to("http://localhost:5173/contact-us");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ContactUsPage cp = new ContactUsPage(driver);
		cp.verifyContactUsPageTitle("Contact Us | ECODERS");

		String expectedContactUsMainHeading = "Contact Us";
		String expectedContactUsSubHeading = "Get In Touch";

		cp.verifyAllContactUsPageTextValues(expectedContactUsMainHeading, expectedContactUsSubHeading,
				"i agree to the Terms of Service and Privacy Policy", "Submit Form", "Email", "info@ecoders.com",
				"Phone", "+91 9538596766", "Address :", "#193, Hesaraghatta Road, Bagalagunte, Bangalore 560073",
				"Visit Our Store");

		Thread.sleep(3000);

	}

}
