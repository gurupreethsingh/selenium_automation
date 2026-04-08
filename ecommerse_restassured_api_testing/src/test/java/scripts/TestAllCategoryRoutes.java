package scripts;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import endpoints.CategoryEndpoints;
import endpoints.LoginEndpoints;
import io.restassured.response.Response;

public class TestAllCategoryRoutes {

	// =========================================
	// TEST 1 - GET ALL CATEGORIES
	// =========================================
//	@Test(priority = 1)
//	public void testGetAllCategories() {
//
//		Response response = CategoryEndpoints.getAllCategories();
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for get all categories");
//
//		SoftAssert soft = new SoftAssert();
//
//		soft.assertTrue(response.getBody().asString().contains("category_name"),
//				"Response does not contain category_name");
//
//		soft.assertTrue(response.jsonPath().getList("$").size() > 0, "Category list should not be empty");
//
//		soft.assertAll();
//	}
//
//	// =========================================
//	// TEST 2 - GET SINGLE CATEGORY BY ID
//	// =========================================
//	String singleCategoryId = "6809faa61b1caf275f228fba"; // Toys
//
//	@Test(priority = 2)
//	public void testGetSingleCategoryById() {
//
//		Assert.assertNotNull(singleCategoryId, "Category ID should not be null");
//
//		Response response = CategoryEndpoints.getSingleCategory(singleCategoryId);
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for get single category");
//
//		SoftAssert soft = new SoftAssert();
//
//		soft.assertEquals(response.jsonPath().getString("_id"), singleCategoryId, "Category ID mismatch");
//		soft.assertNotNull(response.jsonPath().getString("category_name"), "category_name should not be null");
//		soft.assertTrue(response.getBody().asString().contains("category_image"),
//				"Response does not contain category_image");
//
//		soft.assertAll();
//	}
//
//	// =========================================
//	// TEST 3 - GET TOTAL CATEGORY COUNT
//	// =========================================
//	@Test(priority = 3)
//	public void testGetCategoryCount() {
//
//		Response response = CategoryEndpoints.getCategoryCount();
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for get category count");
//
//		SoftAssert soft = new SoftAssert();
//
//		// Try common possible response keys
//		Integer count = null;
//
//		try {
//			count = response.jsonPath().getInt("count");
//		} catch (Exception e) {
//			// ignore
//		}
//
//		if (count == null || count == 0) {
//			try {
//				count = response.jsonPath().getInt("categoryCount");
//			} catch (Exception e) {
//				// ignore
//			}
//		}
//
//		if (count == null || count == 0) {
//			try {
//				count = response.jsonPath().getInt("totalCategories");
//			} catch (Exception e) {
//				// ignore
//			}
//		}
//
//		soft.assertNotNull(count, "Category count key was not found in response");
//		if (count != null) {
//			soft.assertTrue(count >= 0, "Category count should be zero or more");
//			System.out.println("Total Category Count: " + count);
//		}
//
//		soft.assertAll();
//	}
//
//	// =========================================
//	// TEST 4 - GET CATEGORY PRODUCT COUNTS
//	// =========================================
//	@Test(priority = 4)
//	public void testGetCategoryProductCounts() {
//
//		Response response = CategoryEndpoints.getCategoryProductCounts();
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch for category product counts");
//
//		SoftAssert soft = new SoftAssert();
//
//		soft.assertNotNull(response.getBody().asString(), "Response body should not be null");
//		soft.assertTrue(response.getBody().asString().length() > 0, "Response body should not be empty");
//
//		soft.assertAll();
//	}

	// =========================================
	// LOGIN BEFORE RUNNING PRIVATE TESTS
	// =========================================

	String token;
	String categoryId = null;

	// test data
	String superAdminEmail = "ecoders@gmail.com";
	String superAdminPassword = "abc123ABC!@#";
	String categoryImagePath = "E:\\images\\car_images\\f2.jpg";
	// from // where // the // image // will // get // uploaded.

	@BeforeMethod
	public void loginAsSuperAdmin() {

		Response loginResponse = LoginEndpoints.loginUser(superAdminEmail, superAdminPassword);

		loginResponse.then().log().all();

		Assert.assertEquals(loginResponse.getStatusCode(), 200, "Login failed for superadmin user");

		// adjust token path based on your login response
		token = loginResponse.jsonPath().getString("token");

		// if token comes inside "data.token", use this instead:
		// token = loginResponse.jsonPath().getString("data.token");

		Assert.assertNotNull(token, "Token is null after login");
		System.out.println("Superadmin token: " + token);
	}

	// =========================================
	// TEST 5 - ADD CATEGORY after you login as superr admin
	// =========================================
	@Test(priority = 5)
	public void testAddCategory() {

		String categoryName = "SPORTS CARS";
		File categoryImage = new File(categoryImagePath);

		Response response = CategoryEndpoints.addCategory(token, categoryName, categoryImage);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 201, "Add category status code mismatch");

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(response.jsonPath().getString("message"), "Category added successfully",
				"Success message mismatch");

		soft.assertEquals(response.jsonPath().getString("category.category_name"), categoryName,
				"Created category name mismatch");

		soft.assertNotNull(response.jsonPath().getString("category.category_image"),
				"Created category image should not be null");

		// extract created category id
		categoryId = response.jsonPath().getString("category._id");

		soft.assertNotNull(categoryId, "Created category ID is null");

		System.out.println("Created Category ID: " + categoryId);

		soft.assertAll();
	}

	// TEST 6 - UPDATE CATEGORY
	// =========================================
//	@Test(priority = 6, dependsOnMethods = "testAddCategory")
//	public void testUpdateCategory() {
//
//		Assert.assertNotNull(token, "Token should not be null");
//		Assert.assertNotNull(categoryId, "Category ID should not be null");
//
//		String updatedCategoryName = "Updated API Test Category";
//		File updatedCategoryImage = new File(categoryImagePath);
//
//		Response response = CategoryEndpoints.updateCategory(token, categoryId, updatedCategoryName,
//				updatedCategoryImage);
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Update category status code mismatch");
//
//		SoftAssert soft = new SoftAssert();
//
//		soft.assertTrue(response.getBody().asString().contains("Updated API Test Category"),
//				"Updated category name not found in response");
//
//		soft.assertAll();
//	}
//
//	// =========================================
//	// TEST 7 - DELETE CATEGORY
//	// =========================================
//	@Test(priority = 7, dependsOnMethods = "testUpdateCategory")
//	public void testDeleteCategory() {
//
//		Assert.assertNotNull(token, "Token should not be null");
//		Assert.assertNotNull(categoryId, "Category ID should not be null");
//
//		Response response = CategoryEndpoints.deleteCategory(token, categoryId);
//
//		response.then().log().all();
//
//		Assert.assertEquals(response.getStatusCode(), 200, "Delete category status code mismatch");
//
//		SoftAssert soft = new SoftAssert();
//
//		soft.assertTrue(
//				response.getBody().asString().toLowerCase().contains("delete")
//						|| response.getBody().asString().toLowerCase().contains("removed")
//						|| response.getBody().asString().toLowerCase().contains("success"),
//				"Delete success message not found");
//
//		soft.assertAll();
//	}

}