package star_patterns;

public class Pattern4 {

	public static void main(String[] args) 
	{
		int num = 69;
		for(int i=1; i<=5; i++)
		{
			for(int j = 1; j<=5; j++)
			{
				System.out.print((char)num);
			}
			System.out.println();
			num--;
		}
	}
}