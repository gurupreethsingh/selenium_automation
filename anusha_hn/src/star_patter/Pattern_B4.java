package star_patter;

public class Pattern_B4 {

	public static void main(String[] args) 
	{
		
		for(int i=1;i<=5;i++)
		{
			boolean num=true;
//			since the and operator cannot be applied to boolean value we will initialize the value boolean num=true;
			
//			every single time when the line changes num vlaue should be initialize to true;
			for(int j=1;j<=9;j++)
			{
				if(j>=i&&j<=(10-i)&&num)
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
