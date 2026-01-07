package star_patter;

public class Pattern_472_doubt 
{
	public static void main(String []args) 
	{
      for(int i=1;i<=5;i++)
      { 
	  for(int j=1;j<=9;j++)
	      {
		  if(j<=i || j>=(10-i))    //why to use OR instead of AND
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
