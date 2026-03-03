package generic;

public interface AutomationConstants {

	// ============================================================
	// ✅ CORE
	// ============================================================
	String BASE_URL = "http://localhost:5175";
	String ROOT_DIRECTORY = System.getProperty("user.dir");
	String EXCEL_SHEET_PATH = ROOT_DIRECTORY + "\\project_documents.xlsx";
	String FAILED_SCREENSHOT_FOLDER = ROOT_DIRECTORY + "\\failed_screenshots";

	// ============================================================
	// ✅ PUBLIC / COMMON ROUTES (STATIC)
	// ============================================================
	String URL_HOME = BASE_URL + "/";
	String URL_HOME_ALT_1 = BASE_URL + "/home";
	String URL_HOME_ALT_2 = BASE_URL + "/homepage";

	String URL_LOGIN = BASE_URL + "/login";
	String URL_REGISTER = BASE_URL + "/register";

	String URL_CONTACT = BASE_URL + "/contact";

	String URL_PRIVACY_POLICY = BASE_URL + "/privacy-policy";
	String URL_ABOUT_US = BASE_URL + "/about-us";
	String URL_CAREERS = BASE_URL + "/careers";

	String URL_ALL_BLOGS = BASE_URL + "/all-blogs";
	String URL_ADD_BLOG = BASE_URL + "/add-blog";

	String URL_PAGE_NOT_FOUND = BASE_URL + "/page-not-found";

	// ============================================================
	// ✅ ADMIN / SUPERADMIN / DASHBOARDS (STATIC)
	// ============================================================
	String URL_DASHBOARD = BASE_URL + "/dashboard";

	// ============================================================
	// ✅ BLOGS (DYNAMIC)
	// ============================================================
	String URL_SINGLE_BLOG_TEMPLATE = BASE_URL + "/single-blog/:slug/:id";
	String URL_SINGLE_BLOG_BASE = BASE_URL + "/single-blog/"; // + {slug} + "/" + {id}

	String URL_UPDATE_BLOG_TEMPLATE = BASE_URL + "/update-blog/:slug/:id";
	String URL_UPDATE_BLOG_BASE = BASE_URL + "/update-blog/"; // + {slug} + "/" + {id}

	// ============================================================
	// ✅ PROFILE (DYNAMIC)
	// ============================================================
	String URL_PROFILE_TEMPLATE = BASE_URL + "/profile/:id";
	String URL_PROFILE_BASE = BASE_URL + "/profile/"; // + {id}

	String URL_UPDATE_PROFILE_TEMPLATE = BASE_URL + "/update-profile/:id";
	String URL_UPDATE_PROFILE_BASE = BASE_URL + "/update-profile/"; // + {id}

}
