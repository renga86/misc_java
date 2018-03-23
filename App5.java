import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App5 {

	public static void main(String[] args) {
		
		// hashset doesn't set retain order
		Set<String> set1 = new HashSet<String>();
		
		set1.add("one");
		set1.add("two");
		set1.add("five");
		set1.add("four");
		set1.add("three");
		
		// adding duplicate items
		set1.add("three");
		
		System.out.println(set1);
		
		// linkedhashset remembers order of insertion
		Set<String> set2 = new LinkedHashSet<String>();
		set2.add("one");
		set2.add("two");
		set2.add("nine");
		set2.add("eight");
		set2.add("three");
		
		System.out.println(set2);
		
		// treeset sorts in natural order
		Set<String> set3 = new TreeSet<String>();
		set3.add("a");
		set3.add("f");
		set3.add("b");
		set3.add("c");
		set3.add("d");
		
		System.out.println(set3);
		
		// does set contain a particular element
		if (set1.contains("adword")) {
			System.out.println(" Really ???? ");
		}
		
		// Set intersection
		Set<String> intersection = new HashSet<String>(set1);
		intersection.retainAll(set2);
		
		System.out.println(intersection);
		
		// Set difference
		Set<String> diff = new HashSet<String>(set1);
		diff.removeAll(set2);
		
		System.out.println(diff);
	}
}
