package scripts.traceability_matrix_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.TraceabilityMatrixPage;

public class AS_7386_OpenTraceabilityMatrixPageUsingUrl extends OpenClose {

	@Test
	public void testOpenTraceabilityMatrixPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("TraceabilityMatrixPage", 1, 0);

		driver.get(URL_SINGLE_PROJECT_BASE + "69a58f3a326ce82d2a693069" + "/traceability-matrix");

		TraceabilityMatrixPage page = new TraceabilityMatrixPage(driver);
		page.verifyTraceabilityMatrixPageTitle(expectedTitle);
	}
}
