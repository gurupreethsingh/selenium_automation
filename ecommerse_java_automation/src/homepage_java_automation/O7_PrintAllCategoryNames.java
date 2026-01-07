package homepage_java_automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screenshots.TakeScreenshot;

public class O7_PrintAllCategoryNames {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("http://localhost:5173/");

            // Wait for Home title
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Home"));


            try
            {
            	List<WebElement>  allcategories = driver.findElements(By.xpath("//div[@id='categoryCarousel']/div"));

            	int count = allcategories.size();
            	int expectedCount = 10;

            	if(count == expectedCount)
            	{
            		System.out.println("count is matching, Text case pass. ");
            		System.out.println("total category counts is " + count);
            	}

            	int index = 1;
            	for(WebElement eachCategory : allcategories)
            	{
            		System.out.println(index + " " + eachCategory.getText());
            		Thread.sleep(300);
            		index++;
            	}


            }
            catch(Exception ex)
            {
            	ex.printStackTrace();
            	System.out.println("Count is wrong");
            	// screen shot code.
            	TakeScreenshot.getScreenshot(driver);
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to click Shop Now.");
        } finally {
            if (driver != null) {
                Thread.sleep(2000); // optional delay
                driver.quit();
            }
        }
    }
}
