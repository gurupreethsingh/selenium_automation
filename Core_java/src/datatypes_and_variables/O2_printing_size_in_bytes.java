package datatypes_and_variables;

public class O2_printing_size_in_bytes 
{
	    public static void main(String[] args) {
	        // Primitive Data Types in Java
	        byte byteVar = 127;
	        short shortVar = 32767;
	        int intVar = 2147483647;
	        long longVar = 9223372036854775807L;
	        float floatVar = 3.14f;
	        double doubleVar = 3.14159;
	        char charVar = 'A';
	        
	        boolean booleanVar = true;

	        // Printing each data type
	        System.out.println("byte: " + byteVar + " (Size: " + Byte.BYTES + " bytes)");
	        System.out.println("short: " + shortVar + " (Size: " + Short.BYTES + " bytes)");
	        System.out.println("int: " + intVar + " (Size: " + Integer.BYTES + " bytes)");
	        System.out.println("long: " + longVar + " (Size: " + Long.BYTES + " bytes)");
	        System.out.println("float: " + floatVar + " (Size: " + Float.BYTES + " bytes)");
	        System.out.println("double: " + doubleVar + " (Size: " + Double.BYTES + " bytes)");
	        System.out.println("char: " + charVar + " (Size: " + Character.BYTES + " bytes)");
	        System.out.println("boolean: " + booleanVar + " (Size: " + 1 + " byte*)"); // Approximate size
	        
	        // Reference Types in Java
	        String stringVar = "Hello, World!";
	        System.out.println("String: " + stringVar);
	        System.out.println("Note: String memory size varies depending on its content length.");

	        // Estimating the size of String
	        int estimatedStringSize = 8 + 2 * stringVar.length(); // Rough estimate for character array size in bytes
	        System.out.println("Estimated size of the String variable: " + estimatedStringSize + " bytes");
	    }
}
