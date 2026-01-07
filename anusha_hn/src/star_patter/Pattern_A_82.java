package star_patter;

public class Pattern_A_82 {

	public static void main(String[] args)
	{
		for(int i=0;i<5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(j<=(5-i))
				{
					System.out.print(i%2);
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
