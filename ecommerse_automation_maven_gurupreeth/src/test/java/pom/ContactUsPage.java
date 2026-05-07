package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class ContactUsPage extends AllVerifications {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#root main div.flex.flex-col.gap-10")
	private WebElement contactUsParentContainer;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:first-child")
	private WebElement contactUsLeftContainer;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:first-child>h2")
	private WebElement leftContinerMainHeading;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:first-child>p")
	private WebElement leftContinerSubHeading;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form")
	private WebElement contactUsForm;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form input#firstName")
	private WebElement firstNameField;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form input#lastName")
	private WebElement lastNameField;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form input#email")
	private WebElement emailField;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form input#phone")
	private WebElement phoneField;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form textarea#message_text")
	private WebElement messageField;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form input[type='checkbox']")
	private WebElement checkbox;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form span.text-sm.text-gray-700")
	private WebElement aggrementText;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10 form button.bg-red-500")
	private WebElement submitFormButton;

	@FindBy(css = "div.shipping_section.p-4")
	private WebElement contactInformationContainer;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:first-child>div.flex>h5")
	private WebElement contactInformationEmailHeading;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:first-child>div.flex>p")
	private WebElement contactInformationEmailText;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:nth-of-type(2)>div.flex>h5")
	private WebElement contactInformationPhoneHeading;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:nth-of-type(2)>div.flex>p")
	private WebElement contactInformationPhoneText;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:nth-of-type(3) span")
	private WebElement contactInformationAddressHeading;

	@FindBy(css = "div.shipping_section.p-4 div.flex.items-center:nth-of-type(3) p")
	private WebElement contactInformationAddressText;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:last-child")
	private WebElement contactUsRightContainer;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:last-child>p")
	private WebElement contactUsRightContainerHeading;

	@FindBy(css = "div#root main div.flex.flex-col.gap-10>div:last-child>div>iframe")
	private WebElement contactUsRightContainerMapFrame;

	// ============================================================
	// ✅ PAGE VERIFICATION
	// ============================================================

	public void verifyContactUsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(expectedTitle);
	}

	public void verifyContactUsPageUrl(String expectedUrl) {
		verifyUrlOfWebpage(expectedUrl);
	}

	// ============================================================
	// ✅ CONTACT US MAIN CONTAINER ACTIONS / VERIFICATIONS
	// ============================================================

	public boolean verifyContactUsParentContainerVisible() {
		return verifyElementPresentAndVisible(contactUsParentContainer, "Contact Us Parent Container");
	}

	public boolean verifyContactUsLeftContainerVisible() {
		return verifyElementPresentAndVisible(contactUsLeftContainer, "Contact Us Left Container");
	}

	public boolean verifyLeftContainerMainHeadingVisible() {
		return verifyElementPresentAndVisible(leftContinerMainHeading, "Contact Us Left Container Main Heading");
	}

	public boolean verifyLeftContainerMainHeadingText(String expectedText) {
		return verifyText(leftContinerMainHeading, expectedText, "Contact Us Left Container Main Heading", "contains",
				true);
	}

	public boolean verifyLeftContainerSubHeadingVisible() {
		return verifyElementPresentAndVisible(leftContinerSubHeading, "Contact Us Left Container Sub Heading");
	}

	public boolean verifyLeftContainerSubHeadingText(String expectedText) {
		return verifyText(leftContinerSubHeading, expectedText, "Contact Us Left Container Sub Heading", "contains",
				true);
	}

	// ============================================================
	// ✅ CONTACT FORM ACTIONS / VERIFICATIONS
	// ============================================================

	public boolean verifyContactUsFormVisible() {
		return verifyElementPresentAndVisible(contactUsForm, "Contact Us Form");
	}

	public boolean verifyFirstNameFieldVisible() {
		return verifyElementPresentVisibleAndEnabled(firstNameField, "First Name Field");
	}

	public boolean verifyFirstNameFieldEnabled() {
		return verifyElementIsEnabled(firstNameField, "First Name Field");
	}

	public boolean verifyFirstNameFieldVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(firstNameField, "First Name Field");
	}

	public boolean verifyFirstNameFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(firstNameField, expectedPlaceholder, "First Name Field");
	}

	public boolean enterFirstName(String firstName) {
		return handleInputField(firstNameField, firstName, "First name", "First Name");
	}

	public boolean verifyLastNameFieldVisible() {
		return verifyElementPresentVisibleAndEnabled(lastNameField, "Last Name");
	}

	public boolean verifyLastNameFieldEnabled() {
		return verifyElementIsEnabled(lastNameField, "Last Name");
	}

	public boolean verifyLastNameFieldVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(lastNameField, "Last Name");
	}

	public boolean verifyLastNameFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(lastNameField, expectedPlaceholder, "Last Name");
	}

	public boolean enterLastName(String lastName) {
		return handleInputField(lastNameField, lastName, "Last name (optional)", "Last Name");
	}

	public boolean verifyEmailFieldVisible() {
		return verifyElementPresentVisibleAndEnabled(emailField, "Email");
	}

	public boolean verifyEmailFieldEnabled() {
		return verifyElementIsEnabled(emailField, "Email");
	}

	public boolean verifyEmailFieldVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(emailField, "Email");
	}

	public boolean verifyEmailFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(emailField, expectedPlaceholder, "Email");
	}

	public boolean enterEmail(String email) {
		return handleInputField(emailField, email, "you@example.com", "Email Field");
	}

	public boolean verifyPhoneFieldVisible() {
		return verifyElementPresentVisibleAndEnabled(phoneField, "Phone Field");
	}

	public boolean verifyPhoneFieldEnabled() {
		return verifyElementIsEnabled(phoneField, "Phone Field");
	}

	public boolean verifyPhoneFieldVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(phoneField, "Phone Field");
	}

	public boolean verifyPhoneFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(phoneField, expectedPlaceholder, "Phone Field");
	}

	public boolean enterPhoneNumber(String phoneNumber) {
		return handleInputField(phoneField, phoneNumber, "Your phone (optional)", "Phone Field");
	}

	public boolean verifyMessageFieldVisible() {
		return verifyElementPresentVisibleAndEnabled(messageField, "Message Field");
	}

	public boolean verifyMessageFieldEnabled() {
		return verifyElementIsEnabled(messageField, "Message Field");
	}

	public boolean verifyMessageFieldVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(messageField, "Message Field");
	}

	public boolean verifyMessageFieldPlaceholder(String expectedPlaceholder) {
		return verifyInputFieldPlaceholder(messageField, expectedPlaceholder, "Message Field");
	}

	public boolean enterMessage(String message) {
		return handleInputField(messageField, message, "How can we help?", "Message Field");
	}

	public boolean verifyAgreementCheckboxVisible() {
		return verifyElementPresentVisibleAndEnabled(checkbox, "Agreement Checkbox");
	}

	public boolean verifyAgreementCheckboxEnabled() {
		return verifyElementIsEnabled(checkbox, "Agreement Checkbox");
	}

	public boolean verifyAgreementCheckboxVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(checkbox, "Agreement Checkbox");
	}

	public boolean clickAgreementCheckbox() {
		return verifyAgreementCheckboxVisibleAndEnabled() && clickOnElement(checkbox, "Agreement Checkbox");
	}

	public boolean verifyAgreementTextVisible() {
		return verifyElementPresentAndVisible(aggrementText, "Agreement Text");
	}

	public boolean verifyAgreementText(String expectedText) {
		return verifyText(aggrementText, expectedText, "Agreement Text", "contains", true);
	}

	public boolean verifySubmitFormButtonVisible() {
		return verifyElementPresentVisibleAndEnabled(submitFormButton, "Submit Form Button");
	}

	public boolean verifySubmitFormButtonEnabled() {
		return verifyElementIsEnabled(submitFormButton, "Submit Form Button");
	}

	public boolean verifySubmitFormButtonVisibleAndEnabled() {
		return verifyElementPresentVisibleAndEnabled(submitFormButton, "Submit Form Button");
	}

	public boolean verifySubmitFormButtonText(String expectedText) {
		return verifyText(submitFormButton, expectedText, "Submit Form Button", "contains", true);
	}

	public boolean clickSubmitFormButton() {
		return verifySubmitFormButtonVisibleAndEnabled() && clickOnElement(submitFormButton, "Submit Form Button");
	}

	public boolean fillContactUsForm(String firstName, String lastName, String email, String phoneNumber,
			String message) {
		return enterFirstName(firstName) && enterLastName(lastName) && enterEmail(email)
				&& enterPhoneNumber(phoneNumber) && enterMessage(message);
	}

	public boolean submitContactUsForm(String firstName, String lastName, String email, String phoneNumber,
			String message) {
		return fillContactUsForm(firstName, lastName, email, phoneNumber, message) && clickAgreementCheckbox()
				&& clickSubmitFormButton();
	}

	// ============================================================
	// ✅ CONTACT INFORMATION ACTIONS / VERIFICATIONS
	// ============================================================

	public boolean verifyContactInformationContainerVisible() {
		return verifyElementPresentAndVisible(contactInformationContainer, "Contact Information Container");
	}

	public boolean verifyContactInformationEmailHeadingVisible() {
		return verifyElementPresentAndVisible(contactInformationEmailHeading, "Contact Information Email Heading");
	}

	public boolean verifyContactInformationEmailHeadingText(String expectedText) {
		return verifyText(contactInformationEmailHeading, expectedText, "Contact Information Email Heading", "contains",
				true);
	}

	public boolean verifyContactInformationEmailTextVisible() {
		return verifyElementPresentAndVisible(contactInformationEmailText, "Contact Information Email Text");
	}

	public boolean verifyContactInformationEmailText(String expectedText) {
		return verifyText(contactInformationEmailText, expectedText, "Contact Information Email Text", "contains",
				true);
	}

	public boolean verifyContactInformationPhoneHeadingVisible() {
		return verifyElementPresentAndVisible(contactInformationPhoneHeading, "Contact Information Phone Heading");
	}

	public boolean verifyContactInformationPhoneHeadingText(String expectedText) {
		return verifyText(contactInformationPhoneHeading, expectedText, "Contact Information Phone Heading", "contains",
				true);
	}

	public boolean verifyContactInformationPhoneTextVisible() {
		return verifyElementPresentAndVisible(contactInformationPhoneText, "Contact Information Phone Text");
	}

	public boolean verifyContactInformationPhoneText(String expectedText) {
		return verifyText(contactInformationPhoneText, expectedText, "Contact Information Phone Text", "contains",
				true);
	}

	public boolean verifyContactInformationAddressHeadingVisible() {
		return verifyElementPresentAndVisible(contactInformationAddressHeading, "Contact Information Address Heading");
	}

	public boolean verifyContactInformationAddressHeadingText(String expectedText) {
		return verifyText(contactInformationAddressHeading, expectedText, "Contact Information Address Heading",
				"contains", true);
	}

	public boolean verifyContactInformationAddressTextVisible() {
		return verifyElementPresentAndVisible(contactInformationAddressText, "Contact Information Address Text");
	}

	public boolean verifyContactInformationAddressText(String expectedText) {
		return verifyText(contactInformationAddressText, expectedText, "Contact Information Address Text", "contains",
				true);
	}

	// ============================================================
	// ✅ RIGHT CONTAINER / MAP ACTIONS / VERIFICATIONS
	// ============================================================

	public boolean verifyContactUsRightContainerVisible() {
		return verifyElementPresentAndVisible(contactUsRightContainer, "Contact Us Right Container");
	}

	public boolean verifyContactUsRightContainerHeadingVisible() {
		return verifyElementPresentAndVisible(contactUsRightContainerHeading, "Contact Us Right Container Heading");
	}

	public boolean verifyContactUsRightContainerHeadingText(String expectedText) {
		return verifyText(contactUsRightContainerHeading, expectedText, "Contact Us Right Container Heading",
				"contains", true);
	}

	public boolean verifyContactUsRightContainerMapFrameVisible() {
		return verifyElementPresentAndVisible(contactUsRightContainerMapFrame, "Contact Us Right Container Map Frame");
	}

	// verify all the text values in the contact us page.

	public boolean verifyAllContactUsPageTextValues(String expectedMainHeading, String expectedSubHeading,
			String expectedAgreementText, String expectedSubmitButtonText, String expectedEmailHeading,
			String expectedEmailText, String expectedPhoneHeading, String expectedPhoneText,
			String expectedAddressHeading, String expectedAddressText, String expectedRightContainerHeading) {

		return verifyLeftContainerMainHeadingText(expectedMainHeading)
				&& verifyLeftContainerSubHeadingText(expectedSubHeading) && verifyAgreementText(expectedAgreementText)
				&& verifySubmitFormButtonText(expectedSubmitButtonText)
				&& verifyContactInformationEmailHeadingText(expectedEmailHeading)
				&& verifyContactInformationEmailText(expectedEmailText)
				&& verifyContactInformationPhoneHeadingText(expectedPhoneHeading)
				&& verifyContactInformationPhoneText(expectedPhoneText)
				&& verifyContactInformationAddressHeadingText(expectedAddressHeading)
				&& verifyContactInformationAddressText(expectedAddressText)
				&& verifyContactUsRightContainerHeadingText(expectedRightContainerHeading);
	}

	// ============================================================
	// ✅ FULL PAge elements are visible.
	// ============================================================

	public boolean verifyAllContactUsPageMainElementsVisible() {
		return verifyContactUsParentContainerVisible() && verifyContactUsLeftContainerVisible()
				&& verifyLeftContainerMainHeadingVisible() && verifyLeftContainerSubHeadingVisible()
				&& verifyContactUsFormVisible() && verifyFirstNameFieldVisible() && verifyLastNameFieldVisible()
				&& verifyEmailFieldVisible() && verifyPhoneFieldVisible() && verifyMessageFieldVisible()
				&& verifyAgreementCheckboxVisible() && verifyAgreementTextVisible() && verifySubmitFormButtonVisible()
				&& verifyContactInformationContainerVisible() && verifyContactInformationEmailHeadingVisible()
				&& verifyContactInformationEmailTextVisible() && verifyContactInformationPhoneHeadingVisible()
				&& verifyContactInformationPhoneTextVisible() && verifyContactInformationAddressHeadingVisible()
				&& verifyContactInformationAddressTextVisible() && verifyContactUsRightContainerVisible()
				&& verifyContactUsRightContainerHeadingVisible() && verifyContactUsRightContainerMapFrameVisible();
	}

	// verify all the form elements are visible and enabled.
	public boolean verifyAllContactUsFormFieldsEnabled() {
		return verifyFirstNameFieldEnabled() && verifyLastNameFieldEnabled() && verifyEmailFieldEnabled()
				&& verifyPhoneFieldEnabled() && verifyMessageFieldEnabled() && verifyAgreementCheckboxEnabled()
				&& verifySubmitFormButtonEnabled();
	}

	public boolean verifyAllContactUsFormFieldsVisibleAndEnabled() {
		return verifyFirstNameFieldVisibleAndEnabled() && verifyLastNameFieldVisibleAndEnabled()
				&& verifyEmailFieldVisibleAndEnabled() && verifyPhoneFieldVisibleAndEnabled()
				&& verifyMessageFieldVisibleAndEnabled() && verifyAgreementCheckboxVisibleAndEnabled()
				&& verifySubmitFormButtonVisibleAndEnabled();
	}
}