package scripts;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.CategoryEndpoints;
import endpoints.LoginEndpoints;
import io.restassured.response.Response;

public class CreateNewCategory {

	String token;
	String superadminEmail = "ecoders@gmail.com";
	String superAdminPassword = "abc123ABC!@#";
	String categoryName = "SPORTS CARS";
	String categoryImagePath = "E:\\images\\car_images\\red_devil.jpg";

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
	public void testAddNewCategory() {
		File categoryImage = new File(categoryImagePath);
		Response response = CategoryEndpoints.addCategory(token, categoryName, categoryImage);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch, Unable to create new category");
	}

}
