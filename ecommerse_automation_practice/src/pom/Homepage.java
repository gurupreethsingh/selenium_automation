// POM -  page object model 
// it will locate all your webelements.  
// initiailize all the web elements. 
// it will perform acions on the web elements. 

package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class Homepage extends AllVerifications {
	// global variable.
	WebDriver driver = null;

	// declaration / finding
	@FindBy(xpath = "//span[@class='text-[13px] font-extrabold text-gray-900 tracking-tight']")
	private WebElement logo;

	@FindBy(css = "a.linkText")
	private WebElement shopAllLink;

	@FindBy(css = "div.relative.rounded-2xl.bg-white.px-3.py-2.transition")
	private WebElement wishlistIcon;

	@FindBy(tagName = "a")
	private List<WebElement> allLinks;

	// intilization
	public Homepage(WebDriver driver) { // constrctor injection
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogo() {
		logo.click();
	}

	public void clickOnShopAllLink() {
		shopAllLink.click();
	}

	public void clickOnWishlistIcon() {
		wishlistIcon.click();
	}

	public void findAllLinksInHomepageAndPrintTextOfLinks() {
		int count = allLinks.size();
		System.out.println("Total links in homepage found are : " + count);
		for (int i = 0; i < allLinks.size(); i++) {
			String eachLinkText = allLinks.get(i).getText();
			System.out.println("***************************");
			System.out.println("Link text :-  " + eachLinkText + " Links Address or href is : - "
					+ allLinks.get(i).getAttribute("href"));
			System.out.println("***************************");
		}
	}

	public void verityHomepageTitle(String expectedTitle) {
		verifyTitleOfWebpage(driver, expectedTitle);
	}

}
