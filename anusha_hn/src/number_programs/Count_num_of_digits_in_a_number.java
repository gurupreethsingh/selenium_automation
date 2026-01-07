package number_programs;

public class Count_num_of_digits_in_a_number {

	public static void main(String[] args)
	{
		int num=123456;
		int count =0;
		while(num>0)
		{
			num=num/10;
			count++;
		}
		System.out.println("Number of digits in a anumber is : "+count);

	}

}
