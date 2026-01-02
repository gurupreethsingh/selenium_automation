package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.ContactUs_Endpoints;
import entity.ContactUs;
import generic.Excel;
import io.restassured.response.Response;

public class ContactUs_Scripts {
	
	@Test
	
	public void testAddingNewMessage()
	{
		/// Use entity classes's setter method to make new category name. 
		ContactUs c = new ContactUs();
		
		
		c.setFirstName((String)Excel.getData("contact", 0, 0));
		
		c.setLastName((String)Excel.getData("contact", 0, 1));
		
		c.setEmail((String)Excel.getData("contact", 0, 2));
		
		c.setPhone((String)Excel.getData("contact", 0, 3));
		
		c.setMessage_text((String)Excel.getData("contact", 0, 4));
		c.setAgreeToLicense(true);
		
		Response res = ContactUs_Endpoints.addContact(c);   // this creates the category
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 201, "Creating category failed, Api route not working.");
		
	}


}
