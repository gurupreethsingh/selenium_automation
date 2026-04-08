package endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndpoints {

	public static Response loginUser(String email, String password) {
		Response response = null;
		try {
			HashMap<String, String> hp = new HashMap<String, String>();
			hp.put("email", email);
			hp.put("password", password);

			response = given().contentType(ContentType.JSON).body(hp).when().post("http://localhost:3010/api/login");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

}
