package scripts.homepage_scripts.functional_scenarios;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class O6_EnterSesarchFieldOpenSearchPAge extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
   @Test
   public void enterTextIntoSearchField()
   {
		String expectedHomepageTitle = (String)Excel.getData("Homepage", 0, 0); 
		AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
		 
	   Homepage hp = new Homepage(driver);
	   hp.enterValueInSearchField("pen");
	   hp.clickOnSearchButton();
	   
	   String expectedSearchProductTitle = (String)Excel.getData("searchproductpage", 0, 0); 
	   AllVerifications.verifyTitle(expectedSearchProductTitle, driver, sa);
	  
   }
}
