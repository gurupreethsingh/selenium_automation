package scripts;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import endpoints.LoginEndpoints;
import io.restassured.response.Response;

public class UpdateCategory {

	String token;
	String superadminEmail = "ecoders@gmail.com";
	String superAdminPassword = "abc123ABC!@#";
	String updatedCategoryName = "CARS";
	String categoryId = "69d60aa7810dee5903a16efa";
//	String categoryImagePath = "E:\\images\\car_images\\red_devil.jpg";

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
	public void testUpdateCategory() {

		HashMap<String, Object> hp = new HashMap<String, Object>();
		hp.put("category_name", updatedCategoryName);

		Response response = CategoryEndpoints.updateCategoryById(token, categoryId, updatedCategoryName, hp);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code mismatch, Unable to update category");
	}

}
