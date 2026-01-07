package star_patter;

public class Pattern_B2 {

	public static void main(String[] args) 
	{
		int a=5;
		for(int i=1;i<=7;i++)
		{
			if(i<5)
			{
				a--;
			}
			else
			{
				a++;
			}
			for(int j=1;j<=4;j++)
			{
				if(j>=a)
				{
					System.out.print("*");
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
