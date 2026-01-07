package homepage_normal_automation_gurupreeth;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import excel_automation.O3_ReadFromExcel;
import verification_methods.All_Verifications;

public class O13_FindAllHeadingOnEachImage {

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
//            List<WebElement> allHeadings = driver.findElements(By.cssSelector(".carousel-caption h5"));
            List<WebElement> allSlides = driver.findElements(
            	    By.xpath("//div[@id='carouselExampleDark']//div[contains(@class,'carousel-item')]")
            	);

            	System.out.println("Total slides: " + allSlides.size());

            	JavascriptExecutor js = (JavascriptExecutor) driver;

            	for (WebElement slide : allSlides) {
            	    try {
            	        WebElement heading = slide.findElement(By.tagName("h5"));

            	        // Use JavaScript to extract even if not visible
            	        String text = (String) js.executeScript("return arguments[0].textContent.trim();", heading);
            	        System.out.println("Slide heading: " + text);
            	        Thread.sleep(300);
            	    } catch (Exception e) {
            	        System.out.println("⚠️ No <h5> found in this slide.");
            	    }
            	}


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Final assert to report any soft assertion failures
            sa.assertAll();

            if (driver != null) {
                driver.quit();
            }
        }
    }
}
