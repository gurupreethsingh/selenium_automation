package star_patterns;

public class Pattern3 {

	public static void main(String[] args) 
	{
		int num = 65;
		for(int i=1; i<=5; i++)
		{
			for(int j = 1; j<=5; j++)
			{
				System.out.print((char)num);
			}
			System.out.println();
			num++;
		}
	}
}