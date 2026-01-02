//package generic;
//
//import java.io.File;
//
//public interface AutomationConstants 
//{
//    String rootFolder = System.getProperty("user.dir");
//    String excelSheetPath   = rootFolder + File.separator + "project_documents.xlsx";
//    String failedScreenshots = rootFolder + File.separator + "failedScreenshots";
//    String urlOfApplication  = "http://localhost:5173";
//    String url2OfApplication = "http://localhost:5173/";
//    String url3OfApplication = "http://localhost:5173/home";

		//  // first mention what or where is the rootDirectory of the project. 
//		String rootDirectory = System.getProperty("user.dir");
	//	
//		// mention where is the excel sheet present. 
	//	String excelSheetPath = rootDirectory+ File.separator +"project_documents.xlsx";
	//	
//		// mention failed screenshot folder path. 
//		String failedScreenshots = rootDirectory + File.separator +"failedScreenshots";
	    
//		 String URL_OF_APPLICATION = "http://localhost:5173";
	    // ========= Common / Public =========
//	    String PATH_HOME                = "/";
//	    String PATH_HOME_ALIAS1         = "/home";
//	    String PATH_HOME_ALIAS2         = "/homepage";
//	    String PATH_CONTACT_US          = "/contact-us";
//	    String PATH_ABOUT_US            = "/about-us";
//	    String PATH_LOGIN               = "/login";
//	    String PATH_REGISTER            = "/register";
//	    String PATH_PAGE_NOT_FOUND      = "/page-not-found";
//
//	    String URL_HOME                 = URL_OF_APPLICATION + PATH_HOME;  // localhost:5173/
//	    String URL_HOME_ALIAS1          = URL_OF_APPLICATION + PATH_HOME_ALIAS1;  // localhost:5173/home
//	    String URL_HOME_ALIAS2          = URL_OF_APPLICATION + PATH_HOME_ALIAS2;
//	    String URL_CONTACT_US           = URL_OF_APPLICATION + PATH_CONTACT_US;
//	    String URL_ABOUT_US             = URL_OF_APPLICATION + PATH_ABOUT_US;
//	    String URL_LOGIN                = URL_OF_APPLICATION + PATH_LOGIN;
//	    String URL_REGISTER             = URL_OF_APPLICATION + PATH_REGISTER;
//	    String URL_PAGE_NOT_FOUND       = URL_OF_APPLICATION + PATH_PAGE_NOT_FOUND;
//	    
//	    String PATH_SHOP                = "/shop";
//	    String URL_SHOP                 = URL_OF_APPLICATION + PATH_SHOP; 

//	}

