package abstraction_programs;
//Abstraction : hidding the implementation and showing only what is necessary.

abstract class MathsFormulas  // cannot make objects. 
{
	// concrete method
   public void add()
   {
	   int a=  10; 
	   int b = 20; 
	   System.out.println(a+b);
   }
   
   // abstract method
   abstract public void substract();
}

// every abstract class will have a child class, where the implementation of the abstract methods can be found.
class  Calculation extends MathsFormulas
{
   public void substract()
   {
	   int x = 100; int y = 50 ; 
	   System.out.println(x-y);
   }
}

public class Mobile 
{
	public static void main(String[] args) // jvm
	{
		Calculation c = new Calculation();
		c.add(); 
		c.substract();
	}
}
