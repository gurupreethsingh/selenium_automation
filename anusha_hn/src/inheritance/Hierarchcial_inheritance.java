package inheritance;

public class Hierarchcial_inheritance {

	public static void main(String[] args) 
	{
		Daughter_1 d1=new Daughter_1();
		System.out.println(d1.property);
		Son_1 s1=new Son_1();
		System.out.println(s1.property);
	}

}
class Father_1
{
	int property=40000;
}
class Daughter_1 extends Father_1
{
	
}
class Son_1 extends Father_1
{
	
}