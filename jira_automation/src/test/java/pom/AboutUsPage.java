package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class AboutUsPage extends AllVerifications {

	// find all the elements / web elements.
	@FindBy(css = "span[class = 'service-tag-pill']:nth-of-type(1)")
	private WebElement aboutBadgeHeroSection;

	@FindBy(css = "span[class = 'service-tag-pill']:nth-of-type(2)")
	private WebElement softwareBadgeHeroSection;

	@FindBy(css = "span[class = 'service-tag-pill']:nth-of-type(3)")
	private WebElement aiSystemBadgeHeroSection;

	@FindBy(css = "span[class = 'service-tag-pill']:nth-of-type(4)")
	private WebElement blockchainBadgeHeroSection;

	@FindBy(css = "span[class = 'service-tag-pill']:nth-of-type(5)")
	private WebElement cloudBadgeHeroSection;

	// Initialize all the elements
	public AboutUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTextOfAboutBadgeInHeroSection(String expectedText) {
		return verifyText(aboutBadgeHeroSection, expectedText, "ABOUT", "equals", true);
	}

	public boolean verifyTextOfSoftwareBadgeInHeroSection(String expectedText) {
		return verifyText(softwareBadgeHeroSection, expectedText, "SOFTWARE", "equals", true);
	}

	public boolean verifyTextOfBlockchainBadgeInHeroSection(String expectedText) {
		return verifyText(blockchainBadgeHeroSection, expectedText, "BLOCKCHAIN", "equals", true);
	}

	public boolean verifyTextOfAiSystemBadgeInHeroSection(String expectedText) {
		return verifyText(aiSystemBadgeHeroSection, expectedText, "AI SYSTEMS", "equals", true);
	}

	public boolean verifyTextOfCloudBadgeInHeroSection(String expectedText) {
		return verifyText(cloudBadgeHeroSection, expectedText, "CLOUD", "equals", true);
	}

	public boolean verifyAboutUsPageTitle(String expectedTitle) {
		return verifyTitleOfWebpage(expectedTitle);
	}

	public boolean verifyAboutUsPageUrl(String expectedUrl) {
		return verifyUrlOfWebpage(expectedUrl);
	}

}
