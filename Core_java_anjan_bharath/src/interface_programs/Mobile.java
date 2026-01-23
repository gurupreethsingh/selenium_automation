package interface_programs;
// interface : it is a java type used to define only abstract methods, 
// you cannot create object of an interface. 
// you cannot create concrete method inside an interface.
// every interface will have a child  class which will give implementation  to all the abstract methods of interface. 

interface MathsFormulas   // use interface when you want 100% abstraction
{
	void add(); 
	void substract(); 
	void multiply();
}

class Calculation implements MathsFormulas
{
	public void add() 
	{
		int a = 10; int b = 20;  System.out.println(a+b);
	}

	public void substract() {
		int a = 10; int b = 20;  System.out.println(a-b);
	}

	public void multiply() 
	{
		int a = 10; int b = 20;  System.out.println(a*b);
	}
}

public class Mobile 
{
	public static void main(String[] args) 
	{
		MathsFormulas m =  new Calculation();
		Calculation c   =  new Calculation();
		
		m.add(); c.add();
	}
}
