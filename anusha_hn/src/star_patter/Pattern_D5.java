package star_patter;

public class Pattern_D5 {

	public static void main(String[] args) 
	{
		int num=65;
		for(int i=1;i<=5;i++)
		{
			int k=num;
			for(int j=1;j<=5;j++)
			{
				System.out.print((char)k+" ");
				k++;
			}
			System.out.println();
			num++;
			
		}

	}

}
