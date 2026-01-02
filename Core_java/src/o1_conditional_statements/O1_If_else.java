// there are multiple conditional statements in java 
// 1 . if 
// 2. combination of if-else
// 3. combination of if-else if - else 
// 4. switch - case 
// 5. break 
// 6. continue

package o1_conditional_statements;

import java.util.Scanner;

// 1. program to check if the number is a postive or negative number.
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//		int number = 1;
//		if(number >= 0)
//		{
//			System.out.println("Positive number");
//		}
//		else
//		{
//			System.out.println("Negative number");
//		}
//	}
//}

// 2. program to give access to a person if the username matchs. 
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//		String username = "raj";
//		if(username == "raj")
//		{
//			System.out.println("Acces granted");
//		}
//		else
//		{
//			System.out.println("Access Denied");
//		}
//	}
//}

// 3. program to check if a number is even number or odd number.
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//		int num = 5;
//		if(num % 2 == 0)
//		{
//			System.out.println("even");
//		}
//		else
//		{
//			System.out.println("Odd");
//		}
//	}
//}

// 4. program to check if a number is even number or odd number.
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//		int num = 5;
//		if(num % 2 == 0)
//		{
//			System.out.println("even");
//		}
//		else
//		{
//			System.out.println("Odd");
//		}
//	}
//}

//5. program to check the largest of 3 numbers
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//		int a = 5;
//		int b = 4;
//		int c = 8;
//		
//		if(a > b && a > c)
//		{
//			System.out.println( a + " is the largest among. "+ b + " and "+ c);
//		}
//		else if (b > a && b > c)
//		{
//			System.out.println(b +" is the largest among. "+ a + " and "+ c);
//		}
//		else {
//			System.out.println(c +" is the largest among. "+ a + " and "+ b);
//		}
//	}
//}

// 6. use of multiple if - else if - else 

//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//	   String username = "mahesh";
//	   
//	   if (username == "raj")
//	   {
//		   System.out.println("access granted");
//	   }
//	   else if( username == "rajesh")
//	   {
//		   System.out.println("Access granted");
//	   }
//	   else if (username == "raju")
//	   {
//		   System.out.println("Access granted");
//	   }
//	   else
//	   {
//		   System.out.println("Access denied");
//	   }
//	}
//}

// 7. Writing the same program using the switch case statement. 
//public class O1_If_else {
//
//	public static void main(String[] args) 
//	{
//        String username = "raj";
//        
//        switch(username)
//        {
//        case "raj" :
//        {
//        	System.out.println("Access granted");
//        	break;
//        }
//        case "rajesh":
//        {
//        	System.out.println("Access granted");
//        	break;
//        }
//        case "raju":
//        {
//        	System.out.println("Access granted");
//        	break;
//        }
//        default:
//        {
//        	System.out.println("Access Denied");
//        }
//        }
//	}
//}

// 8. guess the number game. 
//public class O1_If_else {
//
//	public static void main(String[] args) {
//		int number = 5;
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("Enter a number or type 'quit' to end the game:");
//			String input = sc.next();
//
//			if (input.equalsIgnoreCase("quit")) {
//				System.out.println("Sorry to see you go. Better luck next time.");
//				break;
//			}
//
//			int guess = Integer.parseInt(input);
//
//			if (guess == number) {
//				System.out.println("Congratulations, you won!");
//				break;
//			} else if (guess < number) {
//				System.out.println("Guess a higher number.");
//			} else {
//				System.out.println("Guess a smaller number.");
//			}
//		}
//	}
//}



public class O1_If_else
{
	public static void main(String [] args)
	{
		//1. Check if a Number is Positive or Negative
		int num = -5;
		if (num >= 0) {
		    System.out.println("Positive");
		} else {
		    System.out.println("Negative");
		}
		
	//	2. Check if a Number is Even or Odd
		int num1 = 4;
		if (num1 % 2 == 0) {
		    System.out.println("Even");
		} else {
		    System.out.println("Odd");
		}
		
		//3. Find the Largest of Two Numbers
		int a = 10, b = 20;
		if (a > b) {
		    System.out.println("a is larger");
		} else {
		    System.out.println("b is larger");
		}
		
		
		//4. Check if a Person is Eligible to Vote
		int age = 18;
		if (age >= 18) {
		    System.out.println("Eligible to vote");
		} else {
		    System.out.println("Not eligible to vote");
		}
		
		
		//5. Check if a Character is a Vowel or Consonant
		char ch = 'a';
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
		    System.out.println("Vowel");
		} else {
		    System.out.println("Consonant");
		}
		
		
		// 6. Find the Largest of Three Numbers
		int a1 = 10, b1 = 20, c1 = 15;
		if (a1 >= b1 && a1 >= c1) {
		    System.out.println("a is largest");
		} else if (b1 >= a1 && b1 >= c1) {
		    System.out.println("b is largest");
		} else {
		    System.out.println("c is largest");
		}
		
		
		// 7. Check if a Number is Divisible by 5

