package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;

public class FetchingAllCategories {

	@Test
	public void testFetchingAllCategories() {
		// pom / endpoints class call the function to fetch or get all categories.
		Response response = CategoryEndpoints.getAllCategories();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, api not working");
	}

}
