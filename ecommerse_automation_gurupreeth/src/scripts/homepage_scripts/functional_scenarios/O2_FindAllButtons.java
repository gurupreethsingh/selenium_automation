package scripts.homepage_scripts.functional_scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.OpenClose;

public class O2_FindAllButtons extends OpenClose
{
	SoftAssert sa = new SoftAssert();
	
    @Test
    public void findAllButtonsInHomepage() throws InterruptedException
    {
    	   // Use a locator so we can pass it to the verifier
        By BUTTONS = By.tagName("button");

        // (Optional) grab current snapshot to log texts
        List<WebElement> allButtons = driver.findElements(BUTTONS);
        System.out.println("Total buttons in the page : " + allButtons.size());

        for(int i = 0; i < allButtons.size(); i++) 
        { 
        	String eachButtonText = allButtons.get(i).getText(); 
             System.out.println(eachButtonText); 
             Thread.sleep(500); 
        }

        // ✅ Call the new helper that waits until the count == expected
        AllVerifications.verifyTotalNumberOfElements(11, driver, BUTTONS, sa);
    }
}
