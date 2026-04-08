package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;

public class CategoriesApiAllRegressionRoutesTesting {
	@Test(priority = 1, enabled = true, invocationCount = 1)
	public void testFetchingAllCategories() {
		// pom / endpoints class call the function to fetch or get all categories.
		Response response = CategoryEndpoints.getAllCategories();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, unable to fetch all categories");
	}

	String categoryId = "6809faa61b1caf275f228fb6";

	@Test(priority = 2, enabled = true, invocationCount = 1)
	public void testFetchingSingleCategoryById() {
		// pom / endpoints class call the function to fetch or get all categories.
		Response response = CategoryEndpoints.getSingleCategoryById(categoryId);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200,
				"Status code mismatch, Unable to fetch single category by id.");
	}

	@Test(priority = 3, enabled = true, invocationCount = 1)
	public void testFetchTotalCategoryCount() {
		Response response = CategoryEndpoints.getCategoryCount();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, api not working");
	}
}
