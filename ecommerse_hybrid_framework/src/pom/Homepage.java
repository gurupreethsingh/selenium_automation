package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.All_Verications;

public class Homepage extends All_Verications 
{
	// declare, (find)
	@FindBy(css = "a[href='/home']")
	private WebElement logo;
//	div.flex.items-center.gap-6>a:first-child
//	div.flex.items-center.gap-6>a:last-child      this is for shop link.
	
	@FindBy(css = "div.flex.items-center.gap-6>a:last-child")
	private WebElement shopAllLink;
	
	
	// initilize  (PageFactory.initElements() 
	public Homepage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// utilize (functions for each action on found elements. )
    public void clickOnLogo()
    {
    	logo.click();
    }
    
    public void clickOnShopAllLink()
    {
    	shopAllLink.click();
    }
    
    
    public void verifyHomepageTitle(String expectedTitle, WebDriver driver, SoftAssert sa)
    {
    	 All_Verications.verifyTitleMatch(expectedTitle, driver, sa);
    }
}
