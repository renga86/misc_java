import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class App10 {

	public static String[] vehicels = {
			"ambulance", "helicopter", "lifeboot"
	};
	
	public static String[][] drivers = {
			{"Fred", "Sue", "Peter"},
			{"Sue", "Richard", "Bobie", "Fred"},
			{"Peter", "Mary", "Bobie"},
	};
	
	public static void main(String[] args) {
		
		Map<String, Set> map = new HashMap<String, Set>();
		for (int i = 0; i < vehicels.length; i++) {
			String[] driversList = drivers[i];
			Set<String> driverSet = new LinkedHashSet<String>();
			for(String driver: driversList) {
				driverSet.add(driver);
			}
			
			map.put(vehicels[i], driverSet);
		}
		
		{
		Set<String> driversList = map.get("ambulance");
		for (String driver: driversList) {
			System.out.println(driver);
		}
		}
		
		
		for(String vehice: map.keySet()) {
			System.out.println(vehice);
			Set<String> driversList = map.get(vehice);
			for (String driver: driversList) {
				System.out.printf("\t:%s ", driver);
			}
			System.out.println();
		}
	}
}
