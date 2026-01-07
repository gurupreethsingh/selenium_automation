package star_patter;

public class Pattern_A2_116 {

	public static void main(String[] args)
	{
		int num=69;
		for(int i=1;i<=5;i++)
		{
			
			for(int j=1;j<=5;j++)
			{
				if(j>=(6-i))
				{
					System.out.print((char)num);
					
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
