package generic;

public interface AutomationConstants {
	// all the variables are automatically going to become final and public
	String urlOfApplication = "http://localhost:5173/";
	String urlOfApplication1 = "http://localhost:5173/home";
	String urlOfApplication2 = "http://localhost:5173/homepage";
	String urlOfSearchProductsPage = "http://localhost:5173/search-products?query=samsung";
	String rootDirectory = System.getProperty("user.dir");
	String excelSheetPath = rootDirectory + "\\project_documents.xlsx";
	String faliedScreeshotFolder = rootDirectory + "\\failed_screenshots";

}
