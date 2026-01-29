package collection_framework_programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapProgramming {

	public static void main(String[] args) 
	{
		// Map interface : - is used when you have key - value pair to enter into the collection. 
		// name : 7609870987
		// you can have dulicate keys , but duplicate values are not allowed. 
		// we can leave the key empty or value empty, ( at a time we cannot leave key and value empty
		
//		Map<String, Integer> m = new HashMap<String, Integer>(); 
//		Map<String, Integer> m = new LinkedHashMap<String, Integer>();
		Map<String, Integer> m = new TreeMap<String, Integer>();   // tree mean fully sorted.
		// put , get 
		m.put("Anjan", 98765464);
		m.put("anjan", 198376464);
		m.put("", 68746465);
		m.put("Bhjarath", 465465456);
		m.put("Raj", null);
		m.put(null, null);
		System.out.println(m);
	}
}
