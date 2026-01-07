package star_patter;

public class Pattern_A_90 {

	public static void main(String[] args)
	{
		
		for(int i=1;i<=5;i++)
		{
			int num=69;
			for(int j=1;j<=5;j++)
			{
				if(j<=(6-i))
				{
					System.out.print((char)num+" ");
					num--;
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
