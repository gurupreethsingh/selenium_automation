package routes;

public class CategoryRoutes {

	// Base URL
	public static final String BASE_URL = "http://localhost:3010";

	// POST - Add Category (with image + auth)
	public static final String POST_ADD_CATEGORY_ROUTE = BASE_URL + "/api/add-category";

	// GET - All Categories
	public static final String GET_ALL_CATEGORIES_ROUTE = BASE_URL + "/api/all-categories";

	// GET - Category Count
	public static final String GET_CATEGORY_COUNT_ROUTE = BASE_URL + "/api/category-count";

	// GET - Category Product Counts
	public static final String GET_CATEGORY_PRODUCT_COUNTS_ROUTE = BASE_URL + "/api/category-product-counts";

	// GET - Single Category (Dynamic ID)
	public static final String GET_SINGLE_CATEGORY_ROUTE = BASE_URL + "/api/single-category/{id}";

	// PUT - Update Category (Dynamic ID + image + auth)
	public static final String UPDATE_CATEGORY_ROUTE = BASE_URL + "/api/update-category/{id}";

	// DELETE - Delete Category (Dynamic ID + auth)
	public static final String DELETE_CATEGORY_ROUTE = BASE_URL + "/api/delete-category/{id}";

}