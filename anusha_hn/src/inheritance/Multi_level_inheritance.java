package inheritance;

public class Multi_level_inheritance {

	public static void main(String[] args)
	{
		Son s = new Son();
		System.out.println(s.salary);
		Daughter d=new Daughter();
		System.out.println(d.salary);
	}

}
class Father
{
	int salary=50000;

}
class Daughter extends Father
{
//	virtually presennt 
}
class Son extends Daughter
{
	
}
