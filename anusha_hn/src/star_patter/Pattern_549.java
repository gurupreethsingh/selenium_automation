package star_patter;

public class Pattern_549 {

	public static void main(String[] args) 
	{
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if((i==6)||(j==3) || (i==1&&j==3)||(i==2&&j==2)||(i==3&&j==1))
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
