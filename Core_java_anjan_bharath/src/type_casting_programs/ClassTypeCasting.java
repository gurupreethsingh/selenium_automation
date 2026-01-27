package type_casting_programs;

// class type casting : when we convert one class type to anther class type. 
// upcasting , downcasting. 

class Rich
{
	int money = 1000; 
}

class Poor extends Rich
{
	String food = "laddu";
}

public class ClassTypeCasting {
	public static void main(String[] args) 
	{ 
	  Rich r = new Poor();   // upcasting (implicitly)  making the child class equivalent to super class
	  System.out.println(r.money);
	  
	  Poor p = (Poor)r;  // downlocating ( making an super class eqivalent to child class)
	  System.out.println(p.food);
	  System.out.println(p.money);	  
	}
}
