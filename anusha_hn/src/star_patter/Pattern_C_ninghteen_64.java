package star_patter;

public class Pattern_C_ninghteen_64 {

	public static void main(String[] args)
	{
		
		for(int i=1;i<=5;i++)
		{
			
			for(int j=1;j<=5;j++)
			{
				if(j<=i)
				{
					System.out.print((i*j)%2+" ");
				
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
