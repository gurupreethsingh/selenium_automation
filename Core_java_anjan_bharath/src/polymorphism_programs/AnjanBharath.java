package polymorphism_programs;

// polymorphism : poly many , morphism - forms. 
// objects behaviour changes through its life cycle. by taking may forms.

// complie time polymorphism ( method overloading) 

// Run time polymorphism ( method overriding ) 

class Manufacturer{
	void sellLaptop() {
		System.out.println("We sell all laptops");
	}
}

class DellShowroom extends Manufacturer{
	void sellLaptop() {
		System.out.println("Dell laptops");
	}
}

class HpShowroom extends Manufacturer{
	void sellLaptop() {
		System.out.println("Hp laptops");
	}
}

class AsusShowroom extends Manufacturer{
	void sellLaptop() {
		System.out.println("Asus laptops");
	}
}

class Amazon
{
	void sellEverything(Manufacturer m)
	{
       	m.sellLaptop();	
	}
}

class Flipkart
{
	void sellEverything(Manufacturer m)
	{
       	m.sellLaptop();	
	}
}


public class AnjanBharath extends Manufacturer
{
	public static void main(String[] args) 
	{
		DellShowroom d = new DellShowroom(); 
		HpShowroom   h = new HpShowroom(); 
		AsusShowroom a = new AsusShowroom(); 
		
		Amazon az = new Amazon();
		az.sellEverything(h);
		
		Flipkart fk = new Flipkart(); 
		fk.sellEverything(a);

	}
}
