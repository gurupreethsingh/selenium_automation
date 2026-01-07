package inheritance;

public class Hybrid_inheritance {

	public static void main(String[] args) 
	{
		ANUSHA A =new ANUSHA();
		System.out.println(A.property);
		MANOHAR M =new MANOHAR();
		System.out.println(M.property);
		MANOHAR_1 M1 = new MANOHAR_1();
		System.out.println(M1.property);

	}

}
class NAGESH
{
	int property=1000;
}
class ANUSHA extends NAGESH
{
	
}
class MANOHAR extends NAGESH
{
	
}
class MANOHAR_1 extends ANUSHA
{
	
}
