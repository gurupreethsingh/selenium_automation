package browser_details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDetials {

	public static void main(String[] args) throws InterruptedException {
		   System.setProperty("webdriver.chrome.driver",
				   "C:\\Users\\Administrator\\Desktop\\latest_Eclipse\\all_programs\\selenium_automation\\all_necessary_files\\chromedriver.exe");
		   // open the browser
		   WebDriver driver = new ChromeDriver();
		   
		   // navigate to the website 
		   driver.get("https://www.ecoders.in");
		   
		   // navigates to the web address
	//	   driver.navigate().to("https://ecoders.in");
		   
		   // get the title. 
		   String titleofpage = driver.getTitle();
		   System.out.println(titleofpage);
		   Thread.sleep(1000);
		   
		   // get the current url of the page. 
		   String url = driver.getCurrentUrl();
		   System.out.println(url);
		   Thread.sleep(1000);
		   
		   
		   //page source. 
//		   String pagesource = driver.getPageSource();
//		   System.out.println(pagesource);
		   
		   // sleeps for 5 seconds
		   Thread.sleep(2000);
		   
		   // close the browsers
		   driver.quit();
	}
}