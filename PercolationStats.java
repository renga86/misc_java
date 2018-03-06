
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private int count;
	private double[] fractions;
	private double meanVal;
	private double stdVal;

	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0)
			throw new IllegalArgumentException("Illegal range of values");
		
		count = trials;
		fractions = new double[count];
		// Monte Carlo experimentation
		for (int expNum = 0; expNum < count; expNum++) {
			Percolation perc = new Percolation(n);
			int openedSites = 0;
			while (!perc.percolates()) {
					perc.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
					openedSites++;
			}
			double fraction = (double) openedSites / ( n * n);
			fractions[expNum] = fraction;
		}
	}
	
	public double mean() {
		meanVal = StdStats.mean(fractions);
		return meanVal;
	}
	
	public double stddev() {
		stdVal = StdStats.stddev(fractions);
		return stdVal;
	}
	
	public double confidenceLo() {
		return meanVal - ((1.96 * stdVal) / Math.sqrt(count));
		
	}
	
	public double confidenceHi() {
		return meanVal + ((1.96 * stdVal) / Math.sqrt(count));
	}
	
	public static void main(String args[]) {
		PercolationStats perc = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println(" mean           = " + perc.mean());
		System.out.println(" stddev           = " + perc.stddev());
		System.out.print(" 95% confidence interval   = [ " + perc.confidenceHi() + " " + perc.confidenceLo() + " ]");
	}
}