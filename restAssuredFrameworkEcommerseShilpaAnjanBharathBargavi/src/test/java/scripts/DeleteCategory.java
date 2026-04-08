package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import endpoints.LoginEndpoints;
import io.restassured.response.Response;

public class DeleteCategory {

	String token;
	String superadminEmail = "ecoders@gmail.com";
	String superAdminPassword = "abc123ABC!@#";
	String categoryId = "69d6075e810dee5903a16b7b"; // sports card

	@BeforeMethod
	public void loginAsSuperadmin() {
		Response loginResponse = LoginEndpoints.loginUser(superadminEmail, superAdminPassword);
		loginResponse.then().log().all();
		Assert.assertEquals(loginResponse.getStatusCode(), 200, "Status code mismatch, Unable to login");
		token = loginResponse.jsonPath().getString("token");
		Assert.assertNotNull(token, "Token is null or not getting generated");
		System.out.println("Super admin toaken : " + token);
	}

	@Test
	public void testDeleteCategoryById() {
		Response response = CategoryEndpoints.deleteCategoryById(token, categoryId);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, Unable to Delete Category");
	}

}
