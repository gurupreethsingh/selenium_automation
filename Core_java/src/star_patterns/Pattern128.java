package star_patterns;

public class Pattern128 {

	public static void main(String[] args) 
	{

		for(int i=1; i<=4; i++)
		{
			boolean flag = true;
			for(int j = 1; j<=7; j++)
			{
				if(j>=5-i && j<= 3+i && flag) 
				{
                 System.out.print("*");
                 flag = false;
                 
				}
				else
				{
					System.out.print(" ");
					flag = true;
				}
			}
			System.out.println();

		}
	}
}