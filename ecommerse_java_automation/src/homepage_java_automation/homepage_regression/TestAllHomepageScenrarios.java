package homepage_java_automation.homepage_regression;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import screenshots.TakeScreenshot;

public class TestAllHomepageScenrarios
{
	WebDriver driver = null;

	@BeforeMethod
	public void openApplication()
	{
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("http://localhost:5173/");
	}

	@Test(priority= 1, enabled=true)
	public void testHomepapeOpened()
	{
		String expectedTitle = "Home | ECODERS";
		String expectedUrl = "http://localhost:5173/";
		String actualUrl = driver.getCurrentUrl();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			Reporter.log("title matched.");
			System.out.println("Home url is "+ driver.getCurrentUrl());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Reporter.log("ulr didnt match.");
			// screenshot code.
			TakeScreenshot.getScreenshot(driver);
		}
	}

	@Test(priority=2, enabled=true)
	public void testOpeningShopPageClickShopnowButton()
	{
		String expectedTitle = "Home | ECODERS";
		String expectedUrl = "http://localhost:5173/";

		String actualUrl = driver.getCurrentUrl();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			Reporter.log("title matched.");

			  // Wait for active slide
            wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'carousel-item') and contains(@class,'active')]")));

            // Wait until "Shop Now" button inside active slide is clickable
            By shopNowXPath = By.xpath("//div[contains(@class,'carousel-item') and contains(@class,'active')]/div/a");
            WebElement shopNowButton = wait.until(ExpectedConditions.elementToBeClickable(shopNowXPath));


            // Now click
            shopNowButton.click();
            System.out.println("Clicked on Shop Now button of active carousel slide.");

            // match the title of shop page.
            String exptectedShopUrl = "http://localhost:5173/shop";
            try
            {
            	wait.until(ExpectedConditions.urlMatches(exptectedShopUrl ));
    			System.out.println("Url is matched.");
    			System.out.println("shop url is "+ driver.getCurrentUrl());
            }
            catch(Exception ex)
            {
            	ex.printStackTrace();
            	TakeScreenshot.getScreenshot(driver);
            }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Reporter.log("ulr didnt match.");
			// screenshot code.
			TakeScreenshot.getScreenshot(driver);
		}
	}



	@Test(priority=3, enabled=true)
	public void testVerigyCategoryTextHeading()
	{
		String expectedTitle = "Home | ECODERS";
		String expectedUrl = "http://localhost:5173/";

		String actualUrl = driver.getCurrentUrl();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			Reporter.log("title matched.");

			 // Wait for active slide
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//div[@class='flex justify-between items-center mb-6']/h2")));

		    // Wait until "Shop Now" button inside active slide is clickable
		    WebElement categoryHading = driver.findElement(By.xpath("//div[@class='flex justify-between items-center mb-6']/h2"));

		    String exptectedText = "Explore Our Categories";
		    System.out.println("Acutal heading" + categoryHading.getText());

		    try
		    {
		    	 wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='flex justify-between items-center mb-6']/h2"), exptectedText));
		    	 System.out.println("Text is matching.");
		    }
		    catch(Exception ex)
		    {
		    	ex.printStackTrace();
		    	System.out.println("Text is not matching.");
		    	// screen shot code.
		    	TakeScreenshot.getScreenshot(driver);
		    }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Reporter.log("ulr didnt match.");
			// screenshot code.
			TakeScreenshot.getScreenshot(driver);
		}
	}





	@Test(priority=4, enabled=true)
	public void testPrintingAllCategoryNames()
	{
		String expectedTitle = "Home | ECODERS";
		String expectedUrl = "http://localhost:5173/";

		String actualUrl = driver.getCurrentUrl();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			wait.until(ExpectedConditions.titleIs(expectedTitle));
			Reporter.log("title matched.");
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

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Reporter.log("ulr didnt match.");
			// screenshot code.
			TakeScreenshot.getScreenshot(driver);
		}
	}


	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
	}

}
