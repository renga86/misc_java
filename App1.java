import java.util.ArrayList;

public class App1 {

	public static void main(String args[]) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(100);
		numbers.add(40);
		
		for(int i=0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		System.out.println();
		numbers.remove(numbers.size() - 1);
		numbers.remove(0);
		for (int val:numbers) {
			System.out.println(val);
		}
	}
}
