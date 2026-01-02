package star_patterns;

public class Pattern62 {

	public static void main(String[] args) 
	{
		int num1 = 0; int num2 = 1; 
		boolean flag = true;
		for(int i=1; i<=5; i++)
		{
			
			for(int j = 1; j<=5; j++)
			{
				if(j<=i && flag)
				{
				
				System.out.print(num1);
				flag = false;
				}
				else
				{
					System.out.print(num2);
					flag = true;
				}
			}
			System.out.println();
			
		}
	}
}