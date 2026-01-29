package loop_control_statements.nested_loops;

public class Pattern_06_oddseries {

	public static void main(String[] args) 
	{
		
		for(int i = 1; i<=5; i++)
		{
			int num = 1;
			for(int j = 1; j <= 5; j++)
			{
				System.out.print(num+" ");
				num = num+2;
			}
			System.out.println();
		}

	}

}
