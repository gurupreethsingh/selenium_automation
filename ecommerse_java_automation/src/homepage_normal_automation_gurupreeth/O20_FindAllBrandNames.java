package homepage_normal_automation_gurupreeth;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O20_FindAllBrandNames {

    public static void main(String[] args) {
        WebDriver driver = null;
        SoftAssert sa = new SoftAssert();

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Read URL and Expected Title from Excel
            String websiteUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);
            String expectedTitle = O3_ReadFromExcel.getData("Homepage", 1, 1);
            String expectedUrl = O3_ReadFromExcel.getData("Homepage", 1, 2);

            // Open Website
            driver.get(websiteUrl);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Verify Title
            All_Verifications.verifyTitleMatch(expectedTitle, driver, sa);

            All_Verifications.verifyUrleMatch(expectedUrl, driver, sa);

            // find all the images. from hero section. and print the name of all the images.
            List<WebElement> allCategoryNames = driver.findElements(By.cssSelector("section.py-10.px-4.bg-gray-50 > div > div"));
//            List<WebElement> allSlides = driver.findElements(By.xpath("//section[@class='py-10 px-4 bg-white']/div[2]/div/div"));

            	System.out.println("Total categories: " + allCategoryNames.size());

            	for (WebElement eachCategory : allCategoryNames) {
            	    System.out.println(eachCategory.getText());
            	    Thread.sleep(300);
            	}

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                sa.assertAll();
            } catch (AssertionError ae) {
                ae.printStackTrace();
            } finally {
                try {
                    if (driver != null) {
                        driver.quit();
                        System.out.println("Browser closed successfully.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed to close browser.");
                }
            }
        }
    }
}
