package star_patter;

public class Pattern_A_84 {

	public static void main(String[] args)
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(j<=(5-i))
				{
					System.out.print(j%2+" ");
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
