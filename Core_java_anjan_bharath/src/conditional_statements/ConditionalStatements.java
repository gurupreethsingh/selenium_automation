package conditional_statements;

public class ConditionalStatements {

	public static void main(String[] args) 
	{
       // if, if-else, if-else if - else, break, continue, switch-case
		
        String username = "mark";
        
        switch(username)
        {
        case "anjan" :
        {
        	System.out.println("access granted, Username matching.");
        	break;
        }
        case "bharath" :
        {
        	System.out.println("access granted, Username matching.");
        	break;
        }
        
        case "raj" :
        {
        	System.out.println("access granted, Username matching.");
        	break;
        }
        default:
        {
        	System.out.println("access denied, Username not matching.");
        }
        
        }
	}

}
