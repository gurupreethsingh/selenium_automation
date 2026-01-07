package number_programs;

import java.util.Scanner;

public class PositiveOrNegative {

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a numbeer :");
		int  num=sc.nextInt();
		if(num>0)
		{
			System.out.println("Given number is positive ");
		}
		else
		{
			System.out.println("Given number is negative ");
		}
	}

}
