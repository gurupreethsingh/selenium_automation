package star_patter;

public class Pattern_A2_99 {

	public static void main(String[] args)
	{
		int num=5;
		for(int i=1;i<=5;i++)
		{
			int k=num;
			for(int j=1;j<=5;j++)
			{
				if(j>=(6-i))
				{
					System.out.print(k);
					k++;
				
				}
				else
				{
					System.out.print(" ");
				}
				
			}
			System.out.println();
			num--;
			
		}

	}

}
