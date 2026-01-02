package scripts.contact_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import end_points.ContactEndPoints;
import io.restassured.response.Response;

public class TestingFetchSingleMessageById 
{
	String id = "6911d39acdb54f09c6a6cb11";
	
	
	 @Test(priority = 1)
	    public void fetchAlltMessage()
	    {
	          Response response =	ContactEndPoints.fetchSingeMessageById(id);
	          response.then().log().all();
	          Assert.assertEquals(response.getStatusCode() , 200 , "Error in fetching all the message, expected 200");
	    }
}
