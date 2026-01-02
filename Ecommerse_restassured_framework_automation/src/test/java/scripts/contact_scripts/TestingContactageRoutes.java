package scripts.contact_scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import end_points.ContactEndPoints;
import entity.Contact;
import excel_code.Excel;
import io.restassured.response.Response;

public class TestingContactageRoutes 
{
	
	String firstName = "";
	String lastName = "";
	String  email = "";
	String phone = "";
	
	@BeforeTest
	public void getData()
	{
		 firstName = (String) Excel.getData("ContactPage" , 0,0);
		 lastName = (String) Excel.getData("ContactPage" , 0 , 1);
		  email = (String) Excel.getData("ContactPage" , 0,2);
		 phone = (String) Excel.getData("ContactPage" , 0,3);
	}
	

	
    @Test(priority = 1)
    public void testAddContactMessage()
    {
    	Contact newContactMessageDetails = new Contact(); 
    	newContactMessageDetails.setFirstName(firstName);
    	newContactMessageDetails.setLastName(lastName );
    	newContactMessageDetails.setEmail(email);
    	newContactMessageDetails.setPhone("38989");
    	newContactMessageDetails.setMessage_text("Hello message test 5.");
    	newContactMessageDetails.setAgreeToLicense(true);
    	newContactMessageDetails.setIsRead(false);
    	
          Response response =	ContactEndPoints.addContactMessage(newContactMessageDetails);
          response.then().log().all();
          Assert.assertEquals(response.getStatusCode() , 201 , "Error in adding the message, expected 210");
    }
    
   
}
