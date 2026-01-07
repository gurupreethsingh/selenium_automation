package number_programs;

import java.util.Scanner;

public class PositiveOrNegativeOrZero {

	public static void main(String[] args)
	{
	  Scanner sc =new Scanner(System.in);
	  System.out.println("Enter a number :");
	  int num=sc.nextInt();
	  
	  if(num>0)
	  {
		  System.out.println("The entered number is positive number :");
	  }
	  else if(num<0)
	  {
		  System.out.println("The entered number is a negative number :");
	  }
	  
	  else {
		  System.out.println("Entered number is equal to zero :");
	  }

	}

}