// new code. 

 package generic;

 import java.io.File;

 public interface AutomationConstants 
 {
 	String rootDirectory = System.getProperty("user.dir");
	
 	String excelSheetPath = rootDirectory+File.separator+"project_documents.xlsx";
	
 	String failedScreenshots = rootDirectory + File.separator + "failedScreenshots";
	 
 	String URL_OF_APPLICATION = "http://localhost:5173";

// 		    // ========= Common / Public =========
 		    String PATH_HOME                = "/";
 		    String PATH_HOME_ALIAS1         = "/home";
 		    String PATH_HOME_ALIAS2         = "/homepage";
 		    String PATH_CONTACT_US          = "/contact-us";
 		    String PATH_ABOUT_US            = "/about-us";
 		    String PATH_LOGIN               = "/login";
 		    String PATH_REGISTER            = "/register";
 		    String PATH_PAGE_NOT_FOUND      = "/page-not-found";

 		    String URL_HOME                 = URL_OF_APPLICATION + PATH_HOME;  // localhost:5173/
 		    String URL_HOME_ALIAS1          = URL_OF_APPLICATION + PATH_HOME_ALIAS1;  // localhost:5173/home
 		    String URL_HOME_ALIAS2          = URL_OF_APPLICATION + PATH_HOME_ALIAS2;  // localhost:5173/homepage
 		    String URL_CONTACT_US           = URL_OF_APPLICATION + PATH_CONTACT_US;
 		    String URL_ABOUT_US             = URL_OF_APPLICATION + PATH_ABOUT_US;
 		    String URL_LOGIN                = URL_OF_APPLICATION + PATH_LOGIN;
 		    String URL_REGISTER             = URL_OF_APPLICATION + PATH_REGISTER;
 		    String URL_PAGE_NOT_FOUND       = URL_OF_APPLICATION + PATH_PAGE_NOT_FOUND;

//		    // ========= Auth / Account =========
		    String PATH_FORGOT_PASSWORD     = "/forgot-password";
		    String PATH_RESET_PASSWORD      = "/reset-password";
		    String PATH_PROFILE_BY_ID_TPL   = "/profile/%s";          // :id
		    String PATH_UPDATE_PROFILE_TPL  = "/update-profile/%s";    // :id
		    String PATH_DASHBOARD           = "/dashboard";
		//
		    String URL_FORGOT_PASSWORD      = URL_OF_APPLICATION + PATH_FORGOT_PASSWORD;
		    String URL_RESET_PASSWORD       = URL_OF_APPLICATION + PATH_RESET_PASSWORD;
		    String URL_PROFILE_BY_ID_TPL    = URL_OF_APPLICATION + PATH_PROFILE_BY_ID_TPL;
		    String URL_UPDATE_PROFILE_TPL   = URL_OF_APPLICATION + PATH_UPDATE_PROFILE_TPL;
		    String URL_DASHBOARD            = URL_OF_APPLICATION + PATH_DASHBOARD;
		//
//		    // ========= Roles / Dashboards =========
		    String PATH_SUPERADMIN_DASHBOARD    = "/superadmin-dashboard";
		    String PATH_ADMIN_DASHBOARD         = "/admin-dashboard";
		    String PATH_EMPLOYEE_DASHBOARD      = "/employee-dashboard";
		    String PATH_DELIVERY_AGENT_DASHBOARD= "/delivery-agent-dashboard";
		    String PATH_HR_DASHBOARD            = "/hr-dashboard";
		    String PATH_OUTLET_DASHBOARD        = "/outlet-dashboard";
		    String PATH_VENDOR_DASHBOARD        = "/vendor-dashboard";
		    String PATH_VENDOR_DASHBOARD_TPL    = "/vendor-dashboard/%s"; // :vendorId
		    String PATH_OUTLET_DASHBOARD_TPL    = "/outlet-dashboard/%s"; // :outletId
		//
		    String URL_SUPERADMIN_DASHBOARD     = URL_OF_APPLICATION + PATH_SUPERADMIN_DASHBOARD;
		    String URL_ADMIN_DASHBOARD          = URL_OF_APPLICATION + PATH_ADMIN_DASHBOARD;
		    String URL_EMPLOYEE_DASHBOARD       = URL_OF_APPLICATION + PATH_EMPLOYEE_DASHBOARD;
		    String URL_DELIVERY_AGENT_DASHBOARD = URL_OF_APPLICATION + PATH_DELIVERY_AGENT_DASHBOARD;
		    String URL_HR_DASHBOARD             = URL_OF_APPLICATION + PATH_HR_DASHBOARD;
		    String URL_OUTLET_DASHBOARD         = URL_OF_APPLICATION + PATH_OUTLET_DASHBOARD;
		    String URL_VENDOR_DASHBOARD         = URL_OF_APPLICATION + PATH_VENDOR_DASHBOARD;
		    String URL_VENDOR_DASHBOARD_TPL     = URL_OF_APPLICATION + PATH_VENDOR_DASHBOARD_TPL;
		    String URL_OUTLET_DASHBOARD_TPL     = URL_OF_APPLICATION + PATH_OUTLET_DASHBOARD_TPL;
		//
//		    // ========= Contact (admin) =========
		    String PATH_ALL_MESSAGES        = "/all-messages";
		    String PATH_REPLY_MESSAGE_TPL   = "/reply-message/%s";   // :id
		    String PATH_ALL_REPLIES         = "/all-replies";
		//
		    String URL_ALL_MESSAGES         = URL_OF_APPLICATION + PATH_ALL_MESSAGES;
		    String URL_REPLY_MESSAGE_TPL    = URL_OF_APPLICATION + PATH_REPLY_MESSAGE_TPL;
		    String URL_ALL_REPLIES          = URL_OF_APPLICATION + PATH_ALL_REPLIES;
		//
//		    // ========= Blog =========
		    String PATH_ALL_BLOGS           = "/all-blogs";
		    String PATH_SINGLE_BLOG_TPL     = "/single-blog/%s";     // :id
		//
		    String URL_ALL_BLOGS            = URL_OF_APPLICATION + PATH_ALL_BLOGS;
		    String URL_SINGLE_BLOG_TPL      = URL_OF_APPLICATION + PATH_SINGLE_BLOG_TPL;
		//
//		    // ========= Shop / Product (public shop) =========
		    String PATH_SHOP                = "/shop";
		    String PATH_SINGLE_PRODUCT_TPL  = "/single-product/%s";  // :id
		    String PATH_SEARCH_PRODUCTS     = "/search-products";
		//
		    String URL_SHOP                 = URL_OF_APPLICATION + PATH_SHOP;
		    String URL_SINGLE_PRODUCT_TPL   = URL_OF_APPLICATION + PATH_SINGLE_PRODUCT_TPL;
		    String URL_SEARCH_PRODUCTS      = URL_OF_APPLICATION + PATH_SEARCH_PRODUCTS;
		//
//		    // ========= Cart / Orders =========
		    String PATH_CART                = "/cart";
		    String PATH_CHECKOUT            = "/checkout";
		    String PATH_MY_ORDERS           = "/my-orders";
		    String PATH_THANK_YOU           = "/thank-you";
		    String PATH_WISHLIST            = "/wishlist";
		//
		    String URL_CART                 = URL_OF_APPLICATION + PATH_CART;
		    String URL_CHECKOUT             = URL_OF_APPLICATION + PATH_CHECKOUT;
		    String URL_MY_ORDERS            = URL_OF_APPLICATION + PATH_MY_ORDERS;
		    String URL_THANK_YOU            = URL_OF_APPLICATION + PATH_THANK_YOU;
		    String URL_WISHLIST             = URL_OF_APPLICATION + PATH_WISHLIST;
		//
//		    // ========= Category / Subcategory (admin) =========
		    String PATH_ADD_CATEGORY            = "/add-category";
		    String PATH_ALL_CATEGORIES         = "/all-categories";
		    String PATH_SINGLE_CATEGORY_TPL    = "/single-category/%s";            // :id
		    String PATH_CATEGORY_ALL_PRODUCTS_TPL = "/single-category-all-products/%s"; // :id
		//
		    String PATH_ADD_SUB_CATEGORY       = "/add-sub-category";
		    String PATH_ALL_SUB_CATEGORIES     = "/all-sub-categories";
		    String PATH_SINGLE_SUBCATEGORY_TPL = "/single-subcategory/%s";         // :id
		//
		    String URL_ADD_CATEGORY                = URL_OF_APPLICATION + PATH_ADD_CATEGORY;
		    String URL_ALL_CATEGORIES              = URL_OF_APPLICATION + PATH_ALL_CATEGORIES;
		    String URL_SINGLE_CATEGORY_TPL         = URL_OF_APPLICATION + PATH_SINGLE_CATEGORY_TPL;
		    String URL_CATEGORY_ALL_PRODUCTS_TPL   = URL_OF_APPLICATION + PATH_CATEGORY_ALL_PRODUCTS_TPL;
		//
		    String URL_ADD_SUB_CATEGORY            = URL_OF_APPLICATION + PATH_ADD_SUB_CATEGORY;
		    String URL_ALL_SUB_CATEGORIES          = URL_OF_APPLICATION + PATH_ALL_SUB_CATEGORIES;
		    String URL_SINGLE_SUBCATEGORY_TPL      = URL_OF_APPLICATION + PATH_SINGLE_SUBCATEGORY_TPL;
		//
//		    // ========= Vendor (admin) =========
		    String PATH_ADD_VENDOR           = "/add-vendor";
		    String PATH_ALL_VENDORS         = "/all-vendors";
		    String PATH_SINGLE_VENDOR_TPL   = "/single-vendor/%s";   // :vendorId
		
		    String URL_ADD_VENDOR           = URL_OF_APPLICATION + PATH_ADD_VENDOR;
		    String URL_ALL_VENDORS          = URL_OF_APPLICATION + PATH_ALL_VENDORS;
		    String URL_SINGLE_VENDOR_TPL    = URL_OF_APPLICATION + PATH_SINGLE_VENDOR_TPL;
		
//		    // ========= Outlet (admin) =========
		    String PATH_ADD_OUTLET          = "/add-outlet";
		    String PATH_ALL_OUTLETS         = "/all-outlets";
		    String PATH_SINGLE_OUTLET_TPL   = "/single-outlet/%s";   // :outletId
		//
		    String URL_ADD_OUTLET           = URL_OF_APPLICATION + PATH_ADD_OUTLET;
		    String URL_ALL_OUTLETS          = URL_OF_APPLICATION + PATH_ALL_OUTLETS;
		    String URL_SINGLE_OUTLET_TPL    = URL_OF_APPLICATION + PATH_SINGLE_OUTLET_TPL;
		
//		    // ========= Product (admin) =========
		    String PATH_ADD_PRODUCT             = "/add-product";
		    String PATH_ALL_ADDED_PRODUCTS      = "/all-added-products";
		    String PATH_SINGLE_ADDED_PRODUCT_TPL= "/single-added-product/%s"; // :id
		
		    String URL_ADD_PRODUCT              = URL_OF_APPLICATION + PATH_ADD_PRODUCT;
		    String URL_ALL_ADDED_PRODUCTS       = URL_OF_APPLICATION + PATH_ALL_ADDED_PRODUCTS;
		    String URL_SINGLE_ADDED_PRODUCT_TPL = URL_OF_APPLICATION + PATH_SINGLE_ADDED_PRODUCT_TPL;
		
//		    // ========= Fallback =========
		    String PATH_WILDCARD_404        = "/*";
		    String URL_WILDCARD_404         = URL_OF_APPLICATION + "/" + "*"; // just a marker; not for direct navigation
		    
}
