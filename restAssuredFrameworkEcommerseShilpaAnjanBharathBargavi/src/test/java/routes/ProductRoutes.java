package routes;

public class ProductRoutes {

	// Base URL
	public static final String BASE_URL = "http://localhost:3010/api";

	// =========================================================
	// CREATE
	// =========================================================

	// POST - Add Product
	// Login Required? -> yes
	// Token Required? -> yes
	// Role Required? -> yes (superadmin)
	// Note: multipart/form-data route // image upload
	// Files supported:
	// 1. product_image -> max 1
	// 2. all_product_images -> max 5
	public static final String POST_ADD_PRODUCT_ROUTE = BASE_URL + "/add-product";

	// =========================================================
	// READ
	// =========================================================

	// GET - All Added Products
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String GET_ALL_ADDED_PRODUCTS_ROUTE = BASE_URL + "/all-added-products";

	// GET - Single Product by ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String GET_SINGLE_PRODUCT_BY_ID_ROUTE = BASE_URL + "/get-single-added-product-by-id/{id}";

	// GET - Products by Category ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String GET_PRODUCTS_BY_CATEGORY_ROUTE = BASE_URL + "/get-products-by-category/{categoryId}";

	// GET - Products by Subcategory ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String GET_PRODUCTS_BY_SUBCATEGORY_ROUTE = BASE_URL
			+ "/get-products-by-subcategory/{subCategoryId}";

	// GET - Products Sorted
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String GET_PRODUCTS_SORTED_ROUTE = BASE_URL + "/get-products-sorted";

	// =========================================================
	// PERSONALIZED / RECOMMENDATION
	// =========================================================

	// GET - Recommended Products from History Categories
	// Login Required? -> Yes
	// Token Required? -> Yes
	// Role Required? -> Logged-in user
	// Middleware used in MERN route file -> verifyToken
	public static final String GET_RECOMMENDED_PRODUCTS_FROM_HISTORY_CATEGORIES_ROUTE = BASE_URL
			+ "/recommended/history-categories";

	// GET - Recommended Products from History Brands
	// Login Required? -> Yes
	// Token Required? -> Yes
	// Role Required? -> Logged-in user
	// Middleware used in MERN route file -> verifyToken
	public static final String GET_RECOMMENDED_PRODUCTS_FROM_HISTORY_BRANDS_ROUTE = BASE_URL
			+ "/recommended/history-brands";

	// =========================================================
	// UPDATE
	// =========================================================

	// PUT - Update Product by ID
	// Login Required? -> No (public in current routes file)
	// Token Required? -> No
	// Role Required? -> No
	// Note: multipart/form-data route
	// Files supported:
	// 1. product_image -> max 1
	// 2. all_product_images -> max 5
	public static final String UPDATE_PRODUCT_BY_ID_ROUTE = BASE_URL + "/update-product/{id}";

	// PUT - Add One Gallery Image by Product ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	// Note: multipart/form-data route
	// File supported:
	// 1. gallery_image -> max 1
	public static final String ADD_ONE_GALLERY_IMAGE_ROUTE = BASE_URL + "/add-one-gallery-image/{id}";

	// PUT - Remove One Gallery Image by Product ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String REMOVE_ONE_GALLERY_IMAGE_ROUTE = BASE_URL + "/remove-one-gallery-image/{id}";

	// =========================================================
	// DELETE
	// =========================================================

	// DELETE - Delete Product by ID
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String DELETE_PRODUCT_BY_ID_ROUTE = BASE_URL + "/delete-product/{id}";

	// =========================================================
	// COUNTS
	// =========================================================

	// GET - Count All Products
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_ALL_PRODUCTS_ROUTE = BASE_URL + "/count-all-products";

	// GET - Count Products by Category
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_PRODUCTS_BY_CATEGORY_ROUTE = BASE_URL + "/count-products-by-category";

	// GET - Count Products by Subcategory
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_PRODUCTS_BY_SUBCATEGORY_ROUTE = BASE_URL + "/count-products-by-subcategory";

	// GET - Count Products by Vendor
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_PRODUCTS_BY_VENDOR_ROUTE = BASE_URL + "/count-products-by-vendor";

	// GET - Count Products by Status
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_PRODUCTS_BY_STATUS_ROUTE = BASE_URL + "/count-products-by-status";

	// GET - Count Products by Section
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String COUNT_PRODUCTS_BY_SECTION_ROUTE = BASE_URL + "/count-products-by-section";

	// =========================================================
	// SEARCH
	// =========================================================

	// GET - Search Products
	// Login Required? -> No
	// Token Required? -> No
	// Role Required? -> No
	public static final String SEARCH_PRODUCTS_ROUTE = BASE_URL + "/search-products";

}