package star_patter;

public class Pattern_545_X_MAX_TREE {

	public static void main(String[] args) 
	{
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=15;j++)
			{
				if(j>=(9-i)&&(j<=(i+7)))
				{
					System.out.print("#");
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}  // i loop ends here
		for(int i=5;i<=8;i++)
		{
			for(int j=1;j<=15;j++)
			{
				if(j>=(11-i)&&j<=(5+i))
				{
					System.out.print("#");
				}
			else
			{
				System.out.print(".");
			}
		}
		System.out.println();
	}  //i loop ends here
		for(int i=9;i<=12;i++)
		{
			for(int j=1;j<=15;j++)
			{
				if(j>=(13-i)&&j<=(3+i))
				{
					System.out.print("#");
				}
			else
			{
				System.out.print(".");
			}
		}
		System.out.println();
}  //i loop ends here
		for(int i=13;i<=16;i++)
		{
			for(int j=1;j<=15;j++)
			{
				if(j>=5&&j<=11)
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
