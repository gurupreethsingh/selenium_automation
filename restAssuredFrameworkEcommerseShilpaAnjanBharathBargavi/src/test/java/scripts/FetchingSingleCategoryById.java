package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;

public class FetchingSingleCategoryById {

	String categoryId = "6809faa61b1caf275f228fb6";

	@Test
	public void testFetchingSingleCategoryById() {
		// pom / endpoints class call the function to fetch or get all categories.
		Response response = CategoryEndpoints.getSingleCategoryById(categoryId);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200,
				"Status code mismatch, Unable to fetch single category by id.");
	}

}
