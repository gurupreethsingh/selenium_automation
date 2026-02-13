package scripts.homepage_scenarios.funtional_scenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic.AutomationConstants;

public class O5_FindAllparagraphsInHomepage implements AutomationConstants{

	public static void main(String[] args) throws InterruptedException 
	{
//		<a href = "/shop all">shop all </a>
		
		// open the browswer. 
		WebDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();		
		// sufficient waiting time. to load the browser. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate to the web page.
		driver.get(urlOfApplication);
		// sufficient waiting time to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	     List<WebElement> allpara = driver.findElements(By.tagName("p"));
	     
	     System.out.println("Total paragraphs found in homepage are : " + allpara.size());
	     
	     for(int i=0; i<allpara.size(); i++)
	     {
	    	String eachparaText =  allpara.get(i).getText();
	    	System.out.println(i+1 + "  link : " + eachparaText);
	    	Thread.sleep(500);
	    	System.out.println("************************************");
	     }
	     
	     Thread.sleep(5000);
	     driver.quit();
	}
}
