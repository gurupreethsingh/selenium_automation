package shopall_page_scenarios_saritha;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;

public class DeleteProductFromcart {

	public static void main(String[] args) {

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
            WebElement signinLink = driver.findElement(By.cssSelector("a[href='/login'] > span"));

            signinLink .click();
            WebElement emailField =  driver.findElement(By.cssSelector("form.space-y-6>div:first-child>input"));
            emailField.sendKeys("ecoders@gmail.com");

            WebElement passwordField =  driver.findElement(By.cssSelector("form.space-y-6>div.relative>input"));
            passwordField.sendKeys("abc123ABC!@#");

            WebElement loginButton =  driver.findElement(By.cssSelector("button.w-full.py-2.px-4"));

            loginButton.click();

            // click on shop all page.
            WebElement shopLink = driver.findElement(By.cssSelector("a[href='/shop']"));
            shopLink.click();
            WebElement cart= driver.findElement(By.xpath("//button[@class='relative p-2 rounded-full']"));
            cart.click();
            Thread.sleep(2000);
            System.out.println(driver.getTitle());

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
