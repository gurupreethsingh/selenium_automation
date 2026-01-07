package star_patter;

public class Pattern_A9 {

	public static void main(String[] args) 
	{	
		int a=6;
		int b=4;
		{
			for( int i=1;i<=9;i++)
			{
				boolean num=true;
//				since every single time when the line changes the value of num should be true
				if(i<6)
				{
					a--;b++;
				}
				else
				{
					a++;b--;
				}
				for(int j=1;j<=9;j++)
				{
					if((j>=a&&j<=b)&&num)
					{
						System.out.print("*");
						num=false;
					}
					else
					{
						System.out.print(" ");
						num=true;
					}
				}
				System.out.println();
			}
		}
	}

}
