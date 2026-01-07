package star_patter;

public class Pattern_474_doubt 
{
	public static void main(String []args) 
	{
      for(int i=1;i<=5;i++)
      { 
	  for(int j=1;j<=9;j++)
	      {
		  if(j<=(6-i)|| j>=(4+i))    //why to use OR instead of AND
		   {
			  System.out.print("*");
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
