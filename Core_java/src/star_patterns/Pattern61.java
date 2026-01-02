package star_patterns;

public class Pattern61 {

	public static void main(String[] args) 
	{
		int num1 = 1; int num2 = 0;
		for(int i=1; i<=5; i++)
		{
			for(int j = 1; j<=5; j++)
			{
				if(j<=i)
				{
					if(j%2 == 0)
					{
						System.out.print(num2);
					}
					else
					{
						System.out.print(num1);
					}
					
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
			
		}
	}
}