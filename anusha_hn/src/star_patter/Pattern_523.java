package star_patter;

public class Pattern_523 {

	public static void main(String[] args) 
	{
		for(int i=1;i<=3;i++)
		{   
			for(int j=1;j<=13;j++)
			{
				if((j<=i) ||  (j>=(8-i)) && (j<=(6+i)) ||(j>=(14-i)) ) 
				{
					System.out.print("#");
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}  // i loop ends 
		for(int i=4;i<=7;i++)
		{
			int n=1;int m=13;
			for(int j=1;j<=13;j++)
			{
				if(j>=n && j<=m)
				{
					System.out.print("#");
				}
				
			}
			System.out.println();
				
		}

	}

}
