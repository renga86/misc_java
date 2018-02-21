import java.io.*;

public class Skin {
	public static void main(String args[]) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String input = buff.readLine();
		for (int j = 0; j < input.length(); j++) {
			if (j == 1) {
					continue;
			}
			System.out.print(input.charAt(j));
		}
	}
	
	public static void printPrimes(int n) {
		boolean[] prime = new boolean[n+1];
		int i;
		for(i = 2; i<=n; i++) {
			prime[i] = true;
		}
		for(int divisor=2;divisor*divisor<=n;divisor++) {
			if (prime[divisor]) {
				for(i = 2*divisor; i<=n;i = i+divisor) {
					prime[i] = false;
				}
			}
		}
	}
	
	public static int[][] pascalTriangle(int n) {
		int[][] pt = new int[n][];
		for(int i=0;i<=n;i++) {
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for (int j = 1; j < i; j++) {
				pt[i][j] = pt[i-1][j-1] + pt[i-1][j];
			}
			pt[i][i]=1;
		}
		return pt;
	}
}