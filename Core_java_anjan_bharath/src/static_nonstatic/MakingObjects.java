package static_nonstatic;

public class MakingObjects 
{
	static int a = 10;    // single copy
	       int b = 20;    // multple copies of non static variables.
	       
	       
	public void add()
	{
		int a = 10; 
		int b = 30; 
		System.out.println(a+b);
	}

	public static void main(String[] args)   // jvm is running the main function
	{
		System.out.println(a);
		
		// now bringing non-static members into the main() function. 
		
		MakingObjects mo = new MakingObjects();
		
		System.out.println(mo.b);
		System.out.println(mo.a);
		
		mo.add();
	}
}
