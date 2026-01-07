package number_programs;

import java.util.Scanner;

public class Reverse_A_number {

	public static void main(String[] args) 
	{
//		// taking input from user 
		Scanner sc =new Scanner(System.in);  //system.in is a argument used to accept the input from the users 
		System.out.println("Enter a number: ");
//		
////		method 1
		int num = sc.nextInt();  // nextInt()  is a methopd used to accept input from the user @ run time 
		int rev=0;
		
		while(num!=0)
		{
			rev=rev*10+num%10;
			num=num/10;
		}
//		
////using string buffer class 
//		
//		
//	/*	StringBuffer rev;
//		 StringBuffer sb=new StringBuffer(String.valueOf(num));  // String.valueOfNum is a method used to convert the number given by user 
//		                                                           // into string and store it in sb  
//		rev = sb.reverse();     // reverse is a method inside string buffer class*/
//		
//// Using string builder method
//		StringBuilder sbl= new StringBuilder();
//	    sbl.append(num);
//		StringBuilder rev=sbl.reverse();
//	
		System.out.println("Reverse number is :"+rev); 
//	
//		
		
		
		


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