		int num2 = 25;
		if (num2 % 5 == 0) {
		    System.out.println("Divisible by 5");
		} else {
		    System.out.println("Not divisible by 5");
		}
		
		// 8. Check if a Number is Divisible by Both 5 and 11

		int num3 = 55;
		if (num3 % 5 == 0 && num3 % 11 == 0) {
		    System.out.println("Divisible by both 5 and 11");
		} else {
		    System.out.println("Not divisible by both 5 and 11");
		}
		
		//9. Check if a Year is a Leap Year
		int year = 2024;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
		    System.out.println("Leap year");
		} else {
		    System.out.println("Not a leap year");
		}
		
		// 10. Check if a Person is an Adult or Minor

		int age1 = 16;
		if (age1 >= 18) {
		    System.out.println("Adult");
		} else {
		    System.out.println("Minor");
		}
		
		// 11. Simple Calculator Using Switch Case

		int a3 = 10, b3 = 5;
		char operator = '+';
		switch (operator) {
		    case '+':
		        System.out.println(a3 + b3);
		        break;
		    case '-':
		        System.out.println(a3 - b3);
		        break;
		    case '*':
		        System.out.println(a3 * b3);
		        break;
		    case '/':
		        System.out.println(a3 / b3);
		        break;
		    default:
		        System.out.println("Invalid operator");
		}
		
		// 12. Check if a Number is Positive, Negative, or Zero
		int num4 = 0;
		if (num4 > 0) {
		    System.out.println("Positive");
		} else if (num4 < 0) {
		    System.out.println("Negative");
		} else {
		    System.out.println("Zero");
		}
		
		
		// 13. Check if a Number is a Multiple of 3
		int num5 = 9;
		if (num5 % 3 == 0) {
		    System.out.println("Multiple of 3");
		} else {
		    System.out.println("Not a multiple of 3");
		}
		
		// 14. Find the Grade Based on Marks
		int marks = 85;
		if (marks >= 90) {
		    System.out.println("Grade A");
		} else if (marks >= 80) {
		    System.out.println("Grade B");
		} else if (marks >= 70) {
		    System.out.println("Grade C");
		} else if (marks >= 60) {
		    System.out.println("Grade D");
		} else {
		    System.out.println("Grade F");
		}
		
		
		// 15. Determine Whether a Character is an Alphabet
		char ch1 = 'A';
		if ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z')) {
		    System.out.println("Alphabet");
		} else {
		    System.out.println("Not an alphabet");
		}
		
		// 16. Find the Day of the Week
		int day = 3;
		switch (day) {
		    case 1:
		        System.out.println("Monday");
		        break;
		    case 2:
		        System.out.println("Tuesday");
		        break;
		    case 3:
		        System.out.println("Wednesday");
		        break;
		    case 4:
		        System.out.println("Thursday");
		        break;
		    case 5:
		        System.out.println("Friday");
		        break;
		    case 6:
		        System.out.println("Saturday");
		        break;
		    case 7:
		        System.out.println("Sunday");
		        break;
		    default:
		        System.out.println("Invalid day");
		}
		
		//17. Check if a Number is Within a Range
		int nu3 = 10;
		if (nu3 >= 1 && nu3 <= 100) {
		    System.out.println("Within range");
		} else {
		    System.out.println("Out of range");
		}
		
		//18. Determine if a Person is a Teenager
		int age2 = 14;
		if (age2 >= 13 && age2 <= 19) {
		    System.out.println("Teenager");
		} else {
		    System.out.println("Not a teenager");
		}
		
		//19. Check if a Character is Uppercase or Lowercase
		char ch2 = 'b';
		if (ch2 >= 'A' && ch2 <= 'Z') {
		    System.out.println("Uppercase");
		} else if (ch2 >= 'a' && ch2 <= 'z') {
		    System.out.println("Lowercase");
		} else {
		    System.out.println("Not a letter");
		}
		
		
		//21. Check if a Triangle is Valid
		int a2 = 60, b2 = 60, c2 = 60;
		if (a2 + b2 + c2 == 180) {
		    System.out.println("Valid triangle");
		} else {
		    System.out.println("Invalid triangle");
		}
		
		// 22. Determine the Type of Triangle
		int a4 = 5, b4 = 5, c4 = 5;
		if (a4 == b4 && b4 == c4) {
		    System.out.println("Equilateral triangle");
		} else if (a4 == b4 || b4 == c4 || a4 == c4) {
		    System.out.println("Isosceles triangle");
		} else {
		    System.out.println("Scalene triangle");
		}
		
		
		// 24. Find Absolute Value of a Number
		int n1 = -5;
		if (n1 < 0) {
		    n1 = -n1;
		}
		System.out.println("Absolute value: " + n1);
		
		// 25. Check if a Number is Within Two Ranges
		int n2 = 25;
		if ((n2 >= 1 && n2 <= 10) || (n2 >= 20 && n2 <= 30)) {
		    System.out.println("Within the ranges 1-10 or 20-30");
		} else {
		    System.out.println("Outside the specified ranges");
		}
	}
}















