package functions;

public class FunctionsWithoutParameters 
{
	public static void add( ) 
	{
		int num1 = 10; 
		int num2 = 20; 
		System.out.println(num1+ num2);
	}
	
	// function with parameters. and pass the arguments 
	public static void subtract(int a, int b)
	{
		System.out.println(a-b);
	}
	
	// functions with return value / return type 
	public static int multiply(int a, int b)
	{
		return (a * b);
	}
	
	
	// funtion to calculate area of a circle.    ( 3.12 * 5 * 5 ) 
	
	public static double findAreaOFCircle(int radius)
	{
		double pi = 3.12;
		double area = pi * radius * radius; 
		return area; 
	}
	
	public static void main(String[] args)    // jvm running the main function
	{
		add();
		subtract(20, 5);
		System.out.println(multiply(3, 5));
		System.out.println("The area of cirlce is : " + findAreaOFCircle(5));
	}
}
