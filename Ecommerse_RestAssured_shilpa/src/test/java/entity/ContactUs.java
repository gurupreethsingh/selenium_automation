package entity;

public class ContactUs {
	private String firstName;
	private String lastName;

	private String email;

	private String phone;

	private String message_text;
	
	private boolean agreeToLicense;

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

	public boolean isAgreeToLicense() {
		return agreeToLicense;
	}

	public void setAgreeToLicense(boolean agreeToLicense) {
		this.agreeToLicense = agreeToLicense;
	}

	
}
