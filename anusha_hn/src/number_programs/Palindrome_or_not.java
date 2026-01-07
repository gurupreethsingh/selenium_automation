package number_programs;

import java.util.Scanner;

public class Palindrome_or_not {

	public static void main(String[] args)
	{
		
		//PALINDROME NUMBER 
//		Scanner sc =new Scanner(System.in);
//		System.out.println("Enter a number: ");
//		
//		int num=sc.nextInt();
//		int original_num=num;
//		int rev =0;
//		while(num!=0)
//		{
//			rev=rev*10+num%10;
//			num=num/10;
//			
//		}
//  if(original_num==rev)
//  {
//	  System.out.println("Entered number is a palindrome number ");
//  }
//  
//  else
//  {
//	  System.out.println("Given number is not a palindrome number ");
//  }
		//PALINDROME STRING
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a string :");
		
		String str=sc.next();
	
		String org_string=str;
		String rev =" ";
		
		 int len=str.length();
		for(int i=len-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println(rev);
		
		if(org_string.equals(rev))
		{
			System.out.println("Entered string is a palindrome ");
		}
		else {
		System.out.println("Entered string is not a palindrome ");
		}
		
		
	}

}
