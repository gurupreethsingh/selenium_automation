package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.ContactUs_Endpoints;
import entity.ContactUs;
import io.restassured.response.Response;

public class GetMessageById {

	@Test
	public void getMessageById() {
		
		ContactUs c=new ContactUs();
		
		Response r = ContactUs_Endpoints.getMessageById("6915d0b0f81b54df20316be5");

		r.then().log().all();
		Assert.assertEquals(r.getStatusCode(), 200, "fetching all messages failed, Api route not working.");

		
	}

}
