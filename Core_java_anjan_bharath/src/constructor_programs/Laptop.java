package constructor_programs;
// constructor chaining : when one constructor calls or invokes another constructor, same class or diffrent class, 

class Gmail
{
	Gmail()
	{
		System.out.println("Pvr cinema tickets booked.");
	}
}

class Pvr extends Gmail // super, parent , base
{
	Pvr(int a)
	{
		super();
		System.out.println("One ticket booked.");
	}
	Pvr(int a, int b)
	{
		super();
		System.out.println("Two ticket booked.");
	}
	Pvr(int a, int b, int c)
	{
		super();
		System.out.println("Three ticket booked.");
	}
}

public class Laptop {

	public static void main(String[] args) 
	{
		new Pvr(1, 1);
	}
}
