package scripts.homepage_scenarios.funtional_scenarios;

import java.io.IOException;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_1383_OpenHompageUsingUrl extends OpenClose {
	public static void main(String[] args) throws InterruptedException, IOException {

		OpenClose.openApplication();

		Homepage hp = new Homepage(driver);

		String expectedTitle = (String) Excel.getData("Homepage", 1, 0);
		System.out.println("Title from excel sheet : " + expectedTitle);
		String expectedUrl = (String) Excel.getData("Homepage", 1, 1);
		System.out.println("Url from excel sheet : " + expectedUrl);

		int password = ((Double) Excel.getData("Homepage", 1, 4)).intValue();// 12345.0
		System.out.println(password);

		hp.verifyHomepageTitle(expectedTitle);
		hp.verifyHomepageUrl(expectedUrl);

		OpenClose.closeApplication();
	}
}