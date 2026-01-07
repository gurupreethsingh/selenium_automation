package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshot implements AutomationConstants {
    
    public static void getScreenshot(WebDriver driver) {
        try {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            // Format the timestamp
            String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

            // Create the folder if it doesn't exist
            File screenshotDir = new File(screenshotFolder);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            // Destination file path
            File destFile = new File(screenshotFolder + File.separator + "screenshot_" + timestamp + ".jpg");

            // Copy screenshot to destination
            FileHandler.copy(srcFile, destFile);
            
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
