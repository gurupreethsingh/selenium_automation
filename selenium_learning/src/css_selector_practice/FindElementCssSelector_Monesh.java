package css_selector_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementCssSelector_Monesh 
{
   public static void main(String[] args) throws InterruptedException 
   {
	   
	WebDriver driver=new ChromeDriver();
	String userdirectory=System.getProperty("user.dir");
	System.out.println(userdirectory);
	 driver.get("file:///C:/Users/lenovo/Desktop/css_selector.html");
	 driver.manage().window().maximize();
	 
	 WebElement usernameDiv = driver.findElement(By.cssSelector("#username"));
     System.out.println("Text in the username div, is " + usernameDiv.getText());
     // this will fetch you the text of h2 field, as well as the p tag ( as many elements are there that many elements)
     Thread.sleep(1000);
     driver.quit();
     
	 System.out.println(" 2. find the login button and click on it. (css selector using classname)"); 
     WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
     System.out.println(loginButton.getTagName());
     System.out.println(loginButton.getText());
     loginButton.click();
     Thread.sleep(1000);
	 
	
	 System.out.println("\n3. writing css selector, using the tag name and attributes, tagName[An='av'] syntax.\n");
     // find the email field , using the css selector. and type attribute. 
     WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
     emailInput.sendKeys("gurupreeth@ecoders.in");
     Thread.sleep(1000);
	 
	  System.out.println("\n4.css selector using,  TagName, Class, and Attribute Selector - Find input with class 'form-control-lg' and name 'password' ");
      WebElement passwordInput = driver.findElement(By.cssSelector("input.form-control-lg[name='password']"));
      passwordInput.sendKeys("password123");
      Thread.sleep(1000);
	 
	 System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
     WebElement firstListItem = driver.findElement(By.cssSelector("li:first-child"));
     System.out.println("First list item text: " + firstListItem.getText());
     Thread.sleep(1000);
     
     System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
     WebElement secondListItem = driver.findElement(By.cssSelector("li:nth-child(2)"));
     System.out.println("second list item text: " + secondListItem.getText());
     Thread.sleep(1000);
     
     System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
     WebElement thirdListItem = driver.findElement(By.cssSelector("li:nth-child(3)"));
     System.out.println("third list item text: " + thirdListItem.getText());
     Thread.sleep(1000);
     
     System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
     WebElement lastListItem = driver.findElement(By.cssSelector("li:last-child"));
     System.out.println("last list item text: " + lastListItem.getText());
     Thread.sleep(1000);
	 
//	 System.out.println("\n5. Tag and Pseudo-class Selector - Find first list item in the unordered list");
//   List<WebElement> secondListItem = driver.findElements(By.cssSelector("li:nth-child(odd)"));
//   System.out.println("second list item text: " + secondListItem.getText());
//   Thread.sleep(1000);
	 
	 // 6. Descendant Selector - Find span inside div with class 'container'
     WebElement containerSpan = driver.findElement(By.cssSelector("div.container span"));
     System.out.println("\nText inside span in container: \n" + containerSpan.getText());
     Thread.sleep(1000);
	 
	 // 7. Direct Child Selector - Find span directly under div with class 'header'
     WebElement headerBadge = driver.findElement(By.cssSelector("div.header > span"));
     System.out.println("\nDirect child span text: \n" + headerBadge.getText());
     Thread.sleep(1000);
	 
	   // 8. Attribute Starts With Selector - Find input with id starting with 'user'
     WebElement userNameField = driver.findElement(By.cssSelector("input[id^='user']"));
     userNameField.sendKeys("user123");
     Thread.sleep(1000);
     
	   // 9. Attribute Ends With Selector - Find button with class ending in 'button'
     WebElement saveButton = driver.findElement(By.cssSelector("button[class$='button']"));
     saveButton.click();
     Thread.sleep(1000);
	 
	   // 10. Attribute Contains Selector - Find button with title containing 'submit'
     WebElement submitButton = driver.findElement(By.cssSelector("button[title*='submit']"));
     submitButton.click();
     Thread.sleep(1000);
	 
     // 10. Attribute Contains Selector - Find button with title containing 'submit'
     WebElement submitButton2 = driver.findElement(By.cssSelector("button[title*='to']"));
     submitButton.click();
     Thread.sleep(1000);
     
     // 11. Multiple Classes Selector - Find button with both 'btn' and 'primary' classes
     WebElement primaryButton = driver.findElement(By.cssSelector("button.btn.primary"));
     primaryButton.click();
     Thread.sleep(1000);
     
     
	 
}
}
