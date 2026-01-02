package endpoints;

import static io.restassured.RestAssured.given;

import entity.ContactUs;
import entity.Reply;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.AuthToken;
import routes.ContactUs_Routes;

public class ContactUs_Endpoints {

	public static Response addContact(ContactUs c) {
		ContactUs_Routes routes = new ContactUs_Routes();

		return given().contentType(ContentType.JSON).accept(ContentType.JSON)
//				   .header("Authorization", "Bearer " + AuthToken.SUPER_ADMIN_TOKEN)
				.body(c).when().post(routes.post_add_ContactMessage_Route);
	}

	public static Response allMessages(ContactUs c) {
		ContactUs_Routes routes = new ContactUs_Routes();
		return given().when().contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get(routes.get_getAllMessages_Route);

	}

	public static Response getMessagesCount(ContactUs c) {

		ContactUs_Routes routes = new ContactUs_Routes();

		return given().when().contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get(routes.get_getMessagesCount_Route);

	}

	public static Response getMessageById(String id) {
		ContactUs_Routes routes = new ContactUs_Routes();

		return given().when().contentType(ContentType.JSON).accept(ContentType.JSON).when()

				.get(routes.get_getMessageById_Route + id);

	}
	
	public static Response postAddReplyToMessage(String id,Reply reply)
	{
		ContactUs_Routes routes = new ContactUs_Routes();

		return given().header("Authorization", "Bearer " + AuthToken.SUPER_ADMIN_TOKEN)
				.when().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(reply).when().post(routes.post_addReplyToMessage_Route +id+"/reply");
		
	}

}
