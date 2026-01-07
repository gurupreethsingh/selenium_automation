package star_patter;

public class Pattern_C_twentyone {

	public static void main(String[] args) 
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print((i*j)%2+" ");
			}
			System.out.println();
		}

	}

}
