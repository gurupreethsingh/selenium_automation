package star_patter;

public class Pattern_543_Heart2 {

	public static void main(String[] args) 
	{
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=15;j++)
			{
				if(   (j>=(4-i)&&j<=(4+i) ) || (j>=(12-i)&& j<=(12+i)) )
				{
					System.out.print("#");
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}    // i loop ends 
       for(int i=4;i<=11;i++)
       {
    	   for(int j=1;j<=15;j++)
    	   {
    		   if(  (j>=(i-3)) && (j<=(19-i)) )
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
