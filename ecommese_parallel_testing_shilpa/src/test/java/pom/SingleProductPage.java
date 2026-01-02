package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class SingleProductPage extends AllVerifications
{
	public WebDriver driver =null; 
	SoftAssert sa = new SoftAssert();
	
	@FindBy(css = "h1.text-4xl")
	private WebElement eachProductName; 
	
	
	
	@FindBy(css = "div#brandProductsCarousel>div")
	private List<WebElement> eachProductParent; 
	

	public SingleProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void verifyexploreProductHeadingText(String expectedText)
	{
		AllVerifications.textIsPresentOrNotIgnoreCase(expectedText, driver, By.cssSelector("h1.text-4xl"), sa);
		Actions actions=new Actions(driver);
		actions.scrollToElement(eachProductName).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 String Heading= eachProductName.getText();
		 System.out.println("Heading of the product section is : "+Heading);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void findAllProductsAndClickOneByOne()
	{
		int totalchildrens = eachProductParent.size(); 
		for( int i = 1; i<= totalchildrens; i++)
		{
			WebElement eachProduct= driver.findElement(By.cssSelector("div#brandProductsCarousel>div:nth-of-type("+i+")"));
			 Actions actions = new Actions(driver);
			 actions.scrollToElement(eachProduct).build().perform();
			 String expectedProductNameHomePage=eachProduct.getText().trim();
			 System.out.println("Clicking on :"+expectedProductNameHomePage);
			 AllVerifications.clickIfVisibleAndEnabled(eachProduct, driver , sa);  //navigating to single-product page 
			 AllVerifications.verifyTitle("Single-Product | ECODERS", driver, sa);
	         SingleProductPage sp = new SingleProductPage(driver);
	         sp.verifyexploreProductHeadingText(expectedProductNameHomePage);
		    driver.navigate().back();
		    sa.assertAll();
		} 
	}
		
}
