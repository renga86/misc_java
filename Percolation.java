import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[][] id;
	private WeightedQuickUnionUF weightedunion;
	private int count;
	private int currOpenSites = 0;
	private int top = 0;
	private int bottom;
	
	private int getIndex(int row, int col) {
		return (count * (row - 1) + col);
	}
	
	public Percolation(int n) {
		if (n <= 0)
			throw new java.lang.IllegalArgumentException("Invalid value of n");
		
		id = new boolean[n][n]; // by default all sites are blocked
		count = n;
		bottom = count * count + 1; // bottom additional sentinel
		weightedunion = new WeightedQuickUnionUF(n*n + 2);
	}
	
	public void open(int row, int col) {
		if (row < 1 || row > count || col < 1 || col > count) 
			throw new java.lang.IllegalArgumentException("Invalid range of values");
		
		if (isOpen(row, col)) {
			return;
		}
		
		if (row == 1) {
			weightedunion.union(getIndex(row, col), top);
		}
		if (row == count) {
			weightedunion.union(getIndex(row, col), bottom);
		}
		
		currOpenSites++;
		id[row - 1 ][col - 1] = true; // Open the site
		// If not already open, open all adjacent sites
		if (row < count && isOpen(row+1, col))
			weightedunion.union(getIndex(row, col), getIndex(row+1, col));
		if (col < count && isOpen(row, col + 1))
			weightedunion.union(getIndex(row, col), getIndex(row, col + 1));
		if (col > 1 && isOpen(row, col - 1))
			weightedunion.union(getIndex(row, col), getIndex(row, col - 1));
		if (row > 1 && isOpen(row -1, col))
			weightedunion.union(getIndex(row, col), getIndex(row - 1, col));
	}
	
	public boolean isOpen(int row, int col) {
		if (row < 1 || row > count || col < 1 || col > count) 
			throw new java.lang.IllegalArgumentException("Invalid range of values");
		
		return id[row - 1][col - 1];
	}
	
	public boolean isFull(int row, int col) {
		if (row < 1 || row > count || col < 1 || col > count) 
			throw new java.lang.IllegalArgumentException("Invalid range of values");
		
		return weightedunion.connected(top, getIndex(row, col));
	}
	
	public int numberOfOpenSites() {
		return currOpenSites;
	}

	public boolean percolates() {
		return weightedunion.connected(top, bottom); // just check if top sentinel
		// is connected to bottom sentinel
	}
	
	public static void main (String args[]) {
		Percolation percolation = new Percolation(3);
		/*percolation.open(10,2);
		percolation.open(2,10);
		percolation.open(6,8);
		percolation.open(2,6);
		percolation.open(1,4);
		percolation.open(8,4);
		percolation.open(10,1);
		percolation.open(4,2);
		percolation.open(4,8);
		percolation.open(9,3);
		percolation.open(2,2);
		percolation.open(9,1);
		System.out.println(percolation.isFull(9,1));
		percolation.open(4,3);
		percolation.open(5,5);
		percolation.open(5,7);
		percolation.open(2,8);
		percolation.open(6,4);
		percolation.open(7,5);
		percolation.open(9,6);
		percolation.open(3,7);
		percolation.open(4,7);
		percolation.open(7,1);
		percolation.open(9,4);
		percolation.open(3,10);
		percolation.open(1,10);
		percolation.open(10,10);
		percolation.open(9,7);
		percolation.open(1,5);
		percolation.open(9,8);
		percolation.open(6,1);
		percolation.open(2,5);
		percolation.open(3,4);
		percolation.open(6,9);
		percolation.open(5,8);
		percolation.open(3,2);
		percolation.open(4,6);
		percolation.open(1,7);
		percolation.open(7,9);
		percolation.open(3,9);
		percolation.open(4,4);
		percolation.open(4,10);
		percolation.open(3,5);
		percolation.open(3,8);
		percolation.open(1,8);
		percolation.open(3,1);
		System.out.println(percolation.isFull(9,1));
		percolation.open(6,7);
		percolation.open(2,3);
		percolation.open(7,4);
		percolation.open(9,10);
		percolation.open(7,6);
		percolation.open(5,2);
		System.out.println(percolation.isFull(9,1));
		percolation.open(8,3);
		percolation.open(10,8);
		percolation.open(7,10);
		percolation.open(4,5);
		System.out.println(percolation.isFull(9,1));
		percolation.open(8, 10);
		System.out.println(percolation.isFull(9,1));*/
		
		percolation.open(1, 3);
		System.out.println(percolation.isFull(3, 1));
		percolation.open(2, 3);
		System.out.println(percolation.isFull(3, 1));
		percolation.open(3, 3);
		System.out.println(percolation.isFull(3, 1));
		percolation.open(3, 1);
		System.out.println(percolation.isFull(3, 1));
		percolation.open(2, 1);
		System.out.println(percolation.isFull(3, 1));
		percolation.open(1, 1);
		System.out.println(percolation.isFull(3, 1));
		System.out.println();

	}
}