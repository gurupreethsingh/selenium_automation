package number_programs;

import java.util.Scanner;

public class PrintGradeBasedOnMarks {

	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the marks of the student :");
		int marks=sc.nextInt();
		
		if(marks>=90)
		{
			System.out.println("The student obtained garde A :");
		}
		else if(marks>=75)
		{
			System.out.println("The student got grade B :");
		}
		else if(marks>=60)
		{
			System.out.println("The student got grade C :");
		}
		else if(marks>=40)
		{
			System.out.println("The student got grade D :");
		}
		else
		{
			System.out.println("The student is failed :");
		}
	}

}
