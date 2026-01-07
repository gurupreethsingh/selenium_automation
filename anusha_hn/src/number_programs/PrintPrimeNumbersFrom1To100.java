package number_programs;

public class PrintPrimeNumbersFrom1To100 {

	public static void main(String[] args)
	{
		int count =0;
		for(int i=1;i<=100;i++)
		
		{
			if(i>1)
			{
				for(int j=1;j<=i;j++)
				{
					if(i%j==0)
					count++;
				}
				
			if(count==2)
			{
				System.out.print(" "+i);
			}
		}

	}
	}
}

