package scripts.single_attendance_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.SingleAttendancePage;

public class AS_7414_OpenSingleAttendancePageUsingUrl extends OpenClose {

	@Test
	public void testOpenSingleAttendancePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("SingleAttendancePage", 1, 0);

		driver.get(URL_GET_SINGLE_ATTENDANCE_BASE + "000000000000000000000000");

		SingleAttendancePage page = new SingleAttendancePage(driver);
		page.verifySingleAttendancePageTitle(expectedTitle);
	}
}
