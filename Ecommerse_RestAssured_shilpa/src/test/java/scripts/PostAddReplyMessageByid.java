package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.ContactUs_Endpoints;
import entity.ContactUs;
import entity.Reply;
import io.restassured.response.Response;

public class PostAddReplyMessageByid {
	@Test
	public void addReplyMessage() {

	    Reply r = new Reply();
	    r.setName("Ecoders");
	    r.setEmail("ecoders@gmail.com");
	    r.setMessage("Thank  dfgg  you for contacting us!");

	    Response res = ContactUs_Endpoints.postAddReplyToMessage(
	            "6915d0b0f81b54df20316be5",r);

	    res.then().log().all();
	    Assert.assertEquals(res.getStatusCode(), 200, "Replying to message failed!");
	}
}
