package entity;

import java.util.Date;
import java.util.List;

public class Contact 
{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String message_text;
    private Boolean agreeToLicense;
    private Boolean isRead;
    private List<Reply> replies;
    private Date createdAt;
    private Date updatedAt; // from timestamps: true

    // ================== Getters & Setters ==================

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage_text() {
        return message_text;
    }

    public void setMessage_text(String message_text) {
        this.message_text = message_text;
    }

    public Boolean getAgreeToLicense() {
        return agreeToLicense;
    }

    public void setAgreeToLicense(Boolean agreeToLicense) {
        this.agreeToLicense = agreeToLicense;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
 
    public Date getUpdatedAt() {
        return updatedAt;
    }
 
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ================== Inner Class for Reply ==================

    public static class Reply {
        private String name;
        private String email;
        private String message;
        private Date timestamp;

        public String getName() {
            return name;
        }
 
        public void setName(String name) {
            this.name = name;
        }
 
        public String getEmail() {
            return email;
        }
 
        public void setEmail(String email) {
            this.email = email;
        }
 
        public String getMessage() {
            return message;
        }
 
        public void setMessage(String message) {
            this.message = message;
        }
 
        public Date getTimestamp() {
            return timestamp;
        }
 
        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
    }
}
