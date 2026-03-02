package scripts.ai_systems_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.AiSystemsPage;

public class AS_7351_OpenAiSystemsPageUsingUrl extends OpenClose {

	@Test
	public void testOpenAiSystemsPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("AiSystemsPage", 1, 0);

		driver.get(URL_AI_SYSTEMS);

		AiSystemsPage page = new AiSystemsPage(driver);
		page.verifyAiSystemsPageTitle(expectedTitle);
	}
}
