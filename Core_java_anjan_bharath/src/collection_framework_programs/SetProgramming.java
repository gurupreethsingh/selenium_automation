package collection_framework_programs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetProgramming {

	public static void main(String[] args)
	{
		// set doenst allow duplicates 
		
//		Set s = new HashSet();    
//		Set s = new LinkedHashSet();
		Set<Integer> s = new TreeSet<Integer>();      // tree means fully sorted

		s.add(15);   
		s.add(10); 
		s.add(5);   
		s.add(10) ;  
	
		System.out.println(s);

	}

}
