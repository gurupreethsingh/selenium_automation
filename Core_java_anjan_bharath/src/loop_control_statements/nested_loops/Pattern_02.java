package loop_control_statements.nested_loops;

// nested loops : loop inside a loop is called as nested loops 

public class Pattern_02 
{
	public static void main(String[] args) 
	{
		int num = 1;
          for( int i = 1; i<= 5; i++)  // rows 
          {
        	  for(int j = 1; j<= 5; j++)    //  no of columns
        	  {
        		  System.out.print(num);
        	  }  // j loop ends
        	  System.out.println();   // line changing code
        	  num = num + 1;  // num++
          }
	}
}
