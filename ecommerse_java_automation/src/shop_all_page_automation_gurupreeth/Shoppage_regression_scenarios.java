package shop_all_page_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class Shoppage_regression_scenarios
{
	WebDriver driver = null;
	SoftAssert sa = new SoftAssert();
	String urlOfShopage = O3_ReadFromExcel.getData("Shoppage", 1, 2);

	@BeforeMethod()
	public void openApplication()
	{
		  driver	= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// shop all page.
		  driver.get(urlOfShopage);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void test_O1_VerifyOurProductHeadingShopAllPage()
	{
		All_Verifications.verifyUrleMatch(urlOfShopage, driver, sa);

		  String expectedHeading  = "Our Products";

		  WebElement ourProductHeading = driver.findElement(By.cssSelector(".flex.items-center.justify-between.mb-6>h1"));
		  System.out.println("Actual heading text : " + ourProductHeading.getText());

		  All_Verifications.verifyTextPresent(expectedHeading, driver, sa);
	}

	@AfterMethod()
	public void closeApplication()
	{
        driver.quit();
	}

}
