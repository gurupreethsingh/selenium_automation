package scripts.qa_automation_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.QaAutomationPage;

public class AS_7354_OpenQaAutomationPageUsingUrl extends OpenClose {

	@Test
	public void testOpenQaAutomationPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("QaAutomationPage", 1, 0);

		driver.get(URL_QA_AUTOMATION);

		QaAutomationPage page = new QaAutomationPage(driver);
		page.verifyQaAutomationPageTitle(expectedTitle);
	}
}
