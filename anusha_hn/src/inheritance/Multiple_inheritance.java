package inheritance;

/*single child cannot inherit from multiple parent it will 
create diamond problem this is not possible through class but possible through interface*/
interface Parent_1
{
	int money=1000;
}

interface Parent_2
{
	int property=2000;
}

interface Parent_3
{
	int ornaments=5000;
}


interface Child extends Parent_1,Parent_2,Parent_3
{
//	virtually all values present here 
}
// create a child class for interface child 
class Sample implements Child {
	
	
}

public class Multiple_inheritance {


	public static void main(String[] args) 
	{
//		creating the  object of sample class 
		Sample S =new Sample();
		System.out.println(S.money);
		System.out.println(S.property);
		System.out.println(S.ornaments);

	}

}
