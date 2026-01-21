package oops_concepts;

// hybrid inheritance : combination of single level , multi level, hirarchical inheritance. 


class Ram
{
	int money = 1000; 
}

class Sham extends Ram
{
	
}

class Suresh1  extends Sham 
{
	
}

class Raju extends Ram
{
	
}

public class Hybrid_Inheritance {

	public static void main(String[] args) 
	{
	   	Raju r = new Raju(); 
	   	System.out.println(r.money);
	}
}
