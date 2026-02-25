package scripts.homepage_scenarios.funtional_scenarios;

import org.openqa.selenium.By;

import generic.AllVerifications;
import generic.OpenClose;

public class AS_O7_FindTotalCountOfBrandsInBrandSectionInHomapgeAndPrintAllBrandNames extends OpenClose {

	public static void main(String[] args) throws InterruptedException {
		OpenClose.openApplication();
		String expectedTitle = "Home | ECODERS";
		AllVerifications.verifyTitleOfWebpage(driver, expectedTitle);

		int totalExpectedCount = 117;

		AllVerifications.verifyTotalElementsCount(driver, totalExpectedCount,
				By.cssSelector("div.flex.items-center.w-max:first-child>button"));

		AllVerifications.printAllBrandNamesInHomepage(driver, totalExpectedCount,
				By.cssSelector(".brandViewport .brandTrack button[title]"));

		OpenClose.closeApplication();
	}
}
