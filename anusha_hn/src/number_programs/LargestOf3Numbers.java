package number_programs;

import java.util.Scanner;

public class LargestOf3Numbers {

	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter first number :");
		int a=sc.nextInt();
		
		System.out.println("Enter second number :");
		int b=sc.nextInt();
		
		System.out.println("Enter third number :");
		int c=sc.nextInt();
		
//		if(a>b && a>c)
//		{
//			System.out.println("A is Largest");
//		}
//		else if(b>a && b>c)
//		{
//			System.out.println("B is largest");
//		}
//		else {
//			System.out.println("C is largest ");
//		}
	
		// Ternary operator in java 
		int largest1 =(a>b?a:b);    //here comparision is done with a and b 
		int largest2=(largest1>c?largest1:c);
		
		System.out.println(largest2 + "is the largest number" );
		
		
		
		
		
		
	}

}
