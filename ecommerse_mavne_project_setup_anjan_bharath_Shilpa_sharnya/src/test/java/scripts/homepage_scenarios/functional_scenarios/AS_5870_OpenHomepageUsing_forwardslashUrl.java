package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_5870_OpenHomepageUsing_forwardslashUrl extends OpenClose {

	@Test
	public void testOpenHomepageUsing_forwardslashUrl() throws IOException {
		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		boolean titleVerified = hp.verifyHomepageTitle(expectedHomePageTitle);
		System.out.println(titleVerified);
	}
}

//package scripts.homepage_scenarios.functional_scenarios;
//
//import java.io.IOException;
//
//import org.testng.annotations.Test;
//
//import generic.Excel;
//import generic.OpenClose;
//import pom.HomePage;
//
//public class AS_5870_OpenHomepageUsing_forwardslashUrl extends OpenClose {
//
//	@Test
//	public void testOpenHomepageUsing_forwardslashUrl() throws IOException {
//		setViewport(320, 568, "iPhone SE");
//		HomePage hp = new HomePage(driver);
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		hp.verifyHomepageTitle(expectedHomePageTitle);
//
//	}
//}

//package scripts.homepage_scenarios.functional_scenarios;
//
//import java.io.IOException;
//
//import org.testng.annotations.Test;
//
//import generic.Excel;
//import generic.OpenClose;
//import generic.ViewportDataProvider;
//import pom.HomePage;
//
//public class AS_5870_OpenHomepageUsing_forwardslashUrl extends OpenClose {
//
//	@Test(dataProvider = "allScreenSizes", dataProviderClass = ViewportDataProvider.class)
//	public void testOpenHomepageUsing_forwardslashUrl(int width, int height, String deviceName) throws IOException {
//
//		setViewport(width, height, deviceName);
//		HomePage hp = new HomePage(driver);
//		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
//		hp.verifyHomepageTitle(expectedHomePageTitle);
//
//	}
//}
