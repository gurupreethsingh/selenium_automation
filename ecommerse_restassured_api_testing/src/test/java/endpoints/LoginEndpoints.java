package endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginEndpoints {

	public static Response loginUser(String email, String password) {
		Map<String, Object> payload = new HashMap<>();
		payload.put("email", email);
		payload.put("password", password);

		return given().contentType(ContentType.JSON).body(payload).when().post("http://localhost:3010/api/login");
	}
}