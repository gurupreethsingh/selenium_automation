package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class UpdateProfilePage extends AllVerifications {

	// ============================================================
	// ✅ PAGE ROOT / WRAPPER
	// ============================================================

	@FindBy(css = "div.up-scope")
	private WebElement updateProfilePageRoot;

	@FindBy(css = "div.up-scope div.shell.w-full.px-3.sm\\:px-5.lg\\:px-10.py-6")
	private WebElement updateProfileShellWrapper;

	// ============================================================
	// ✅ MOBILE SECTION ROOT
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden")
	private WebElement mobileSectionRoot;

	@FindBy(css = "div.up-scope div.sm\\:hidden form#updateProfileForm")
	private WebElement mobileUpdateProfileForm;

	// ============================================================
	// ✅ MOBILE HERO CARD
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.relative.w-full.overflow-hidden.rounded-3xl.bg-slate-100.upCard")
	private WebElement mobileHeroCard;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.relative.w-full.overflow-hidden.rounded-3xl.bg-slate-100.upCard img")
	private WebElement mobileProfileImage;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.absolute.bottom-2\\.5.left-3.right-3.flex.items-end.justify-between.gap-3")
	private WebElement mobileHeroBottomContent;

	@FindBy(css = "div.up-scope div.sm\\:hidden p.text-white.text-\\[11px\\].font-bold.opacity-90")
	private WebElement mobileHeroUpdateProfileLabel;

	@FindBy(css = "div.up-scope div.sm\\:hidden h2.text-white.text-\\[16px\\].font-extrabold.truncate.leading-tight")
	private WebElement mobileHeroNameText;

	@FindBy(css = "div.up-scope div.sm\\:hidden p.text-white\\/90.text-\\[11px\\].font-semibold.truncate")
	private WebElement mobileHeroEmailText;

	@FindBy(css = "div.up-scope div.sm\\:hidden button[type='submit'][form='updateProfileForm'][aria-label='Save profile']")
	private WebElement mobileHeroSaveButton;

	// ============================================================
	// ✅ MOBILE FORM CARD
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden form#updateProfileForm div.upCard.overflow-hidden")
	private WebElement mobileFormMainCard;

	// ============================================================
	// ✅ MOBILE SECTION TITLES
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.mTitle")
	private List<WebElement> mobileSectionTitles;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.mTitle p.mLabel.text-slate-900")
	private List<WebElement> mobileSectionTitleTexts;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.mTitle p.mSub")
	private List<WebElement> mobileSectionSubtitleTexts;

	// ============================================================
	// ✅ MOBILE ACCOUNT DETAILS - FULL NAME
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.mField.flex.items-start.gap-3")
	private List<WebElement> mobileFullWidthFields;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='name']")
	private WebElement mobileFullNameInput;

	// ============================================================
	// ✅ MOBILE ACCOUNT DETAILS - EMAIL + PHONE
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.grid.grid-cols-2.gap-2.px-3.py-2\\.5")
	private List<WebElement> mobileTwoColumnFieldRows;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='email']")
	private WebElement mobileEmailInput;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='phone']")
	private WebElement mobilePhoneInput;

	// ============================================================
	// ✅ MOBILE ADDRESS FIELDS
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='address.street']")
	private WebElement mobileStreetInput;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='address.city']")
	private WebElement mobileCityInput;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='address.state']")
	private WebElement mobileStateInput;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='address.postalCode']")
	private WebElement mobilePostalCodeInput;

	@FindBy(css = "div.up-scope div.sm\\:hidden input[name='address.country']")
	private WebElement mobileCountryInput;

	// ============================================================
	// ✅ MOBILE PROFILE IMAGE UPLOAD
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.px-4.py-3.border-t")
	private WebElement mobileProfileImageUploadSection;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.px-4.py-3.border-t p.mLabel.text-slate-900")
	private WebElement mobileProfileImageUploadTitle;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.px-4.py-3.border-t p.mSub")
	private WebElement mobileProfileImageUploadSubtitle;

	@FindBy(css = "div.up-scope div.sm\\:hidden label[for='profileImageMobile']")
	private WebElement mobileChooseFileLabel;

	@FindBy(css = "div.up-scope div.sm\\:hidden input#profileImageMobile[type='file']")
	private WebElement mobileProfileImageFileInput;

	private final By mobileSelectedFileTextBy = By.cssSelector(
			"div.up-scope div.sm\\:hidden div.px-4.py-3.border-t p.text-\\[11px\\].font-semibold.text-slate-600.break-words");

	// ============================================================
	// ✅ MOBILE STICKY ACTIONS
	// ============================================================

	@FindBy(css = "div.up-scope div.sm\\:hidden div.fixed.left-0.right-0.bottom-0.z-40")
	private WebElement mobileStickyActionBar;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.fixed.left-0.right-0.bottom-0.z-40 button[type='button']")
	private WebElement mobileGoBackButton;

	@FindBy(css = "div.up-scope div.sm\\:hidden div.fixed.left-0.right-0.bottom-0.z-40 button[type='submit']")
	private WebElement mobileBottomSaveButton;

	// ============================================================
	// ✅ DESKTOP/TABLET SECTION ROOT
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block")
	private WebElement desktopSectionRoot;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block form")
	private WebElement desktopUpdateProfileForm;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block form.upCard.overflow-hidden")
	private WebElement desktopMainFormCard;

	// ============================================================
	// ✅ DESKTOP HEADER
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.lg\\:px-8.py-6.border-b")
	private WebElement desktopHeaderSection;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block button[type='button'].inline-flex.items-center.gap-2.text-\\[12px\\].font-extrabold.text-slate-600.hover\\:text-slate-900.transition")
	private WebElement desktopBackButton;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block h1.mt-3.text-\\[26px\\].font-extrabold.text-slate-900")
	private WebElement desktopPageHeading;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block p.mt-1.text-\\[13px\\].font-semibold.upMuted")
	private WebElement desktopPageSubtitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block button.btnGhost")
	private List<WebElement> desktopGhostButtons;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block button.btnOrange.inline-flex.items-center.gap-2")
	private List<WebElement> desktopSaveButtons;

	// ============================================================
	// ✅ DESKTOP BODY GRID
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.lg\\:px-8.py-7")
	private WebElement desktopBodySection;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.grid.grid-cols-12.gap-7")
	private WebElement desktopBodyGrid;

	// ============================================================
	// ✅ DESKTOP LEFT COLUMN - PROFILE CARD
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4")
	private WebElement desktopLeftColumn;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.upSoftBorder.rounded-3xl.overflow-hidden.bg-white")
	private WebElement desktopProfileCard;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.relative img")
	private WebElement desktopProfileImage;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.absolute.bottom-3.left-4.right-4 p.text-white.text-\\[12px\\].font-extrabold.truncate")
	private WebElement desktopProfileNameText;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.absolute.bottom-3.left-4.right-4 p.text-white\\/90.text-\\[12px\\].font-semibold.truncate")
	private WebElement desktopProfileEmailText;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.p-5")
	private WebElement desktopProfileImageUploadSection;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.p-5 p.text-\\[12px\\].font-extrabold.text-slate-900")
	private WebElement desktopProfileImageTitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.p-5 p.text-\\[12px\\].font-semibold.upMuted.mt-1")
	private WebElement desktopProfileImageSubtitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block label[for='profileImageDesktop']")
	private WebElement desktopChooseFileLabel;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input#profileImageDesktop[type='file']")
	private WebElement desktopProfileImageFileInput;

	private final By desktopSelectedFileTextBy = By.cssSelector(
			"div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-4 div.p-5 p.mt-2.text-\\[12px\\].font-semibold.text-slate-600.break-words");

	// ============================================================
	// ✅ DESKTOP RIGHT COLUMN - FORM CARD
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-8")
	private WebElement desktopRightColumn;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.col-span-12.lg\\:col-span-8 div.upSoftBorder.rounded-3xl.overflow-hidden")
	private WebElement desktopFormCard;

	// ============================================================
	// ✅ DESKTOP ACCOUNT DETAILS SECTION
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-b")
	private WebElement desktopAccountDetailsHeader;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-b p.text-\\[12px\\].font-extrabold.text-slate-900.uppercase.tracking-wide")
	private WebElement desktopAccountDetailsTitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-b p.text-\\[13px\\].font-semibold.upMuted.mt-1")
	private WebElement desktopAccountDetailsSubtitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='name']")
	private WebElement desktopFullNameInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='email']")
	private WebElement desktopEmailInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='phone']")
	private WebElement desktopPhoneInput;

	// ============================================================
	// ✅ DESKTOP ADDRESS SECTION
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-y")
	private WebElement desktopAddressHeader;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-y p.text-\\[12px\\].font-extrabold.text-slate-900.uppercase.tracking-wide")
	private WebElement desktopAddressTitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-4.bg-gradient-to-r.from-orange-50.to-amber-50.border-y p.text-\\[13px\\].font-semibold.upMuted.mt-1")
	private WebElement desktopAddressSubtitle;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='address.street']")
	private WebElement desktopStreetInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='address.city']")
	private WebElement desktopCityInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='address.state']")
	private WebElement desktopStateInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='address.postalCode']")
	private WebElement desktopPostalCodeInput;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input[name='address.country']")
	private WebElement desktopCountryInput;

	// ============================================================
	// ✅ DESKTOP FIELD ROWS
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.fieldWrap")
	private List<WebElement> desktopFieldRows;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.fieldLabel")
	private List<WebElement> desktopFieldLabels;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block input.fieldInput")
	private List<WebElement> desktopFieldInputs;

	// ============================================================
	// ✅ DESKTOP BOTTOM ACTION BAR
	// ============================================================

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-5.border-t.flex.items-center.justify-end.gap-3")
	private WebElement desktopBottomActionBar;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-5.border-t.flex.items-center.justify-end.gap-3 button.btnGhost")
	private WebElement desktopBottomCancelButton;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.px-6.py-5.border-t.flex.items-center.justify-end.gap-3 button.btnOrange.inline-flex.items-center.gap-2")
	private WebElement desktopBottomSaveChangesButton;

	@FindBy(css = "div.up-scope div.hidden.sm\\:block div.mt-4.text-\\[12px\\].font-semibold.upMuted")
	private WebElement desktopTipText;

	// ============================================================
	// ✅ INTERNAL SIMPLE HELPERS (NO WAITS)
	// ============================================================

	private WebElement findButtonByExactText(List<WebElement> buttons, String exactText) {
		String exp = exactText == null ? "" : exactText.trim();
		for (WebElement b : buttons) {
			String t = (b.getText() == null) ? "" : b.getText().trim();
			if (t.equals(exp))
				return b;
		}
		return null;
	}

	private WebElement getInputFieldByName(String fieldName) {
		List<WebElement> els = driver.findElements(By.cssSelector("input[name='" + fieldName + "']"));
		if (els.isEmpty())
			return null;
		return els.get(0);
	}

	// ============================================================
	// ✅ INIT
	// ============================================================

	public UpdateProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// ============================================================
	// ✅ PAGE ROOT ACTIONS
	// ============================================================

	public boolean isUpdateProfilePageRootDisplayed() {
		return isElementDisplayed(updateProfilePageRoot, "Update Profile Page Root");
	}

	public boolean isUpdateProfileShellWrapperDisplayed() {
		return isElementDisplayed(updateProfileShellWrapper, "Update Profile Shell Wrapper");
	}

	// ============================================================
	// ✅ MOBILE SECTION ACTIONS
	// ============================================================

	public boolean isMobileSectionVisible() {
		return isElementPresentInDOM(By.cssSelector("div.up-scope div.sm\\:hidden"));
	}

	public boolean isMobileFormVisible() {
		return isElementPresentInDOM(By.cssSelector("div.up-scope div.sm\\:hidden form#updateProfileForm"));
	}

	public boolean isMobileHeroCardVisible() {
		return isElementPresentInDOM(By.cssSelector(
				"div.up-scope div.sm\\:hidden div.relative.w-full.overflow-hidden.rounded-3xl.bg-slate-100.upCard"));
	}

	public String getMobileHeroUpdateProfileLabelText() {
		return getTextFromElement(mobileHeroUpdateProfileLabel, "Mobile Hero Update Profile Label");
	}

	public String getMobileHeroNameText() {
		return getTextFromElement(mobileHeroNameText, "Mobile Hero Name Text");
	}

	public String getMobileHeroEmailText() {
		return getTextFromElement(mobileHeroEmailText, "Mobile Hero Email Text");
	}

	public void clickMobileHeroSaveButton() {
		clickOnElement(mobileHeroSaveButton, "Mobile Hero Save Button");
	}

	public boolean isMobileProfileImageDisplayed() {
		return isElementDisplayed(mobileProfileImage, "Mobile Profile Image");
	}

	// ============================================================
	// ✅ MOBILE SECTION TITLE ACTIONS
	// ============================================================

	public int getMobileSectionTitleCount() {
		return mobileSectionTitles == null ? 0 : mobileSectionTitles.size();
	}

	public List<String> getMobileSectionTitleTexts() {
		List<String> texts = new ArrayList<>();
		if (mobileSectionTitleTexts != null) {
			for (WebElement el : mobileSectionTitleTexts) {
				String t = el.getText();
				if (t != null && !t.trim().isEmpty())
					texts.add(t.trim());
			}
		}
		return texts;
	}

	public List<String> getMobileSectionSubtitleTexts() {
		List<String> texts = new ArrayList<>();
		if (mobileSectionSubtitleTexts != null) {
			for (WebElement el : mobileSectionSubtitleTexts) {
				String t = el.getText();
				if (t != null && !t.trim().isEmpty())
					texts.add(t.trim());
			}
		}
		return texts;
	}

	// ============================================================
	// ✅ MOBILE FIELD ACTIONS
	// ============================================================

	public void enterMobileFullName(String value) {
		typeInInputField(mobileFullNameInput, value, "Mobile Full Name");
	}

	public void enterMobileEmail(String value) {
		typeInInputField(mobileEmailInput, value, "Mobile Email");
	}

	public void enterMobilePhone(String value) {
		typeInInputField(mobilePhoneInput, value, "Mobile Phone");
	}

	public void enterMobileStreet(String value) {
		typeInInputField(mobileStreetInput, value, "Mobile Street");
	}

	public void enterMobileCity(String value) {
		typeInInputField(mobileCityInput, value, "Mobile City");
	}

	public void enterMobileState(String value) {
		typeInInputField(mobileStateInput, value, "Mobile State");
	}

	public void enterMobilePostalCode(String value) {
		typeInInputField(mobilePostalCodeInput, value, "Mobile Postal Code");
	}

	public void enterMobileCountry(String value) {
		typeInInputField(mobileCountryInput, value, "Mobile Country");
	}

	public String getMobileFullNameValue() {
		return getAttributeValueFromElement(mobileFullNameInput, "value", "Mobile Full Name");
	}

	public String getMobileEmailValue() {
		return getAttributeValueFromElement(mobileEmailInput, "value", "Mobile Email");
	}

	public String getMobilePhoneValue() {
		return getAttributeValueFromElement(mobilePhoneInput, "value", "Mobile Phone");
	}

	public String getMobileStreetValue() {
		return getAttributeValueFromElement(mobileStreetInput, "value", "Mobile Street");
	}

	public String getMobileCityValue() {
		return getAttributeValueFromElement(mobileCityInput, "value", "Mobile City");
	}

	public String getMobileStateValue() {
		return getAttributeValueFromElement(mobileStateInput, "value", "Mobile State");
	}

	public String getMobilePostalCodeValue() {
		return getAttributeValueFromElement(mobilePostalCodeInput, "value", "Mobile Postal Code");
	}

	public String getMobileCountryValue() {
		return getAttributeValueFromElement(mobileCountryInput, "value", "Mobile Country");
	}

	// ============================================================
	// ✅ MOBILE FILE UPLOAD ACTIONS
	// ============================================================

	public boolean isMobileProfileImageUploadSectionVisible() {
		return isElementDisplayed(mobileProfileImageUploadSection, "Mobile Profile Image Upload Section");
	}

	public String getMobileProfileImageUploadTitleText() {
		return getTextFromElement(mobileProfileImageUploadTitle, "Mobile Profile Image Upload Title");
	}

	public String getMobileProfileImageUploadSubtitleText() {
		return getTextFromElement(mobileProfileImageUploadSubtitle, "Mobile Profile Image Upload Subtitle");
	}

	public void uploadProfileImageInMobile(String absoluteFilePath) {
		typeInInputField(mobileProfileImageFileInput, absoluteFilePath, "Mobile Profile Image File Input");
	}

	public String getMobileSelectedFileText() {
		if (!isElementPresentInDOM(mobileSelectedFileTextBy))
			return "";
		List<WebElement> els = driver.findElements(mobileSelectedFileTextBy);
		if (els.isEmpty())
			return "";
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	// ============================================================
	// ✅ MOBILE STICKY ACTIONS
	// ============================================================

	public boolean isMobileStickyActionBarVisible() {
		return isElementPresentInDOM(
				By.cssSelector("div.up-scope div.sm\\:hidden div.fixed.left-0.right-0.bottom-0.z-40"));
	}

	public void clickMobileGoBackButton() {
		clickOnElement(mobileGoBackButton, "Mobile Go Back Button");
	}

	public void clickMobileBottomSaveButton() {
		clickOnElement(mobileBottomSaveButton, "Mobile Bottom Save Button");
	}

	// ============================================================
	// ✅ DESKTOP/TABLET SECTION ACTIONS
	// ============================================================

	public boolean isDesktopSectionVisible() {
		return isElementPresentInDOM(By.cssSelector("div.up-scope div.hidden.sm\\:block"));
	}

	public boolean isDesktopMainFormCardVisible() {
		return isElementPresentInDOM(By.cssSelector("div.up-scope div.hidden.sm\\:block form.upCard.overflow-hidden"));
	}

	// ============================================================
	// ✅ DESKTOP HEADER ACTIONS
	// ============================================================

	public boolean isDesktopHeaderSectionVisible() {
		return isElementDisplayed(desktopHeaderSection, "Desktop Header Section");
	}

	public void clickDesktopBackButton() {
		clickOnElement(desktopBackButton, "Desktop Back Button");
	}

	public String getDesktopPageHeadingText() {
		return getTextFromElement(desktopPageHeading, "Desktop Page Heading");
	}

	public String getDesktopPageSubtitleText() {
		return getTextFromElement(desktopPageSubtitle, "Desktop Page Subtitle");
	}

	public void clickDesktopTopCancelButton() {
		WebElement btn = findButtonByExactText(desktopGhostButtons, "Cancel");
		if (btn == null) {
			System.out.println("[UPDATE PROFILE] Desktop top cancel button not found.");
			return;
		}
		clickOnElement(btn, "Desktop Top Cancel Button");
	}

	public void clickDesktopTopSaveChangesButton() {
		if (desktopSaveButtons == null || desktopSaveButtons.isEmpty()) {
			System.out.println("[UPDATE PROFILE] Desktop top save changes button not found.");
			return;
		}
		clickOnElement(desktopSaveButtons.get(0), "Desktop Top Save Changes Button");
	}

	// ============================================================
	// ✅ DESKTOP LEFT PROFILE CARD ACTIONS
	// ============================================================

	public boolean isDesktopProfileCardVisible() {
		return isElementDisplayed(desktopProfileCard, "Desktop Profile Card");
	}

	public boolean isDesktopProfileImageDisplayed() {
		return isElementDisplayed(desktopProfileImage, "Desktop Profile Image");
	}

	public String getDesktopProfileNameText() {
		return getTextFromElement(desktopProfileNameText, "Desktop Profile Name Text");
	}

	public String getDesktopProfileEmailText() {
		return getTextFromElement(desktopProfileEmailText, "Desktop Profile Email Text");
	}

	public String getDesktopProfileImageTitleText() {
		return getTextFromElement(desktopProfileImageTitle, "Desktop Profile Image Title");
	}

	public String getDesktopProfileImageSubtitleText() {
		return getTextFromElement(desktopProfileImageSubtitle, "Desktop Profile Image Subtitle");
	}

	public void uploadProfileImageInDesktop(String absoluteFilePath) {
		typeInInputField(desktopProfileImageFileInput, absoluteFilePath, "Desktop Profile Image File Input");
	}

	public String getDesktopSelectedFileText() {
		if (!isElementPresentInDOM(desktopSelectedFileTextBy))
			return "";
		List<WebElement> els = driver.findElements(desktopSelectedFileTextBy);
		if (els.isEmpty())
			return "";
		String t = els.get(0).getText();
		return t == null ? "" : t.trim();
	}

	// ============================================================
	// ✅ DESKTOP ACCOUNT DETAILS ACTIONS
	// ============================================================

	public String getDesktopAccountDetailsTitleText() {
		return getTextFromElement(desktopAccountDetailsTitle, "Desktop Account Details Title");
	}

	public String getDesktopAccountDetailsSubtitleText() {
		return getTextFromElement(desktopAccountDetailsSubtitle, "Desktop Account Details Subtitle");
	}

	public void enterDesktopFullName(String value) {
		typeInInputField(desktopFullNameInput, value, "Desktop Full Name");
	}

	public void enterDesktopEmail(String value) {
		typeInInputField(desktopEmailInput, value, "Desktop Email");
	}

	public void enterDesktopPhone(String value) {
		typeInInputField(desktopPhoneInput, value, "Desktop Phone");
	}

	public String getDesktopFullNameValue() {
		return getAttributeValueFromElement(desktopFullNameInput, "value", "Desktop Full Name");
	}

	public String getDesktopEmailValue() {
		return getAttributeValueFromElement(desktopEmailInput, "value", "Desktop Email");
	}

	public String getDesktopPhoneValue() {
		return getAttributeValueFromElement(desktopPhoneInput, "value", "Desktop Phone");
	}

	// ============================================================
	// ✅ DESKTOP ADDRESS ACTIONS
	// ============================================================

	public String getDesktopAddressTitleText() {
		return getTextFromElement(desktopAddressTitle, "Desktop Address Title");
	}

	public String getDesktopAddressSubtitleText() {
		return getTextFromElement(desktopAddressSubtitle, "Desktop Address Subtitle");
	}

	public void enterDesktopStreet(String value) {
		typeInInputField(desktopStreetInput, value, "Desktop Street");
	}

	public void enterDesktopCity(String value) {
		typeInInputField(desktopCityInput, value, "Desktop City");
	}

	public void enterDesktopState(String value) {
		typeInInputField(desktopStateInput, value, "Desktop State");
	}

	public void enterDesktopPostalCode(String value) {
		typeInInputField(desktopPostalCodeInput, value, "Desktop Postal Code");
	}

	public void enterDesktopCountry(String value) {
		typeInInputField(desktopCountryInput, value, "Desktop Country");
	}

	public String getDesktopStreetValue() {
		return getAttributeValueFromElement(desktopStreetInput, "value", "Desktop Street");
	}

	public String getDesktopCityValue() {
		return getAttributeValueFromElement(desktopCityInput, "value", "Desktop City");
	}

	public String getDesktopStateValue() {
		return getAttributeValueFromElement(desktopStateInput, "value", "Desktop State");
	}

	public String getDesktopPostalCodeValue() {
		return getAttributeValueFromElement(desktopPostalCodeInput, "value", "Desktop Postal Code");
	}

	public String getDesktopCountryValue() {
		return getAttributeValueFromElement(desktopCountryInput, "value", "Desktop Country");
	}

	// ============================================================
	// ✅ DESKTOP FIELD HELPERS
	// ============================================================

	public int getDesktopFieldRowCount() {
		return desktopFieldRows == null ? 0 : desktopFieldRows.size();
	}

	public List<String> getDesktopFieldLabelTexts() {
		List<String> labels = new ArrayList<>();
		if (desktopFieldLabels != null) {
			for (WebElement el : desktopFieldLabels) {
				String t = el.getText();
				if (t != null && !t.trim().isEmpty())
					labels.add(t.trim());
			}
		}
		return labels;
	}

	public int getDesktopFieldInputCount() {
		return desktopFieldInputs == null ? 0 : desktopFieldInputs.size();
	}

	public void clearDesktopFieldByName(String fieldName) {
		WebElement input = getInputFieldByName(fieldName);
		if (input == null) {
			System.out.println("[UPDATE PROFILE] Desktop field not found: " + fieldName);
			return;
		}
		clearInputField(input, "Desktop Field: " + fieldName);
	}

	public void pressEnterInDesktopFieldByName(String fieldName) {
		WebElement input = getInputFieldByName(fieldName);
		if (input == null) {
			System.out.println("[UPDATE PROFILE] Desktop field not found: " + fieldName);
			return;
		}
		pressKeyInElement(input, Keys.ENTER, "Desktop Field ENTER: " + fieldName);
	}

	// ============================================================
	// ✅ DESKTOP BOTTOM ACTIONS
	// ============================================================

	public boolean isDesktopBottomActionBarVisible() {
		return isElementDisplayed(desktopBottomActionBar, "Desktop Bottom Action Bar");
	}

	public void clickDesktopBottomCancelButton() {
		clickOnElement(desktopBottomCancelButton, "Desktop Bottom Cancel Button");
	}

	public void clickDesktopBottomSaveChangesButton() {
		clickOnElement(desktopBottomSaveChangesButton, "Desktop Bottom Save Changes Button");
	}

	public String getDesktopTipText() {
		return getTextFromElement(desktopTipText, "Desktop Tip Text");
	}

	// ============================================================
	// ✅ COMMON / GENERIC FIELD METHODS
	// ============================================================

	public void enterValueInFieldByName(String fieldName, String value) {
		WebElement input = getInputFieldByName(fieldName);
		if (input == null) {
			System.out.println("[UPDATE PROFILE] Field not found by name: " + fieldName);
			return;
		}
		typeInInputField(input, value, "Field By Name: " + fieldName);
	}

	public String getValueFromFieldByName(String fieldName) {
		WebElement input = getInputFieldByName(fieldName);
		if (input == null) {
			System.out.println("[UPDATE PROFILE] Field not found by name: " + fieldName);
			return "";
		}
		return getAttributeValueFromElement(input, "value", "Field By Name: " + fieldName);
	}

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public boolean verifyUpdateProfilePageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyUpdateProfilePageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}
}