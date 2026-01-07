package number_programs;

import java.util.Scanner;

public class CheckUppercaseOrLowercaseOrDigitOrSpecialCharacter {

	public static void main(String[] args)
	{
      Scanner sc = new Scanner(System.in); 
      //sc.next().charAt(0)  -->next() reads input as a string ,charAt(0) -->reads first character from string
      System.out.println("Enter the character need to be checked :");
      char ch=sc.next().charAt(0);
    
    if(ch>='A'&&ch<='Z')
    {
    	System.out.println("Entered character is a uppercase alphabet :");
    }
    else if(ch>='a'&&ch<='z')
    {
    	System.out.println("Entered character is a lowercase alphabet :");
    }
    else if(ch>='0'&&ch<='9')
    {
    	System.out.println("Entered character is a digital character :");
    }
    else {
    	System.out.println("Entered character is a special character :");
    }
	}

}
//ASCII values A=65 Z=90 a=97  z=122 0=48   9=57