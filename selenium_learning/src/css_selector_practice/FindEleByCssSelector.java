package css_selector_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindEleByCssSelector {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		 // Navigate to the test HTML page
        driver.get("http://127.0.0.1:5500/cssselector.html");
        
        // finding the username text field which is in a div, who's id is "username" using css selector. 
        // first find the div whos id is username. 
        WebElement usernameDiv = driver.findElement(By.cssSelector("#username"));
        System.out.println("Text in the username div, is " + usernameDiv.getText());
        // this will fetch you the text of h2 field, as well as the p tag ( as many elements are there that many elements)
        Thread.sleep(1000);
        
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

        // 11. Multiple Classes Selector - Find button with both 'btn' and 'primary' classes
        WebElement primaryButton = driver.findElement(By.cssSelector("button.btn.primary"));
        primaryButton.click();
        Thread.sleep(1000);

        driver.quit();   
	}
}