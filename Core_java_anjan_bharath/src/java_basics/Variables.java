package java_basics;

public class Variables     // jvm - look for main function to start the program.
{
    public static void main(String[] args) 
    {
		// variables : are named memory locations. it can store any value, during execution we can 
    	// change that value 
    	// true, false etc keywords cannot use for variable names.
    	
       int a = 5;
       long l = 8765875698769876l;   // long integer  8 bytes
       float f = 2.3f;    // 4 bytes
       double d = 3.4;    // 8 bytes
       char ch = 'a';
       boolean result = true; 
       boolean result1 = false; 
       
       System.out.println(a);
       System.out.println(l);
       System.out.println(f);
       System.out.println(d);
       System.out.println(ch);
       System.out.println(result);
       System.out.println(result1);
       
       
	}
}
