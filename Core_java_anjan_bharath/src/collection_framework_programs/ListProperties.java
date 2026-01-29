package collection_framework_programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListProperties {

	public static void main(String[] args)
	{
		// list interfact properties. 
		// 1. size is dynamic (unlimited) 
		// 2. it allows heteriogenious data ( any type of data can be stored, int, char, float, string, boolean. 
		// 3. it allows duplicate values. 
		// 4. it allows null values ( blank spaces )
		
//		List l1 = new ArrayList(); (10 - its size increases by 50% 
//		List l1 = new Vector();    // its size increases by 100% 
		List l1 = new LinkedList(); 
		l1.add(10);
		l1.add(3.5);
		l1.add(true);
		l1.add('a');
		l1.add(10);
		l1.add(null);
		l1.add('b');
		
		System.out.println(l1);

	}

}
