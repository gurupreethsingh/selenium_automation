package endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.CategoryRoutes;

public class CategoryEndpoints {
	public static Response getAllCategories() {
		Response response = null;
		try {
			// "given" condition is that, "when" i try to "get" all categories using
			// CategoryRoutes,.GET_ALL_CATEGORIES_ROUTE, it should fetch me all the
			// catgegories
			response = given().when().get(CategoryRoutes.GET_ALL_CATEGORIES_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public static Response getSingleCategoryById(String categoryId) {
		Response response = null;
		try {
			// "given" i give paremeter as categoryID, when i use
			// CategoryRoutes.GET_SINGLE_CATEGORY_ROUTE
			response = given().pathParam("id", categoryId).when().get(CategoryRoutes.GET_SINGLE_CATEGORY_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

	public static Response deleteCategoryById(String token, String categoryId) {
		Response response = null;
		try {
			response = given().header("Authorization", "Bearer " + token).pathParam("id", categoryId).when()
					.delete(CategoryRoutes.DELETE_CATEGORY_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public static Response updateCategoryById(String token, String categoryId, String categoryName,
			HashMap<String, Object> hp) {
		Response response = null;
		try {
			response = given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(hp)
					.pathParam("id", categoryId).when().put(CategoryRoutes.UPDATE_CATEGORY_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public static Response addCategory(String token, String categoryName, File categoryImage) {
		Response response = null;
		try {
			response = given().header("Authorization", "Bearer " + token).multiPart("category_name", categoryName)
					.multiPart("category_image", categoryImage).when().post(CategoryRoutes.POST_ADD_CATEGORY_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public static Response getCategoryCount() {
		Response response = null;
		try {
			// "given" condition is that, "when" i try to "get" category count by using
			// CategoryRoutes.GET_CATEGOTY_COUNT_ROUTE
			response = given().when().get(CategoryRoutes.GET_CATEGORY_COUNT_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public static Response getCategoryProductsCounts() {
		Response response = null;
		try {
			// "given" condition is that, "when" i try to "get" category products count by
			// using
			// CategoryRoutes.GET_CATEGOTY_COUNT_ROUTE
			response = given().when().get(CategoryRoutes.GET_CATEGORY_PRODUCT_COUNTS_ROUTE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

}
