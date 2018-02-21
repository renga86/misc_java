import edu.princeton.cs.algs4.StdIn;

public class Permutation {

	public static void main(String args[]) {
		int k = Integer.parseInt(args[0]);

		RandomizedQueue<String> qu = new RandomizedQueue<String>();
		int i = 0;
		while (!StdIn.isEmpty()) {
			if (i < k)
				qu.enqueue(StdIn.readString());
			i++;
		}
		
		for (String str: qu) {
			System.out.println(str);
		}
	}
}