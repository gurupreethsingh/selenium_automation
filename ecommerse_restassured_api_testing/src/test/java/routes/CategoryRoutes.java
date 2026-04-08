package routes;

public class CategoryRoutes {

	// -----------------------------------
	// BASE URL
	// -----------------------------------
	public static final String BASE_URL = "http://localhost:3010";

	// -----------------------------------
	// CATEGORY ROUTES
	// -----------------------------------

	// Add Category (POST)
	public static final String ADD_CATEGORY = BASE_URL + "/api/add-category";

	// Get All Categories (GET)
	public static final String GET_ALL_CATEGORIES = BASE_URL + "/api/all-categories";

	// Get Category Count (GET)
	public static final String GET_CATEGORY_COUNT = BASE_URL + "/api/category-count";

	// Get Category Product Counts (GET)
	public static final String GET_CATEGORY_PRODUCT_COUNTS = BASE_URL + "/api/category-product-counts";

	// Get Single Category (GET)
	public static final String GET_SINGLE_CATEGORY = BASE_URL + "/api/single-category/{id}";

	// Update Category (PUT)
	public static final String UPDATE_CATEGORY = BASE_URL + "/api/update-category/{id}";

	// Delete Category (DELETE)
	public static final String DELETE_CATEGORY = BASE_URL + "/api/delete-category/{id}";

}