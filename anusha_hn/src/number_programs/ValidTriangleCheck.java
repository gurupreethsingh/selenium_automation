package number_programs;

import java.util.Scanner;

public class ValidTriangleCheck {

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the first angle :");
	    int a=sc.nextInt();
	    
	    System.out.println("Enter the second angle :");
	    int b=sc.nextInt();
	    
	    System.out.println("Enter the third angle :");
	    int c =sc.nextInt();
	    
	    if((a>0&&b>0&&c>0)&&(a+b+c==180))
	    		{
	    	       System.out.println("Valid triangle :");
	    		}
	    else {
	    	System.out.println("Not a valid traingle :");
	    }
		
		

	}

}
