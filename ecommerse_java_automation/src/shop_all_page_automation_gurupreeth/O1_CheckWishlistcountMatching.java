package shop_all_page_automation_gurupreeth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O1_CheckWishlistcountMatching {

	public static void main(String[] args)
	{
		WebDriver driver = null;
		SoftAssert sa = new SoftAssert();

		try
		{
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // === Read Data from Excel ===
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);

            // === Open Homepage ===
            driver.get(websiteUrl);
            System.out.println("Navigated to: " + websiteUrl);

            // === Verify Homepage Title ===
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);


            // === Locate signin Link ===
          //  WebElement signinLink = driver.findElement(By.xpath("//a[@href='/login']/span"));
            WebElement signinLink = driver.findElement(By.cssSelector("a[href='/login'] > span"));

            System.out.println("Actaul text in sign in link " + signinLink.getText());
            // === Click on ECOMMERSE Link if ready ===
            All_Verifications.clickIfVisibleAndEnabled(signinLink, driver, sa, "signinLink");

            // === Post-click: Verify URL or Title again ===
            String expectedLoginTitle = O3_ReadFromExcel.getData("Loginpage", 1, 1);
            String expectedLoginUrl   = O3_ReadFromExcel.getData("Loginpage", 1, 2);
            All_Verifications.verifyTitleMatch(expectedLoginTitle, driver, sa);
            All_Verifications.verifyUrleMatch(expectedLoginUrl, driver, sa);


            // login process.

            WebElement emailField =  driver.findElement(By.cssSelector("form.space-y-6>div:first-child>input"));
            emailField.sendKeys("ecoders@gmail.com");

            WebElement passwordField =  driver.findElement(By.cssSelector("form.space-y-6>div.relative>input"));
            passwordField.sendKeys("abc123");

            WebElement loginButton =  driver.findElement(By.cssSelector("button.w-full.py-2.px-4"));
            All_Verifications.clickIfVisibleAndEnabled(loginButton, driver, sa, "Login Button");

            String dashboardpageTitle = O3_ReadFromExcel.getData("Dashboardpage", 1, 1);
            String dashboardpageUrl = O3_ReadFromExcel.getData("Dashboardpage", 1, 2);

            All_Verifications.verifyTitleMatch(dashboardpageTitle , driver, sa);
            All_Verifications.verifyUrleMatch(dashboardpageUrl, driver, sa);

            // click on shop all page.
            WebElement shopLink = driver.findElement(By.cssSelector("a[href='/shop']"));

            // === Click on ECOMMERSE Link if ready ===
            All_Verifications.clickIfVisibleAndEnabled(shopLink, driver, sa, "SHOP ALL");


            String shoppageTitle = O3_ReadFromExcel.getData("Shoppage", 1, 1);
            String shoppageUrl = O3_ReadFromExcel.getData("Shoppage", 1, 2);

            All_Verifications.verifyTitleMatch(shoppageTitle , driver, sa);
            All_Verifications.verifyUrleMatch(shoppageUrl, driver, sa);

            // find the wishlist icon on any product.
            WebElement wishlistIcon = driver.findElement(By.cssSelector("div.relative.bg-white:first-child>button"));
            Thread.sleep(2000);
            All_Verifications.clickIfVisibleAndEnabled(wishlistIcon, driver, sa, "Whish list");


  		  String expectedWishlistCount  = "1";

  		  WebElement wishlistIconBadge = driver.findElement(By.cssSelector("a[href='/wishlist'] .animate-bounce-slow"));
  		  System.out.println("Actual heading text : " + wishlistIconBadge.getText());

  		  All_Verifications.verifyTextPresent(expectedWishlistCount, driver, sa);

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