package constructor_programs;
// constructor overloading : creating multiple constuctors in the same class, but with variations in argument list. 
// variation in argument list means. 
// length of the variable
// type of variable
// Occurrence of variables

class Whatsapp
{
	Whatsapp(char a)
	{
		System.out.println("Send one message");
	}
	
	Whatsapp(int b, String a)
	{
		System.out.println("Send two message");
	}
	
	Whatsapp(int a, int b, int c)
	{
		System.out.println("Send three message");
	}
}

public class Mobile {

	public static void main(String[] args)   // jvm
	{
		new Whatsapp('a');
		new Whatsapp(3, "hi");
		new Whatsapp(1,1,1);
	}
}
