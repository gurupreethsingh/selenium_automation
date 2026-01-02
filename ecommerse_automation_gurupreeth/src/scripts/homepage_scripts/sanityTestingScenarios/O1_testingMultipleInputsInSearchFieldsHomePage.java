package scripts.homepage_scripts.sanityTestingScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;
import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class O1_testingMultipleInputsInSearchFieldsHomePage extends OpenClose {

    SoftAssert sa = new SoftAssert();

    @Test
    public void testingSearchField() throws InterruptedException {

        int totalInputsGiven = 0;
        int passCount = 0;
        int failCount = 0;
        int skipCount = 0;

        for (int i = 0; i <= 240; i++) {
            String expectedHomepageTitle = (String) Excel.getData("Homepage", 0, 0);
            AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);

            Homepage hp = new Homepage(driver);
            String textToEnter = (String) Excel.getData("Homepage", i, 4);

            try {
                hp.enterValueInSearchField(textToEnter);
            } catch (WebDriverException e) {
                if (e.getMessage().contains("only supports characters in the BMP")) {
                    skipCount++;
                    continue; // skip emoji inputs
                }
            }

            String expectedTextEntered = "Results for \"" + textToEnter + "\"";

            hp.clickOnSearchButton();
            totalInputsGiven++;

            String expectedSearchProductTitle = (String) Excel.getData("searchproductpage", 0, 0);
            AllVerifications.verifyTitle(expectedSearchProductTitle, driver, sa);

            WebElement heading = driver.findElement(By.cssSelector("h1.text-3xl"));
            System.out.println(heading.getText());

            AllVerifications.textIsPresentOrNot(expectedTextEntered, driver, heading, sa);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            AllVerifications.verifyTitle(expectedHomepageTitle, driver, sa);
        }

        System.out.println("Totally " + totalInputsGiven + " inputs were entered");
        System.out.println("Passed     : " + passCount);
        System.out.println("Failed     : " + failCount);
        System.out.println("Skipped    : " + skipCount);

        sa.assertAll();
    }
}
