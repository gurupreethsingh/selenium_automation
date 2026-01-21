package assignments;

public class Test3 {

	public static void main(String[] args) {
		//sum of first 10 numbers
		int sum =0;
		for (int i=0;i<=10;i++)
		{
			sum=sum+i;
		}
		System.out.println(sum);
		System.out.println();
		//sum of first 20 even numbers
		int num =0;
		for(int i=0;i<=20;i++)
		{
			if(i%2==0)
			{
				num= num +i;
			}
		}
		System.out.println(num);
		
		System.out.println();
		//sum of first 20 odd numbers
		int odd=0;
		for(int i=0;i<=20;i++)
		{
			if(i%2!=0)
			{
				odd= odd +i;
			}
		}
		System.out.println(odd);
		

	}

}
