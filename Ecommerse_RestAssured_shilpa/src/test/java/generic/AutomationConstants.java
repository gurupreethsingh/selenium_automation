package generic;

import java.io.File;

public interface AutomationConstants {
	
	
	
	public static String globalBackendRoute = "http://localhost:3010/api";
	
	String rootDirectory = System.getProperty("user.dir");
	String excelSheetPath = rootDirectory+File.separator+ "src"+File.separator+"test"+File.separator+"resources"+File.separator+  "project_documents.xlsx";
	
}
