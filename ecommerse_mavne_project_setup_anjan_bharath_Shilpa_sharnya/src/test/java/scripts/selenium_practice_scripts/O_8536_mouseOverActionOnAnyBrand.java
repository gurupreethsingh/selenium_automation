package scripts.selenium_practice_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class O_8536_mouseOverActionOnAnyBrand {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost:5173");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement sixthBrandItem = driver.findElement(
				By.cssSelector("div.brandViewport>div.brandTrack>div.flex:first-child>button:nth-of-type(6)"));
		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.moveToElement(sixthBrandItem).build().perform();

		Thread.sleep(2000);

		WebElement popularBrandHeading = driver.findElement(By.cssSelector("section.m-10 h2"));
		actions.moveToElement(popularBrandHeading).build().perform();

		Thread.sleep(2000);

		actions.moveToElement(sixthBrandItem).build().perform();
	}

}
