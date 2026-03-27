package scripts.selenium_practice_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class O4_moveLeftPriceIndicatorToRightside {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost:5173/shop");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// find the left price indicator button.,
		WebElement leftPriceIndicatorButton = driver
				.findElement(By.cssSelector("div.px-2:last-child>span.relative>span:nth-of-type(2)>span.block"));
		Thread.sleep(2000);

		Actions actions = new Actions(driver);

		actions.moveToElement(leftPriceIndicatorButton).clickAndHold(leftPriceIndicatorButton).moveByOffset(50, 0)
				.release().build().perform();

		Thread.sleep(2000);

		WebElement rightPriceIndicatorButton = driver
				.findElement(By.cssSelector("div.px-2:last-child>span.relative>span:nth-of-type(3)>span.block"));
		Thread.sleep(2000);

		actions.moveToElement(rightPriceIndicatorButton).clickAndHold(rightPriceIndicatorButton).moveByOffset(-50, 0)
				.release().build().perform();

		Thread.sleep(2000);

		Thread.sleep(3000);
		driver.quit();
	}

}
