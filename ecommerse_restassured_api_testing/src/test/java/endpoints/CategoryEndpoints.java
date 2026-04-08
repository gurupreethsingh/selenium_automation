package endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.CategoryRoutes;

public class CategoryEndpoints {

	// =========================================
	// PUBLIC ROUTES
	// =========================================

	public static Response getAllCategories() {
		return given().when().get(CategoryRoutes.GET_ALL_CATEGORIES);
	}

	public static Response getCategoryCount() {
		return given().when().get(CategoryRoutes.GET_CATEGORY_COUNT);
	}

	public static Response getCategoryProductCounts() {
		return given().when().get(CategoryRoutes.GET_CATEGORY_PRODUCT_COUNTS);
	}

	public static Response getSingleCategory(String categoryId) {
		return given().pathParam("id", categoryId).when().get(CategoryRoutes.GET_SINGLE_CATEGORY);
	}

	// =========================================
	// PRIVATE ROUTES - SUPERADMIN ONLY
	// =========================================

	public static Response addCategory(String token, String categoryName, File categoryImage) {
		return given().header("Authorization", "Bearer " + token).multiPart("category_name", categoryName)
				.multiPart("category_image", categoryImage).when().post(CategoryRoutes.ADD_CATEGORY);
	}

	public static Response addCategoryWithoutImage(String token, String categoryName) {
		return given().header("Authorization", "Bearer " + token).multiPart("category_name", categoryName).when()
				.post(CategoryRoutes.ADD_CATEGORY);
	}

	public static Response updateCategory(String token, String categoryId, String categoryName, File categoryImage) {
		return given().header("Authorization", "Bearer " + token).pathParam("id", categoryId)
				.multiPart("category_name", categoryName).multiPart("category_image", categoryImage).when()
				.put(CategoryRoutes.UPDATE_CATEGORY);
	}

	public static Response updateCategoryWithoutImage(String token, String categoryId, String categoryName) {
		return given().header("Authorization", "Bearer " + token).pathParam("id", categoryId)
				.multiPart("category_name", categoryName).when().put(CategoryRoutes.UPDATE_CATEGORY);
	}

	public static Response deleteCategory(String token, String categoryId) {
		return given().header("Authorization", "Bearer " + token).pathParam("id", categoryId).when()
				.delete(CategoryRoutes.DELETE_CATEGORY);
	}

	// =========================================
	// NEGATIVE / AUTH CHECK METHODS
	// =========================================

	public static Response addCategoryWithoutToken(String categoryName, File categoryImage) {
		return given().multiPart("category_name", categoryName).multiPart("category_image", categoryImage).when()
				.post(CategoryRoutes.ADD_CATEGORY);
	}

	public static Response updateCategoryWithoutToken(String categoryId, String categoryName, File categoryImage) {
		return given().pathParam("id", categoryId).multiPart("category_name", categoryName)
				.multiPart("category_image", categoryImage).when().put(CategoryRoutes.UPDATE_CATEGORY);
	}

	public static Response deleteCategoryWithoutToken(String categoryId) {
		return given().pathParam("id", categoryId).when().delete(CategoryRoutes.DELETE_CATEGORY);
	}

	// =========================================
	// OPTIONAL GENERIC JSON METHODS
	// useful if your backend also accepts JSON body
	// =========================================

	public static Response addCategoryWithJson(String token, Map<String, Object> payload) {
		return given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(payload).when()
				.post(CategoryRoutes.ADD_CATEGORY);
	}

	public static Response updateCategoryWithJson(String token, String categoryId, Map<String, Object> payload) {
		return given().header("Authorization", "Bearer " + token).pathParam("id", categoryId)
				.contentType(ContentType.JSON).body(payload).when().put(CategoryRoutes.UPDATE_CATEGORY);
	}
}