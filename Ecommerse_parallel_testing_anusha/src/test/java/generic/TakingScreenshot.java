package generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakingScreenshot extends OpenClose
{
	
  public static void captureScreenshot(WebDriver driver)
  {
	  try
	  {
		  TakesScreenshot ts = (TakesScreenshot) driver; 
		  File ramLocation = ts.getScreenshotAs(OutputType.FILE);
		  Date d =new Date();
		  
		  String currentDate = new SimpleDateFormat("ddmmYYYY_HHmmss").format(d);
		  
		  // location in your system to store the screenshot. with name of the image and type of the image (.png, .jpg, .jpeg etc) 
		  File hdLocation = new File(failedScreenshots+ File.separator+"image_"+currentDate+".png");
		  
		  FileHandler.copy(ramLocation, hdLocation);
		  
		  System.out.println("Screenshot Stored in : "+ failedScreenshots + "folder." );
	  }
	  catch(Exception ex)
	  {
		  ex.printStackTrace();
		  System.out.println("Unable to take the screenshot.");
	  }
  }
}



// package generic;

// import java.io.File;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.nio.file.Files;
// import java.nio.file.StandardCopyOption;

// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;

// public class CaptureScreenshot implements AutomationConstants {

//     public static File takeScreenshot(WebDriver driver) {
//         File src = null;
//         File dest = null;

//         try {
//             File folder = new File(failedScreenshotsFolder);
//             if (!folder.exists()) 
//             {
//                 folder.mkdirs();
//             }

//             String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
//             String fileName = "screenshot_" + stamp + ".png";

//             src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//             dest = new File(folder, fileName);
//             Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

//             return dest; // success

//         } catch (Exception ex) {
//             ex.printStackTrace();
//             System.out.println("Could not capture or save screenshot.");
//             return null;
//         } finally {
//             // Clean up temp file if present
//             if (src != null && src.exists()) {
//                 try { src.delete(); } catch (Exception ignore) {}
//             }
//         }
//     }
// }
