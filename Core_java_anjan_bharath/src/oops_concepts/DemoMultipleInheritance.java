package oops_concepts;

interface One{
	int a = 10; 
}

interface Two{
	int b = 20; 
}

interface Three{
	int c = 30 ; 
}

// multiple inheritance: only one child class inherits properties from multiple parent classes. 
interface Four extends One, Two, Three{
	// a, b, and c values are present here virtually.
}

class Five implements Four{
	// a, b, and c values are present here virtually.
}

public class DemoMultipleInheritance {

	public static void main(String[] args)
	{
		Five f = new Five(); 
		System.out.println(f.a);
		System.out.println(f.b);
		System.out.println(f.c);
	}
}
