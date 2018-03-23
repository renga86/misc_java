import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Emp implements Comparable<Emp> {
	private String name;
	
	public Emp(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Emp o) {
		return -name.compareTo(o.name);
	}
}
public class App8 {

	public static void main(String args[]) {
		List<Emp> list = new ArrayList<Emp>();
		SortedSet<Emp> set = new TreeSet<Emp>();
		
		addElems(list);
		addElems(set);
		
		Collections.sort(list);
		
		showElems(list);
		System.out.println();
		showElems(set);
		System.out.println();
	}
	
	private static void addElems(Collection<Emp> str) {
		str.add(new Emp("Andrew"));
		str.add(new Emp("Sue"));
		str.add(new Emp("John"));
		str.add(new Emp("Mike"));
		str.add(new Emp("Juliet"));
	}
	
	private static void showElems(Collection<Emp> str) {
		for(Emp elem: str) {
			System.out.println(elem);
		}
	}
}
