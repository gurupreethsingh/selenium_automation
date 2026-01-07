package star_patter;

public class Pattern_543_Heart1 {

	public static void main(String[] args) 
	{


	for(int i=1;i<=2;i++)
	{
	
		{
			for(int j=1;j<=9;j++)
			{
				if(  (j>=(3-i)&&j<=(2+i))  || (j>=(8-i)&&j<=(7+i))  )    //why to use OR instead of AND 
				{
					System.out.print("#");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}  // i loop ends here
	for(int i=3;i<=7;i++)
	{
		for(int j=1;j<=9;j++)
		{
			if((j>=(i-2)) && (j<=(12-i)))
			{
				System.out.print("#");
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
