package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_7346_OpenHomePageUsingUrl extends OpenClose {

	@Test
	public void testOpenHomePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);

		driver.get(URL_HOME);

		HomePage page = new HomePage(driver);
		page.verifyHomePageTitle(expectedTitle);
	}
}

// to run the code in all the screen sizes, one by one. 
//public class AS_7346_OpenHomePageUsingUrl extends OpenClose {
//
//	@Test(dataProvider = "allViewports", dataProviderClass = ViewportDataProvider.class)
//	public void testOpenHomePageUsingUrl(int width, int height, String deviceName) throws IOException {
//
//		setViewport(width, height);
//		driver.get(URL_HOME);
//		String expectedTitle = (String) Excel.getData("HomePage", 1, 0);
//		HomePage page = new HomePage(driver);
//		page.verifyHomePageTitle(expectedTitle);
//		System.out.println("Test executed on: " + deviceName + " -> " + width + "x" + height);
//		System.out.println("*******************************************************************");
//	}
//}
