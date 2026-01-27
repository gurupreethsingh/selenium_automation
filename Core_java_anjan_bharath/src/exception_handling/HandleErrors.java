package exception_handling;
// Exception handling : means we have to handle the errors
//try- catch - finally block

// final and finally. 

//final - keyword 
//finally - ( exception handling block)

public class HandleErrors {

	public static void main(String[] args) 
	{
		System.out.println("Anjan");
		
		System.out.println("Bharath");
		
		int a = 7 ; int b = 0; 
		
		try
		{
			System.out.println(a/b);
		}
		catch(Exception ex)
		{
			System.out.println("i have handled the error.");
			ex.printStackTrace();
		}
		
		finally
		{
			System.out.println("Program terminated");
		}
		
	}

}
