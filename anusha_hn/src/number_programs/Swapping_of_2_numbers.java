package number_programs;

public class Swapping_of_2_numbers 
{
	public static void main(String[] args) 
	{
		
		int a=20;
		int b=30;
		System.out.println("Before swapping the values of a and b are :"+a +"  "+b);
//	Method 1	swapping two numbers without 3rd variable 
		/*a=a+b;    //20+30 =50    a=50;
		b=a-b;    // 50-30 =20   b=20
		a=a-b;    //50-20 =30    a=30;
		
		System.out.println("Values of a and b after swapping are:" + "a ="+a + " b ="+b); */
		
//		Method  2 swapping by using third variable 
		/*int t=a;
		    a=b;
		    b=t;
		 System.out.println("After aswapping the values of a and b are "+a +" "+b);
		 
//		Method 3	swapping two numbers without 3rd variable */
		 
		/*a=a*b;
		b=a/b;
		a=a/b;
		
		System.out.println("After swapping the values of a and b are "+a +" "+b);*/
		
// Method 4
		b=(a+b)-(a=b); 
		System.out.println("After swapping the values of a and b are "+a +" "+b);
		
		

	}

}

