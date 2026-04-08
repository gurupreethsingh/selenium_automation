package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;

public class FetchTotalProductsCountInEachCategory {

	@Test
	public void testFetchTotalProductsCountInEachCategory() {
		Response response = CategoryEndpoints.getCategoryProductsCounts();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, api not working");
	}

}
