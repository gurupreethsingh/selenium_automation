package oops_concepts;

// multi level inheritance : - when one class inherits from its parent, in turn , that parent inherits from its parent 


class Parent1
{
	int money = 1000; 
}


class Anjan extends Parent1
{
	
}


class Bharath extends Anjan
{
	
}


public class MultiLevelInheritance {

	public static void main(String[] args) 
	{
        Anjan a = new Anjan(); 
        System.out.println(a.money);
        
        Bharath b = new Bharath(); 
        System.out.println(b.money);
	}
}
