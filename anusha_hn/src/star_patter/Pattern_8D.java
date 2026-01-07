package star_patter;

public class Pattern_8D {

	public static void main(String[] args)
	{
		int num=5;
		int k=num;
		for(int i=1;i<=5;i++)
		{
			
			for(int j=1;j<=5;j++)
			{
				if(j<=i)
				{
					System.out.print(k+" ");
					k--;
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
