package routes;

public class ContactRoutes 
{
	public String globalBackendRoute = "http://localhost:3010";

    // CREATE
    public String post_add_contact_message_route    = globalBackendRoute + "/api/add-contact-message";

    // READ
    public String get_all_messages_route            = globalBackendRoute + "/api/all-messages";
    public String get_reply_message_route          = globalBackendRoute + "/api/reply-message/"; // + {id}

    // ADD REPLY (append :id)
    public String post_add_reply_to_message_route   = globalBackendRoute + "/api/give-message-reply/"; // + {id}/reply

    // COUNTS
    public String get_unread_messages_count_route   = globalBackendRoute + "/api/messages/unread-count";
    public String get_messages_count_route          = globalBackendRoute + "/api/messages/get-messages-count";

    // UPDATE (mark as read)
    public String post_mark_message_as_read_route   = globalBackendRoute + "/api/messages/mark-as-read";
}
