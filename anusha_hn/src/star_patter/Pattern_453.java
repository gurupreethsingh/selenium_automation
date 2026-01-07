package star_patter;

public class Pattern_453 {

	public static void main(String[] args)
	{
		int a=0;int b=8;
		for(int i=1;i<=7;i++)
		{
			if(i<5) {a++;b--;} else {a--;b++;}
			for(int j=1;j<=7;j++)
			{
				{
					if(j<=a || j>=b)
			{
				System.out.print("*");
			}
					else
					{
						System.out.print(" ");
					}
		}

	}
			System.out.println();

}
}
}
