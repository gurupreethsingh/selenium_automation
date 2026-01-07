package star_patter;

public class Pattern_8h_48 {

	public static void main(String[] args)
	{
		int k=1;
		int num=6;
		int t=5;
		int x=t;
		for(int i=1;i<=5;i++)
		{
			int y=x;
			for(int j=1;j<=5;j++)
			{
				if(j<=i)
				{
					System.out.print(k-y+" ");
					y++;
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		k=k+num-i;
		System.out.println(k);
			t=t-1;
			x--;
		}
}

}
