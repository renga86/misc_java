import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App4 {

	public static void main(String args[]) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		testMap(hashMap);
		testMap(linkedMap);
		testMap(treeMap);
	}
	
	public static void testMap(Map<Integer, String> map) {
		map.put(3, "ijk");
		map.put(1,  "def");
		map.put(2, "fgh");
		map.put(0,  "abc");
		
		for(Integer key: map.keySet()) {
			System.out.printf("Key " + key.intValue() + " \tValue: " + map.get(key));
			System.out.println();
		}
	}
}
