package routes;

import generic.AutomationConstants;

public class ContactUs_Routes implements AutomationConstants {
	
	public String post_add_ContactMessage_Route= globalBackendRoute+ "/add-contact-message";
	public String get_getAllMessages_Route=  globalBackendRoute+"/all-messages";
	public String get_getMessageById_Route =  globalBackendRoute+"/reply-message/";// + {id}
	public String post_addReplyToMessage_Route=globalBackendRoute+"/give-message-reply/"; //+{id} +"/reply"
	
	public String get_getUnreadMessagesCount_Route= globalBackendRoute+"/messages/unread-count";
	
	public String post_markMessageAsRead_Route=   globalBackendRoute+"/messages/mark-as-read";
	
	public String get_getMessagesCount_Route=  globalBackendRoute+"/messages/get-messages-count";
}
