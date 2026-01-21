package constructor_programs;

// 1. constructor name should be same as class name. 
// 2. constructor will not have any return type
// 3. constructors will always be non static. ( multiple copies can be made) 

public class Sample 
{
	
	Sample()
	{
		// constructor of the class (default constructor) it will run on its own. as soon as object is created 
		// no need to call/invoke the constructor
		System.out.println("i am the default constructor");
	}
	
	
	public static void main(String[] args) 
	{
		new Sample();
		new Sample();
	}
}
