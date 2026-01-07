package shop_all_page_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O1_VerifyOurProductHeadingShopAllPage {

	public static void main(String[] args)
	{
		WebDriver driver = null;
		SoftAssert sa = new SoftAssert();

		// find the our product text(heading)
		// verify heading matchs the expected heading.

		try
		{
			// open browser
		  driver	= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// shop all page.
		  String urlOfShopage = O3_ReadFromExcel.getData("Shoppage", 1, 2);
		  driver.get(urlOfShopage);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//verify shop all title and url.
		  All_Verifications.verifyUrleMatch(urlOfShopage, driver, sa);

		  String expectedHeading  = "Our Products";

		  WebElement ourProductHeading = driver.findElement(By.cssSelector(".flex.items-center.justify-between.mb-6>h1"));
		  System.out.println("Actual heading text : " + ourProductHeading.getText());

		  All_Verifications.verifyTextPresent(expectedHeading, driver, sa);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}
}