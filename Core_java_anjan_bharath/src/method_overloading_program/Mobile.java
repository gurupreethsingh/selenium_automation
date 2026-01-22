package method_overloading_program;
// method overloading : creating multiple methods inside a class with same name, but with varitions in argument list, 

// method and a function, 
// method when its created inside a class. 
// functions may not be created inside a class

class Gmail
{
	void sendEmail()
	{
		System.out.println("Email also sent.");
	}
}

class Whatsapp extends Gmail
{
	Gmail g = new Gmail();
	void send(int a)
	{
		g.sendEmail();
		System.out.println("One message sent.");
	}
	
	void send(int a, int b)
	{
		g.sendEmail();
		System.out.println("Two message sent.");
	}
	
	void send(int a, int b, int c)
	{
		g.sendEmail();
		System.out.println("Three message sent.");
	}
}

public class Mobile {

	public static void main(String[] args) 
	{
		Whatsapp w = new Whatsapp();
		w.send(1, 1);

	}

}
