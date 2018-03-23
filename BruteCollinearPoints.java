import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

	private ArrayList<LineSegment> segments = new ArrayList<>();

	public BruteCollinearPoints(Point[] points) {
		
		// throw exception according to the spec
		
		if (points == null) {
			throw new IllegalArgumentException();
		}
		
		if (hasDuplicates(points)) {
			throw new IllegalArgumentException();
		}
        
		// without sorting, segments are hapzhard and also doesn't match reference solution
		Point[] copy = Arrays.copyOf(points, points.length);
        Arrays.sort(copy);
        
		double slope1, slope2, slope3 = 0.0;
		
		// O(n^4) as per spec to find 4 collinear points
		for(int i = 0; i < copy.length - 3; i++) {
			
			// throwing exception taken care in Point.java according to the spec
			
			for(int j = i+1; j < copy.length - 2; j++) {
				slope1 = copy[i].slopeTo(copy[j]);
				for(int k = j+1; k < copy.length - 1; k++) {
					slope2 = copy[i].slopeTo(copy[k]);
					for(int l=k+1;l < copy.length; l++) {
						if (copy[l] == null) {
							throw new IllegalArgumentException();
						}
						slope3 = copy[i].slopeTo(copy[l]);
						
						// according to spec, check if p makes equal slopes with points q, r and s
						if (slope1 == slope2 && slope1 == slope3) {
							segments.add(new LineSegment(copy[i], copy[l]));
						}
					}
				}
			}
		}
	}
	
	public LineSegment[] segments() {
		// prevent duplicate addition to the list.. hashmap/set can't be used as per spec.
		/*for(int i = 0; i < segments.size(); i++) {
			for(int j = i+1; j < segments.size(); j++) {
				if(segments.get(j).toString().equals(segments.get(i).toString())) {
					segments.remove(j);
					j--;
				}
			}
		}*/
		
		return segments.toArray(new LineSegment[segments.size()]);
	}
	
	public int numberOfSegments() {
		return segments.size();
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