package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class ContactUspage extends AllVerifications {
	public WebDriver driver = null;
	SoftAssert sa = new SoftAssert();

	// finding your weblements
	@FindBy(css = "nav>div.flex:first-child>a:first-child")
	private WebElement logo;

	@FindBy(css = "div.animate__fadeInUp>a.inline-block")
	private WebElement shopAllLink;

	@FindBy(css = "div.hidden.items-center.gap-6>a:first-child")
	private WebElement wishListIcon;

	@FindBy(css = "a.flex:last-child>span")
	private WebElement signInLink;

	@FindBy(css = "input.flex-grow")
	private WebElement searchField;

	@FindBy(css = "button.px-4")
	private WebElement searchIcon;

	// LABELS

//	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:first-child>div:first-child>input")
//	private WebElement firstNameLabel;
//
//	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:first-child>div:nth-of-type(2)>label")
//	private WebElement lastNameLabel;
//
//	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:first-child>div:nth-of-type(2)>label")
//	private WebElement emailLabel;
//
//	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(3)>label")
//	private WebElement phoneLabel;
//
//	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(4)>label")
//	private WebElement yourMessageLabel;

	// FIELDS

	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:first-child>div:first-child>input")
	private WebElement firstNameField;

	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(1)>div:last-child>input")
	private WebElement lastNameField;

	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(2)>input")
	private WebElement emailField;

	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(3)>input")
	private WebElement phoneField;

	@FindBy(css = "form:nth-of-type(1):nth-child(3)>div:nth-of-type(4)>textarea")
	private WebElement yourMessageArea;
	
	
	@FindBy(css = "input.mt-1")
	private WebElement iAgreeTerms;

	@FindBy(css = "button.bg-red-500")
	private WebElement submitForm;

	// footer elements

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(1)>ul>li:nth-child(1)")
	private WebElement footerAboutUslink;

	@FindBy(css = "div.grid.grid-cols-1.mb-12>div:first-child>ul>li:nth-of-type(2)")
	private WebElement footerContactUslink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(1)>ul>li:nth-child(3)")
	private WebElement footerCareerslink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(2)>ul>li:nth-child(1)")
	private WebElement footerHelpCenterlink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(2)>ul>li:nth-child(2)")
	private WebElement footerPrivacyPolicylink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(2)>ul>li:nth-child(3)")
	private WebElement footerTermsServicelink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(3)>div>a:nth-of-type(1)")
	private WebElement footerFacebooklink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(3)>div>a:nth-of-type(2)")
	private WebElement footerTwitterlink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(3)>div>a:nth-of-type(3)")
	private WebElement footerGitlink;

	@FindBy(css = "footer>div>div:first-child>div:nth-of-type(3)>div>a:nth-of-type(4)")
	private WebElement footerLinkedINlink;

	@FindBy(css = "form.space-y-3>input")
	private WebElement footerSubscribeField;

	@FindBy(css = "form.space-y-3>button")
	private WebElement footerSubscribeBtn;
	//

	// initializing all the elements in this page. using the constructor of this
	// class.
	public ContactUspage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	// utilization (create fucntions to perform operations on elements )
	public void clickOnLogo() {
		AllVerifications.clickIfVisibleAndEnabled(logo, driver, sa);
	}

	public void enterValueInFirstNameField(String firstNamekeys) throws InterruptedException {

		AllVerifications.clickIfVisibleAndEnabled(firstNameField, driver, sa);
		Thread.sleep(1000);
		firstNameField.clear();
		Thread.sleep(1000);
		firstNameField.sendKeys(firstNamekeys);

	}

	public void enterValueInLastNameField(String lastNamekeys) throws InterruptedException {

		AllVerifications.clickIfVisibleAndEnabled(lastNameField, driver, sa);
		lastNameField.clear();
		lastNameField.sendKeys(lastNamekeys);
		Thread.sleep(1000);

	}

	public void enterValueInEmailField(String emailkeys) throws InterruptedException {

		AllVerifications.clickIfVisibleAndEnabled(emailField, driver, sa);
		emailField.clear();
		Thread.sleep(1000);
		emailField.sendKeys(emailkeys);
		Thread.sleep(1000);
	}

	public void enterValueInPhoneField(String phoneNumFromExcel) throws InterruptedException {

		AllVerifications.clickIfVisibleAndEnabled(phoneField, driver, sa);
		phoneField.clear();
		Thread.sleep(1000);
		phoneField.sendKeys(phoneNumFromExcel);
		Thread.sleep(1000);
	}

	public static String toPlainString(Object v) {
		if (v == null)
			return "";
		if (v instanceof String)
			return ((String) v).trim();
		if (v instanceof Double) {
			java.math.BigDecimal bd = java.math.BigDecimal.valueOf((Double) v);
			return bd.stripTrailingZeros().toPlainString();
		}
		return v.toString().trim();
	}

	// (Optional) If you want to keep a convenience overload:
	public void enterValueInPhoneField(Object phone) throws InterruptedException {
		enterValueInPhoneField(toPlainString(phone));
	}

	public void enterValueInMessageAreaField(String messagekeys) throws InterruptedException {

		AllVerifications.clickIfVisibleAndEnabled(yourMessageArea, driver, sa);
		yourMessageArea.clear();
		Thread.sleep(1000);
		yourMessageArea.sendKeys(messagekeys);
		Thread.sleep(1000);
	}

	public void clickOnSubmitForm() throws InterruptedException {
		AllVerifications.clickIfVisibleAndEnabled(submitForm, driver, sa);

		Thread.sleep(1000);

	}
	
	public void clickOnIagreeTerms() throws InterruptedException {
		AllVerifications.clickIfVisibleAndEnabled(iAgreeTerms, driver, sa);

		Thread.sleep(1000);

	}

	public void clickOnFooterContactUsLink() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Ensure visible & centered, then lift a bit
		js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
		Thread.sleep(500);

		AllVerifications.clickIfVisibleAndEnabled(footerContactUslink, driver, sa);
	}

	public void enterValueInSearchField(String keys) {
		AllVerifications.clickIfVisibleAndEnabled(searchField, driver, sa);
		searchField.clear();
		searchField.sendKeys(keys);
	}

	public void clickOnSearchButton() {
		AllVerifications.clickIfVisibleAndEnabled(searchIcon, driver, sa);
	}

	public void clickOnwishListIcon() throws InterruptedException {
		Thread.sleep(1000);
		AllVerifications.clickIfVisibleAndEnabled(wishListIcon, driver, sa);
		Thread.sleep(1000);
	}

}
