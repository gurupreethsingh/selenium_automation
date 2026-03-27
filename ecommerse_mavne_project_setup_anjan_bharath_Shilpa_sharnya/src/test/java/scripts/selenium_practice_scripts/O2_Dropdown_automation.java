package scripts.selenium_practice_scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O2_Dropdown_automation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://127.0.0.1:5500/javascript_practice/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// find the main menu or drop down (parent) - select - drop down.

//		WebElement monthDropDown = driver.findElement(By.cssSelector("select.month_dropdown"));
//
//		Select select = new Select(monthDropDown);
//		Thread.sleep(2000);
//
//		// select.selectByValue("jul");
////		select.selectByIndex(6);
//		select.selectByVisibleText("Oct");
//
//		Thread.sleep(3000);
//
//		select.deselectByVisibleText("Oct");

		// first find the bootstrap dropdown.
		Thread.sleep(2000);
		WebElement bootstrapDropDown = driver.findElement(By.cssSelector("div.dropdown>button"));
		Thread.sleep(2000);
		bootstrapDropDown.click();
		Thread.sleep(3000);

		// find all options under the drop down..

		List<WebElement> allDropDownOptions = driver.findElements(By.cssSelector("ul.dropdown-menu>li>a"));
		System.out.println("Total options in the bootstrap drop down are : " + allDropDownOptions.size());

		for (int i = 0; i <= allDropDownOptions.size() - 1; i++) {
			String text = allDropDownOptions.get(i).getText();
			System.out.println(text);
			Thread.sleep(150);
		}

		WebElement secondDropDownOptions = driver.findElement(By.cssSelector("ul.dropdown-menu>li:nth-of-type(2)>a"));
		Thread.sleep(150);
		System.out.println("Second dropdown option about to click is  : " + secondDropDownOptions.getText());
		Thread.sleep(150);
		secondDropDownOptions.click();
		Thread.sleep(3000);
		// from all the options getting shown on the screen. you need to find the one
		// option on which you want to click .

		driver.quit();
	}

}
