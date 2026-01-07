package number_programs;

public class CountNumOfEvenOrOddDigitsInGivenNumber {

	public static void main(String[] args) 
	{
		int num =123456;
		int even_count=0;
		int odd_count=0;
		
		while(num>0)
		{
		int	rem=num%10;     //6   5   4   3    2
		//fetch each number from the last and test whethter it is even or odd
		if(rem%2==0)       
		{
			even_count++;    //1    2    3
		}
		else
		{
			odd_count++;     //1    2    3
		}
		
		num=num/10;           //12345     1234     123   12    1
		// eliminating that digit
		
		
		}
		System.out.println("The number of even numbers in a given number are:  "+even_count +" The number of odd numbers in a given number are  :"+odd_count);
	}

}
