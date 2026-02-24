// POM -  page object model 
// it will locate all your webelements.  
// initiailize all the web elements. 
// it will perform acions on the web elements. 

package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.AllVerifications;

public class SearchProductsPage extends AllVerifications {
	// global variable.
	WebDriver driver = null;

	// declaration / finding
	@FindBy(xpath = " //span[@class='text-[13px] font-extrabold text-gray-900 tracking-tight']")
	private WebElement logo;

	// intilization
	SearchProductsPage() {
		PageFactory.initElements(driver, this);
	}

	// utilize the web element .
	public void clickOnLogo() {
		logo.click();
	}

	public void veritySearchProductsPageTitle(String expectedTitle) {
		verifyTitleOfWebpage(driver, expectedTitle);
	}

}
