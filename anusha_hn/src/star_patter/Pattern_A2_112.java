package star_patter;

public class Pattern_A2_112 {

	public static void main(String[] args)
	{
		
		for(int i=1;i<=5;i++)
		{
			int num=65;
			for(int j=1;j<=5;j++)
			{
				if(j>=(6-i))
				{
					System.out.print((char)num);
					num=num+1;
				
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
