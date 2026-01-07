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

public class O12_FindAllImageNamesFromHeroSection {

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
            List<WebElement> allImages = driver.findElements(By.xpath("//div[@id='carouselExampleDark']/div[1]/div/img"));

            System.out.println("Tatol Sliders and images are : "+ allImages.size());

            for(WebElement eachImage : allImages)
            {
            	String imageName = eachImage.getAttribute("src");
            	System.out.println(imageName);
            	Thread.sleep(300);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Final assert to report any soft assertion failures
            sa.assertAll();

            // Quit browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
