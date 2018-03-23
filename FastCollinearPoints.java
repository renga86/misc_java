import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

	// Point segments to be returned back
	private List<LineSegment> segments = new ArrayList<>();

	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}
		
		if (hasDuplicates(points)) {
			throw new IllegalArgumentException();
		}
		
		Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        
		for(int i = 0; i < copy.length; i++) {
			
			// sort the points according to the slope it makes with 'p' as per spec.
			Arrays.sort(copy, copy[i].slopeOrder());
			
            for (int p = 0, first = 1, last = 2; last < copy.length; last++) {
                while (last < copy.length
                        && Double.compare(copy[p].slopeTo(copy[first]), copy[p].slopeTo(copy[last])) == 0) {
                    last++;
                }
                // if found at least 3 elements, add to segments
                if (last - first >= 3 && copy[p].compareTo(copy[first]) < 0) {
                    segments.add(new LineSegment(copy[p], copy[last - 1]));
                }
                // find next
                first = last;
            }
		}
	}
	
	public int numberOfSegments() {
		return segments.size();
	}
	
	public LineSegment[] segments() {
		// prevent duplicate addition to the list.. hashmap/set can't be used as per spec.
		for(int i = 0; i < segments.size(); i++) {
			for(int j = i+1; j < segments.size(); j++) {
				if(segments.get(j).toString().equals(segments.get(i).toString())) {
					segments.remove(j);
					j--;
				}
			}
		}
		
		return segments.toArray(new LineSegment[segments.size()]);
	}
	
	private boolean hasDuplicates(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
        		if (points[i] == null || points[i+1] == null) {
        			throw new IllegalArgumentException();
        		}
            if (points[i].compareTo(points[i + 1]) == 0) {
                return true;
            }
        }
        return false;

    }
}
