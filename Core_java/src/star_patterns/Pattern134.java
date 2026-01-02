package star_patterns;

public class Pattern134 {

	public static void main(String[] args) 
	{
		int num = 4;
		for(int i=1; i<=4; i++)
		{
			boolean flag = true;
			for(int j = 1; j<=7; j++)
			{
				if(j>=i && j<= 8-i && flag) 
				{
                 System.out.print(num);
                 flag = false;
				}
				else
				{
					System.out.print(" ");
					flag = true;
				}
			}
			System.out.println();
			num--;
		}
	}
}