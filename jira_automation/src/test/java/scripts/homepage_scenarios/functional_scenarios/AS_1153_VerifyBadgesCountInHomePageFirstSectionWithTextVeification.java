package scripts.homepage_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.HomePage;

public class AS_1153_VerifyBadgesCountInHomePageFirstSectionWithTextVeification extends OpenClose {
	@Test
	public void testVerifyBadgesCountInHomePageFirstSectionWithTextVeification() throws IOException {
		// open homepage
		HomePage hp = new HomePage(driver);
		String expectedHomePageTitle = (String) Excel.getData("HomePage", 1, 0);
		hp.verifyHomePageTitle(expectedHomePageTitle);
		// find the first section in homepage.
		// verify the total count of badges in first section.
		int badgeCount = hp.getBadgesCount();
		System.out.println("total badges found " + badgeCount);

		// verify the text of all the 4 badges.
		hp.verifyTextOfFirstBadge();
		hp.verifyTextOfSecondBadge();
		hp.verifyTextOfThirdBadge();
		hp.verifyTextOfFourthBadge();
	}
}
