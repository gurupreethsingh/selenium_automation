package scripts.edit_attendance_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.EditAttendancePage;

public class AS_7415_OpenEditAttendancePageUsingUrl extends OpenClose {

	@Test
	public void testOpenEditAttendancePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("EditAttendancePage", 1, 0);

		driver.get(URL_EDIT_ATTENDANCE_BASE + "000000000000000000000000");

		EditAttendancePage page = new EditAttendancePage(driver);
		page.verifyEditAttendancePageTitle(expectedTitle);
	}
}
