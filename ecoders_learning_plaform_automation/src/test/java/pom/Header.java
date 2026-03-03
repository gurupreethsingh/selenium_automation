package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Header extends AllVerifications {

	// ============================================================
	// ✅ HEADER - LEFT (Logo + App Name)
	// ============================================================

	@FindBy(css = "header>div.max-w-screen-3xl>div>a>img")
	private WebElement headerLogo;

	@FindBy(css = "header>div.max-w-screen-3xl>div>a>div")
	private WebElement headerApplicationName;

	// ============================================================
	// ✅ HEADER - NAV LINKS
	// ============================================================

	@FindBy(css = "div.flex.items-center.gap-5>a:nth-of-type(1)")
	private WebElement headerHomeLink;

	@FindBy(css = "div.flex.items-center.gap-5>a:nth-of-type(2)")
	private WebElement headerBlogsLink;

	@FindBy(css = "div.flex.items-center.gap-5>a:nth-of-type(3)")
	private WebElement headerContactLink;

	@FindBy(css = "div.flex.items-center.gap-5>a:nth-of-type(4)")
	private WebElement headerAboutUsLink;

	@FindBy(css = "div.flex.items-center.gap-5>a:nth-of-type(5)")
	private WebElement headerCareersLink;

	// ============================================================
	// ✅ HEADER - RIGHT (User avatar / Login)
	// ============================================================

	@FindBy(css = "div.flex.items-center.gap-2>button")
	private WebElement headerUserAvatarLink;

	@FindBy(css = "div.flex.items-center.gap-2>a")
	private WebElement headerLoginLink;

	// ============================================================
	// ✅ OPTIONAL: USER DROPDOWN (if present in DOM)
	// (Keeping generic selectors; adjust if your dropdown differs)
	// ============================================================

	@FindBy(css = "header button[aria-haspopup='menu']")
	private WebElement headerUserDropdownButton;

	@FindBy(css = "header div.absolute.right-0 button")
	private List<WebElement> headerUserDropdownButtons;

	// ============================================================
	// ✅ OPTIONAL: SEARCH (if present in your header)
	// (If your current header doesn't have search, these will just remain unused)
	// ============================================================

	@FindBy(css = "header nav form[role='search'] input[type='text']")
	private WebElement headerSearchInputDesktop;

	@FindBy(css = "header nav form[role='search'] button[type='submit']")
	private WebElement headerSearchButtonDesktop;

	public Header(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ ACTION METHODS (exactly in your style)
	// ============================================================

	// ---------- Logo / App name ----------

	public void clickOnLogo() {
		clickOnElement(headerLogo, "Header Logo Image");
	}

	public String getApplicationNameText() {
		return getTextFromElement(headerApplicationName, "Header Application Name Text");
	}

	public void clickOnApplicationName() {
		clickOnElement(headerApplicationName, "Header Application Name");
	}

	// ---------- Nav links ----------

	public void clickOnHomeLink() {
		clickOnElement(headerHomeLink, "Header Home Link");
	}

	public void clickOnBlogsLink() {
		clickOnElement(headerBlogsLink, "Header Blogs Link");
	}

	public void clickOnContactLink() {
		clickOnElement(headerContactLink, "Header Contact Link");
	}

	public void clickOnAboutUsLink() {
		clickOnElement(headerAboutUsLink, "Header About Us Link");
	}

	public void clickOnCareersLink() {
		clickOnElement(headerCareersLink, "Header Careers Link");
	}

	// ---------- User / Login ----------

	public void clickOnUserAvatarLoginIcon() {
		clickOnElement(headerUserAvatarLink, "Header User Avatar Login Icon");
	}

	public void clickOnLoginLink() {
		clickOnElement(headerLoginLink, "Header Login Link");
	}

	// ---------- User dropdown (optional) ----------

	public void openUserDropdown() {
		clickOnElement(headerUserDropdownButton, "Header User Dropdown Button");
	}

	private WebElement findButtonByExactText(List<WebElement> buttons, String exactText) {
		if (buttons == null || buttons.isEmpty())
			return null;

		String exp = exactText == null ? "" : exactText.trim();
		for (WebElement b : buttons) {
			String t = b.getText() == null ? "" : b.getText().trim();
			if (t.equals(exp))
				return b;
		}
		return null;
	}

	public void clickUserDropdownOption(String optionText) {
		openUserDropdown();
		WebElement btn = findButtonByExactText(headerUserDropdownButtons, optionText);
		if (btn == null) {
			System.out.println("[HEADER] Dropdown option not found: " + optionText);
			return;
		}
		clickOnElement(btn, "Header Dropdown Option: " + optionText);
	}

}