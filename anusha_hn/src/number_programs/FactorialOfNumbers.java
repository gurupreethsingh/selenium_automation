package number_programs;

import java.util.Scanner;

public class FactorialOfNumbers {

	public static void main(String[] args) 
	{
		//using looping method
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number :");
		int num=sc.nextInt();
		int factorial=1;
		for(int i=1;i<=num;i++)
		{
			factorial=factorial*i;
		}
		System.out.println("Factorial of given number is :"+factorial);
		
		
		//using reccursive method 
		
		
		
		
		
		
		

	}

}
