package number_programs;

import java.util.Scanner;

public class LeapYearOrNot {

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the year to be checked :");
		int year=sc.nextInt();
		
		// using looping method 
		if(year%4==0)   //eg :2016:--> is a leap year which is divisible only with 4 
		{
			if(year%100==0) // in case of centuries   eg:2100 is not a leap year but it is divisible by both 4 and 100 but not by 100
			{
				if(year%400==0)  // eg:2000 --> is a leap year which is divisible by both 4,100 and 400
				{
					System.out.println("The given year is a leap year ");
				}
				else
				{
					System.out.println("Not a leap year ");
				}
			}
			else
			{
				System.out.println("Given year is a leap year :");    //eg :2016 -->divisble by 4 but not by 100 so it is leap year
			}
		}
		else
		{
			System.out.println("Not a leap year :");     
		}

	}

}
