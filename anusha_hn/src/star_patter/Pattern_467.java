package star_patter;

public class Pattern_467 
{
	public static void main(String []args) 
	{
		int a=0;
      for(int i=1;i<=9;i++)
      { 
    	  if(i<6) {a++;} else {a--;}
	  for(int j=1;j<=5;j++)
	      {
		  if(j>=a)    
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
