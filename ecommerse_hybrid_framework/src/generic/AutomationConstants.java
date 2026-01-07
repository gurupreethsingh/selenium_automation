package generic;

import org.openqa.selenium.WebDriver;

public interface AutomationConstants 
{
	String urlOfApplication = "http://localhost:5173";
	
    String urlOfHomepage = "http://localhost:5173/";
    
    String rootFolder = System.getProperty("user.dir");
    
    String excelSheetPath = rootFolder + "project_documents.xlsx";
    
    String screenshotFolder = rootFolder + "/failed_screehshots";
    


}
