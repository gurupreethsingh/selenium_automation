package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class LoginPage_anusha extends AllVerifications
{
	public WebDriver driver =null; 
	SoftAssert sa = new SoftAssert();
	
	// finding your weblements 
	
	
	@FindBy(css = "span.text-sm")
	private WebElement signInButton;
	
	
	@FindBy(css = "form.space-y-6>div:nth-child(1)>input")
	private WebElement emailField;
	//
	
	
	@FindBy(css = "form.space-y-6>div:nth-child(2)>input")
	private WebElement passwordField;
	
	@FindBy(css = "form.space-y-6>button")
	private WebElement loginButton;
	
	@FindBy(css = "a.text-sm.font-semibold")
	private WebElement forgotPassword;
	
	@FindBy(css = "a.linkText")
	private WebElement shopAllLink;
	
	@FindBy(css = "span.absolute")
	private WebElement eyeIcon;
	
	
	
	@FindBy(css = "div.overflow-y-auto>div:nth-of-type(1)>div.flex-grow>h3")
	private WebElement productNameInMiniCart;
	
	
	@FindBy(css = "div.mt-4.border-t>a")
	private WebElement viewCartButtonInMiniCart;
	
	
	// initializing all the elements in this page. using the constructor of this class. 
	public LoginPage_anusha(WebDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterValueInEmailField(String firstNamekeys) {

		AllVerifications.clickIfVisibleAndEnabled(emailField, driver, sa);
		emailField.clear();
		emailField.sendKeys(firstNamekeys);

	}
	
	
	public void enterValueInPasswordField(String passwordkeys) {

		AllVerifications.clickIfVisibleAndEnabled(passwordField, driver, sa);
		passwordField.clear();
		passwordField.sendKeys(passwordkeys);

	}
	
	public void clickOnEyeIconButton()
	{
		AllVerifications.clickIfVisibleAndEnabled(eyeIcon, driver, sa);
	}
	
	// utilization (create fucntions to perform operations on elements ) 
	public void clickOnloginButton()
	{
		AllVerifications.clickIfVisibleAndEnabled(loginButton, driver, sa);
	}
	
	
	
	public void clickOnViewCartButtonOFMiniCart()
	{
		AllVerifications.clickIfVisibleAndEnabled(viewCartButtonInMiniCart, driver, sa);
	}
	
	 
	
}
