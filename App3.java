import java.util.HashMap;
import java.util.Map;

public class App3 {

	public static void main(String args[]) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(5, "Five");
		map.put(3, "Three");
		map.put(2, "Two");
		map.put(1, "One");
		map.put(4, "Four");
		
		String text = map.get(8);
		System.out.println(text);
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.println(entry.getValue() + entry.getKey());
		}
	}
}