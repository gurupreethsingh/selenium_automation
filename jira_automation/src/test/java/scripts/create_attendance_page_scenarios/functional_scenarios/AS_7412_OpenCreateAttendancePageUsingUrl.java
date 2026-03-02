package scripts.create_attendance_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.CreateAttendancePage;

public class AS_7412_OpenCreateAttendancePageUsingUrl extends OpenClose {

	@Test
	public void testOpenCreateAttendancePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("CreateAttendancePage", 1, 0);

		driver.get(URL_CREATE_ATTENDANCE);

		CreateAttendancePage page = new CreateAttendancePage(driver);
		page.verifyCreateAttendancePageTitle(expectedTitle);
	}
}
