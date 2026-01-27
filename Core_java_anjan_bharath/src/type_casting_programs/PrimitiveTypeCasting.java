package type_casting_programs;

// Type casting :  when one data type is converted into another data type

// primitive typecasting: when one primitive data type is converted to another primitive data type.

// 8 primitivie data types ( inbuilt )
// byte  - 1 byte
// short - 2 bytes
// char  - n'/u000'
// int   -  4 bytes
// float  - 4 bytes
// long   - 8 bytes
// double - 8 bytes

public class PrimitiveTypeCasting {
	public static void main(String[] args) 
	{
       int a = 23;    // 4 bytes. 
       double d = a;   // 8 bytes   // implicitly - internally   // upcating
       System.out.println(d);
       
       double x = 23.45; 
       int y = (int)x;   // explicitly - externally   // downcasting
       System.out.println(y);
	}
}
