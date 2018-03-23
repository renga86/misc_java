import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App2 {

	public static void main(String args[]) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		doTimings("ArrayList", arrayList);
		doTimings("LinkedList", linkedList);
	}
	
	private static void doTimings(String type, List<Integer> list) {
		
		for(int i=0; i<1E5; i++) {
			list.add(i);
		}
		
		long start = System.currentTimeMillis();
		
		/*for (int i=0; i<1E5; i++) {
			list.add(i);
		}*/
		
		for(int i=0; i<1E5;i++) {
			list.add(0, i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println(" Time taken: " +(end-start) + " ms for " + type);
	}
}