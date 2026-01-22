package oops_concepts;

// inheritance : when one class inherits properties from another class. 
// single level inheritance / IS-A relationship

// when only one child class inherits from only one parent class

class Parent  // parent, base, super
{
	int money = 10000; 
}



public class Child  extends Parent  // child , sub class
{
     //  int money = 10000;
	public static void main(String[] args) 
	{
		Child c1 = new Child();
        System.out.println(c1.money);
	}

}
