package scripts.contact_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import end_points.ContactEndPoints;
import io.restassured.response.Response;

public class TestingFetchAllMessages 
{
	 @Test(priority = 1)
	    public void fetchAlltMessage()
	    {
	          Response response =	ContactEndPoints.fetchAllMessage();
	          response.then().log().all();
	          Assert.assertEquals(response.getStatusCode() , 200 , "Error in fetching all the message, expected 200");
	    }
}
