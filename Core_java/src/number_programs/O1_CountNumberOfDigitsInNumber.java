package number_programs;

import java.util.Scanner;

public class O1_CountNumberOfDigitsInNumber {    // 787865765

	public static void main(String[] args) 
	{
		System.out.println("enter an integer number.");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		System.out.println("the number entered is " +num);
		
		int count = 0;
		
		while(num >= 1)
		{
			int ld = num % 10;
			count++;
			num = num/10;
		}
		
	
		System.out.println("Total digits in the number are " +count);
	}

}
