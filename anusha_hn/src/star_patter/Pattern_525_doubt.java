package star_patter;

public class Pattern_525_doubt {

	public static void main(String[] args) 
	{
		int a=6;int b=4;
		for(int i=1;i<=9;i++)
		{
			if(i<6) {a--; b++;} else {a++;b--;}
			for(int j=1;j<=9;j++)
			{
				if(j<=a||j>=b)
				    {
						System.out.print("#");
					}
				else 
					{
						System.out.print(".");
					}
			}
			System.out.println();
		}
	}

}
