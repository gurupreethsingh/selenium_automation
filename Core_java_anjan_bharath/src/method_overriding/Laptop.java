package method_overriding;

// method overriding : create a function in the child class same as that of super class, but with different implementation
// is known as method overriding.

class Kaspersky1
{
	void removeVirus()
	{
		System.out.println("It removes 1 virus at a time.");
	}
}


class Kaspersky2 extends Kaspersky1
{
	void removeVirus()
	{
		super.removeVirus();
		System.out.println("It removes 100 virus at a time.");
	}
}


public class Laptop 
{
  public static void main(String[] args) 
  {
	 Kaspersky2 k2 = new Kaspersky2(); 
	 k2.removeVirus();
  }
}
