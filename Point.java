import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
    		if (that == null) 
    			throw new NullPointerException();
    		
    		double xdiff = (that.x - this.x);
    		double ydiff = (that.y - this.y);
    		
    		if (xdiff == 0.0 && ydiff == 0.0) {
			return Double.NEGATIVE_INFINITY;
		}
    		if (ydiff == 0.0)  {
    			return 0.0;
    		}
    		if (xdiff == 0.0) {
    			return Double.POSITIVE_INFINITY;
    		}
    		
        return (ydiff) / (xdiff);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
    		if (that == null) {
    			throw new NullPointerException();
    		}
    		
    		if ((this.y < that.y) || ((this.y == that.y) && (this.x < that.x))) {
    			return -1;
    		} else if ((this.y == that.y) && (this.x == that.x)) {
    			return 0;
    		} else {
    			return 1;
    		}
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
        		public int compare(Point o1, Point o2) {
        			double slope1 = slopeTo(o1);
        			double slope2 = slopeTo(o2);
        			return Double.compare(slope1, slope2);
        		}
        };
    }
    
    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
    	    // read the n points from a file
        /*In in = new In("input8.txt");
        int n = in.readInt();*/
        Point[] points = new Point[4];
        points[0] = new Point(21784, 21585);
        points[1] = new Point(25161, 28160);
        points[2] = new Point(10443, 16989);
        points[3] = null;
        /*for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        
       Point p1 = new Point(8, 5);
        System.out.println(p1.slopeTo(null)); 

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();*/

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}