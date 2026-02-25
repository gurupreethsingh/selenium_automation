package scripts.homepage_scenarios.funtional_scenarios;

import generic.OpenClose;
import pom.Homepage;

public class As_003_FetchAllLinksFromHomepage extends OpenClose {

	public static void main(String[] args) throws InterruptedException {

		OpenClose.openApplication();
		String expectedHomepageTitle = "Home | ECODERS";
		Homepage hp = new Homepage(driver);
		hp.verifyHomepageTitle(expectedHomepageTitle);
		hp.findAllLinksInHomepageAndPrintTextOfLinks();
		OpenClose.closeApplication();

	}
}
