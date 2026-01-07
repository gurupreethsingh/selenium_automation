package automation_scripts;

public interface AutomationConstants
{
    String urlOfHomepage = "http://localhost:5173";

    String urlOfLogin = "http://localhost:5173/login";
    String urlOfRegister = "http://localhost:5173/register";
    String urlOfContact = "http://localhost:5173/contact-us";
    String urlOfAbout = "http://localhost:5173/about-us";
    String urlOfDashboard = "http://localhost:5173/dashboard";

    String rootFolder = System.getProperty("user.dir");

    String excelSheetPath = rootFolder + "project_documents.xlsx";

    String screenshotFolder = rootFolder + "/failed_screenshots";

}
