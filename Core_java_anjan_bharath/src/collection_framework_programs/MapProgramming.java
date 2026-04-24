package collection_framework_programs;

import java.util.Map;
import java.util.TreeMap;

public class MapProgramming {

	public static void main(String[] args) {
		// Map interface : - is used when you have key - value pair to enter into the
		// collection.
		// name : 7609870987
		// you can have dulicate keys , but duplicate values are not allowed.
		// we can leave the key empty or value empty, ( at a time we cannot leave key
		// and value empty

//		Map<String, Integer> m = new HashMap<String, Integer>(); 
//		Map<String, Integer> m = new LinkedHashMap<String, Integer>();
		Map<String, String> allProd = new TreeMap<String, String>(); // tree mean fully sorted.
		// put , get
		allProd.put("Anjan", "");
		allProd.put("anjan", "");
		allProd.put("Bhjarath", "");
		allProd.put("Raj", "");
		System.out.println(allProd);

		System.out.println(allProd.get("Anjan"));

		// update values using key.

		if (allProd.containsKey("Anjan")) {
			allProd.put("Anjan", "390534095834098");
		}

		System.out.println(allProd.get("Anjan"));
	}
}
