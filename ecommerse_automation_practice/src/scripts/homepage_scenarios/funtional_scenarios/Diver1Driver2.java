package scripts.homepage_scenarios.funtional_scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Diver1Driver2 {

	public static void main(String[] args) {
		// mutiple driver refrenence variables.

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ecoders.co.in");

		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.ecoders.co.in");

	}

}
