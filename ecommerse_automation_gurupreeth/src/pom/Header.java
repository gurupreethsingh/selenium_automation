package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class Header extends AllVerifications
{
	SoftAssert sa = new SoftAssert();
	
	@FindBy(css = "")
	private WebElement logo; 
	
   
	Header(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	
	public void clickOnLogo()
	{
		AllVerifications.clickIfVisibleAndEnabled(logo, driver, sa);
	}
}
