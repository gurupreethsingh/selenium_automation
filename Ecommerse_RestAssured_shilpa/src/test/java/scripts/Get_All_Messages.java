package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.ContactUs_Endpoints;
import entity.ContactUs;
import io.restassured.response.Response;

public class Get_All_Messages {
	@Test
	public void testGetAllMessahes()
	{
		ContactUs c =new ContactUs();
	Response	r=ContactUs_Endpoints.allMessages(c);
	
	r.then().log().all();
	Assert.assertEquals(r.getStatusCode(), 200, "fetching all messages failed, Api route not working.");
	}
}
