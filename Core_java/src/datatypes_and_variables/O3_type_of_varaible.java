package datatypes_and_variables;

public class O3_type_of_varaible {

	public static void main(String[] args) 
	{
		        Integer number = 42;
		        String text = "Hello";
		        Double decimal = 3.14;

		        System.out.println("Type of 'number': " + number.getClass().getName());
		        System.out.println("Type of 'text': " + text.getClass().getName());
		        System.out.println("Type of 'decimal': " + decimal.getClass().getName());

	
// For primitive types, you can't use getClass(), as primitives do not have methods. Instead, you can use their wrapper classes if needed:

		        int n = 10;
		        System.out.println("Type of 'n': " + ((Object)number).getClass().getName()); // Works with wrapper class

//		Example with instanceof

		        Object obj = "Hello, World!";

		        if (obj instanceof String) {
		            System.out.println("The object is a String.");
		        } else if (obj instanceof Integer) {
		            System.out.println("The object is an Integer.");
		        } else {
		            System.out.println("The object type is unknown.");
		        }
		    }
}
