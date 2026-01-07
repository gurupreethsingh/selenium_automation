package number_programs;

import java.util.Scanner;

public class Reverse_A_string {

	public static void main(String[] args) 
	{
		
	//Using string concatination method 
		Scanner sc = new Scanner(System.in);
		System.out.println("Entere a string");
		
		String str=sc.next();
		int len=str.length();
		String rev=" ";
		
		for(int i=len-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		System.out.println("Reveresed string is :"+rev);
	
		
//		
//		// using string array method      here we will convert the given string into array then find its lenght
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a String :");
//		
//		String str=sc.next();		
//		String rev=" ";
//		char a[]=str.toCharArray();
//        int len=a.length;
//        
//        for(int i=len-1;i>=0;i--)
//        {
//        	rev=rev+a[i];
//        }
//	
//System.out.println("Reveresed string is :"+rev);		
	}
	

}
