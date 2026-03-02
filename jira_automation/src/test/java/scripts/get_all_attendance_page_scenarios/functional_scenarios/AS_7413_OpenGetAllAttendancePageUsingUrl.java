package scripts.get_all_attendance_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.GetAllAttendancePage;

public class AS_7413_OpenGetAllAttendancePageUsingUrl extends OpenClose {

	@Test
	public void testOpenGetAllAttendancePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("GetAllAttendancePage", 1, 0);

		driver.get(URL_VIEW_ALL_ATTENDANCE);

		GetAllAttendancePage page = new GetAllAttendancePage(driver);
		page.verifyGetAllAttendancePageTitle(expectedTitle);
	}
}
