package homepagescenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation_scripts.AutomationConstants;
import screenshots.TakeScreenshot;

public class O10_FetchAddressFromFooter implements AutomationConstants {
	public static void main(String[] args) throws Exception {
		WebDriver driver = null;
		try {
			// open browser.
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// open homepage
			driver.get(urlOfHomepage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// printing Address heading
			WebElement addText = driver.findElement(By.xpath("//div[@class='min-w-[200px]']/h2"));
			System.out.println(addText.getText());

			// ecoders address
			WebElement addressText = driver.findElement(By.xpath("(//p)[2]"));
			// System.out.println(addressText.getText());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			js.executeScript("arguments[0].scrollIntoView(true)", addressText);
			Thread.sleep(1000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			String expectedText = "ECODERS\r\n" + "#198, Defence Colony,\r\n" + "Hesaraghatta Road,\r\n"
					+ "Bangalore 560073.";

			System.out.println(expectedText);
			System.out.println("-----------------------------------");

			try {
				WebElement actualAddressText = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[@class='text-sm font-medium leading-relaxed']")));
				System.out.println(actualAddressText.getText());
				System.out.println("-----------------------------------");

				if (expectedText.equals(actualAddressText.getText())) {
					System.out.println("text is matched");
				} else {
					System.out.println("text is not matched");
				}

			} catch (Exception ex) {
				// Clean handling — no stack trace
				System.out.println("Test failed: Expected textdid not match. Screenshot captured.");
				TakeScreenshot.getScreenshot(driver);
				System.out.println("Testcase failed screenshot stored.");
			}
		} catch (Exception ex) {
			// Clean handling — no stack trace
			System.out.println("Test failed: Expected title did not match. Screenshot captured.");
			TakeScreenshot.getScreenshot(driver);
			System.out.println("Testcase failed screenshot stored.");
		} finally {
			driver.quit();
		}

	}
}
