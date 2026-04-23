package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class LoginPage extends AllVerifications {

	@FindBy(css = "a[aria-label='Sign in']")
	private WebElement SignInLink;

	@FindBy(css = "input[name='email']")
	private WebElement emailTextField;

	@FindBy(css = "input[name='password']")
	private WebElement passwordTextField;
	
	@FindBy(css = "button.w-full.px-4.transition")
	private WebElement loginButton;
	

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyLoginPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyLoginPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

	public boolean clickOnemailTextField() {
		return clickOnElement(emailTextField, "emailTextField");
	}

	public boolean clickOnpasswordTextField() {
		return clickOnElement(passwordTextField, "passwordTextField");
	}

	public void login(String email, String password) {
		emailTextField.clear();
		emailTextField.sendKeys(email);

		passwordTextField.clear();
		passwordTextField.sendKeys(password);
	}
	
	public boolean clickOnloginButton() {
		return clickOnElement(loginButton, "login   Button");
	}
}
