
package datatypes_and_variables;

public class O1_DataTypes_Variables {

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
        System.out.println("byte: " + byteVar);
        System.out.println("short: " + shortVar);
        System.out.println("int: " + intVar);
        System.out.println("long: " + longVar);
        System.out.println("float: " + floatVar);
        System.out.println("double: " + doubleVar);
        System.out.println("char: " + charVar);
        System.out.println("boolean: " + booleanVar);

        // Reference Types in Java
        String stringVar = "Hello, World!";
        System.out.println("String: " + stringVar);

        // Array Example
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.print("Array: ");
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Wrapper Classes for Primitive Data Types
        Integer intWrapper = Integer.valueOf(intVar);
        Double doubleWrapper = Double.valueOf(doubleVar);
        Boolean booleanWrapper = Boolean.valueOf(booleanVar);

        System.out.println("Integer Wrapper: " + intWrapper);
        System.out.println("Double Wrapper: " + doubleWrapper);
        System.out.println("Boolean Wrapper: " + booleanWrapper);
    }
}