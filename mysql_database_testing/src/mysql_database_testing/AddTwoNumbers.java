package mysql_database_testing;

public class AddTwoNumbers {

	public static int addTwoNumbers(int a, int b) {
		int resultOfAddition = 0;
		try {
			resultOfAddition = a / b;

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Some proble in adding two variable.");
		}

		finally {
			System.out.println("Program executed.");
		}

		return resultOfAddition;
	}

	public static void main(String[] args) {

		System.out.println("The result of addition is : " + addTwoNumbers(7, 2));

	}

}
