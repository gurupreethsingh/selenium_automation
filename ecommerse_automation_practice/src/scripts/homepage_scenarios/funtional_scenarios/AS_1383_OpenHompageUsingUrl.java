package scripts.homepage_scenarios.funtional_scenarios;

import generic.Excel;
import generic.OpenClose;
import pom.Homepage;

public class AS_1383_OpenHompageUsingUrl extends OpenClose {
	public static void main(String[] args) throws InterruptedException {

		OpenClose.openApplication();

		Homepage hp = new Homepage(driver);

		String expectedTitle = Excel.getData("Homepage", 1, 0);
		System.out.println("Title from excel sheet : " + expectedTitle);
		String expectedUrl = Excel.getData("Homepage", 1, 1);
		System.out.println("Url from excel sheet : " + expectedUrl);

		hp.verifyHomepageTitle(expectedTitle);
		hp.verifyHomepageUrl(expectedUrl);

		OpenClose.closeApplication();
	}
}