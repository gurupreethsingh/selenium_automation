package o1_conditional_statements;

import java.util.Scanner;

public class O3_QadraticEquation {

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coefficient a: ");
        double a = sc.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = sc.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = sc.nextDouble();

        double discriminant = b * b - (4 * a * c);

        if (discriminant > 0) {
            System.out.println("Real and different roots");
        } else if (discriminant == 0) {
            System.out.println("Real and equal roots");
        } else {
            System.out.println("Complex roots");
        }
	}
}