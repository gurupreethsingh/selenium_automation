package end_points;

import static io.restassured.RestAssured.given;

import entity.Contact;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import routes.ContactRoutes;

public class ContactEndPoints 
{
    private static final ContactRoutes routes = new ContactRoutes();

    // Function to add a new contact message
    public static Response addContactMessage(Contact newContactMessageDetails) 
    {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(newContactMessageDetails)
                 .when()
                .post(routes.post_add_contact_message_route);
    }
    
    public static Response fetchAllMessage() 
    {
        return given()
                 .when()
                .get(routes.get_all_messages_route);
    }
    
    public static Response fetchSingeMessageById(String id) 
    {
        return given()
                 .when()
                .get(routes.get_reply_message_route + id);
    }
    
    
    // Mark a message as read (assumes body requires messageId)
    public static Response markMessageAsRead(String messageId) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"messageId\":\"" + messageId + "\"}")
            .when()
                .post(routes.post_mark_message_as_read_route);
    }
    
    
    
    public static Response addReplyToMessage(String id, Object replyBody) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(replyBody)
            .when()
                .post(routes.post_add_reply_to_message_route + id);
        // If your backend expects /{id}/reply, change to:
        // .post(routes.post_add_reply_to_message_route + id + "/reply");
    }
    
    
    public static Response getUnreadMessagesCount() {
        return given()
            .when()
                .get(routes.get_unread_messages_count_route);
    }

    // Get total messages count
    public static Response getMessagesCount() {
        return given()
            .when()
                .get(routes.get_messages_count_route);
    }
    
    
}
