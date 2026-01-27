package encapsulation;
//  access modifiers or access specifiers. 
//4   public private , protected, default

// encapsulation : creating private elements inside a class and restricting their direct access, 
// but providing them with indirect access through public services like setters and getters functions is know
// as encapsulation. 

// Bean class : bean class is the one in which we make private elements and restricting their direct access, 
//but providing them with indirect access through public services like setters and getters functions

class Gmail{    // bean class. 
	private String emailId = "anjan@gmail.com";
	private String password = "abc123";
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}

public class Users {
	public static void main(String[] args) 
	{
		Gmail g1 = new Gmail(); 
		g1.setEmailId("anjhan123@gmail.com");
		System.out.println(g1.getEmailId());	
		g1.setPassword("1234abcd");
		System.out.println(g1.getPassword());
	}
}
