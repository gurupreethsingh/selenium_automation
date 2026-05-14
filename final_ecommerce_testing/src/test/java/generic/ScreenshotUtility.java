//package generic;
//
//import java.io.File;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import com.google.common.io.Files;
//
//public class ScreenshotUtility extends OpenClose {
//	TakesScreenshot ts = (TakesScreenshot) driver;
//
//	public void captureScreenshot() {
//		try {
//			// driver has to take the screenshot.
//
//			File ramLocation = ts.getScreenshotAs(OutputType.FILE);
//			File hardDiskLocation = new File(faliedScreeshotFolder + "\\image_name.png");
//			Files.copy(ramLocation, hardDiskLocation);
//			System.out.println("Screenshot has been stored : ");
//		} catch (Exception ex) {
//			System.out.println("Error in taking Screenshot : ");
//			ex.printStackTrace();
//		}
//	}
//}

package generic;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotUtility extends OpenClose {

	private final WebDriver driverRef;

	public ScreenshotUtility(WebDriver driver) {
		this.driverRef = driver;
	}

	public void captureScreenshot() {
		try {
			if (driverRef == null) {
				System.out.println("Error in taking Screenshot : driver is NULL");
				return;
			}

			if (!(driverRef instanceof TakesScreenshot)) {
				System.out.println("Error in taking Screenshot : driver does not support TakesScreenshot");
				return;
			}

			// ✅ create TS only at runtime (no null ts)
			TakesScreenshot ts = (TakesScreenshot) driverRef;

			File ramLocation = ts.getScreenshotAs(OutputType.FILE);

			// ✅ ensure folder exists
			File folder = new File(FAILED_SCREENSHOT_FOLDER);
			if (!folder.exists()) {
				folder.mkdirs();
			}

			// ✅ unique file name (avoid overwrite)
			String fileName = "image_" + System.currentTimeMillis() + ".png";
			File hardDiskLocation = new File(folder, fileName);

			Files.copy(ramLocation, hardDiskLocation);
			System.out.println("Screenshot has been stored : " + hardDiskLocation.getAbsolutePath());

		} catch (Exception ex) {
			System.out.println("Error in taking Screenshot : ");
			ex.printStackTrace();
		}
	}
}