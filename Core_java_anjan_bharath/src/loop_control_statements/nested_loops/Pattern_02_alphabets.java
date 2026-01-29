package loop_control_statements.nested_loops;

// nested loops : loop inside a loop is called as nested loops 

public class Pattern_02_alphabets 
{
	public static void main(String[] args) 
	{
		int num = 65;
          for( int i = 1; i<= 5; i++)  // rows 
          {
        	  for(int j = 1; j<= 5; j++)    //  no of columns
        	  {
        		  System.out.print((char)num);
        	  }  
        	  System.out.println();   // line changing code
        	  num = num + 1; 
          }
	}
}
