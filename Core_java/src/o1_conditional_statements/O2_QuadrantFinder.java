package o1_conditional_statements;

import java.util.Scanner;

public class O2_QuadrantFinder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter x coordinate: ");
		int x = sc.nextInt();
		System.out.print("Enter y coordinate: ");
		int y = sc.nextInt();

		if (x > 0 && y > 0) {
			System.out.println("Quadrant I");
		} else if (x < 0 && y > 0) {
			System.out.println("Quadrant II");
		} else if (x < 0 && y < 0) {
			System.out.println("Quadrant III");
		} else if (x > 0 && y < 0) {
			System.out.println("Quadrant IV");
		} else if (x == 0 && y != 0) {
			System.out.println("On the Y-axis");
		} else if (y == 0 && x != 0) {
			System.out.println("On the X-axis");
		} else {
			System.out.println("Origin");
		}
	}
}