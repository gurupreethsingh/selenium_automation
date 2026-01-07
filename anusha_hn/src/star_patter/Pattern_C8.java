package star_patter;

public class Pattern_C8 {

	public static void main(String[] args)
	{
		int num=1;
		for(int i=1;i<=5;i++)
		{
			
			int k=num;
			for(int j=1;j<=5;j++)
			{
				System.out.print(k+" ");
				k=k+2;
				
			}
			System.out.println();
		num=num+2;
			
		}

	}

}
