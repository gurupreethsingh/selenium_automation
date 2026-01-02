package kavya_programing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class AutomationDropdowns {
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);

		driver.get("file:///C:/Users/user/Desktop/New%20folder/dropdown.html");
		Thread.sleep(1000);
		
		WebElement languagedropdown = driver.findElement(By.xpath("//select[@id='one']"));
		Thread.sleep(1000);
		// find the drop down and pass it inside the select contructor.
		Select s = new Select(languagedropdown);
		Thread.sleep(1000);
		languagedropdown.click();
		Thread.sleep(1000);
		// from those option go and select the java option 
		// 1. by using index (2) 
//		s.selectByIndex(2);
//		s.selectByVisibleText("python");
		s.selectByValue("c++");
		
		Thread.sleep(3000);
		driver.quit();
	}
}