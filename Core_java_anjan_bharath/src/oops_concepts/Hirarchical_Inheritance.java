package oops_concepts;

// hirarchical : when multiple child classes inherit properties from one single parent class.

class Ramesh
{
	int money = 1000; 
}

class Suresh extends Ramesh
{
	
}

class Mahesh extends Ramesh
{
	
}

public class Hirarchical_Inheritance {

	public static void main(String[] args) 
	{
		Mahesh m = new Mahesh(); 
		System.out.println(m.money);
	}

}
