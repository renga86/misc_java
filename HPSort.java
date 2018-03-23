public class HPSort {

	private int N;
	private int[] pq;
	
	private int LEFT(int i) {
		return 2*i;
	}
	
	private int RIGHT(int i) {
		return 2 * (i+1);
	}
	
	private int PARENT(int i) {
		return i / 2;
	}
	
	private void swim (int[] arr, int k) {
		while (k > 1 && arr[k/2] < arr[k]) {
			swap(arr, k, k/2);
			k = k/2;
		}
	}
	
	public void insert(int key) {
		pq[++N] = key;
		swim(pq, N);
	}
	
	private void sink(int[] arr, int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && pq[j] < pq[j+1]) j++;
			if (!(pq[k] < pq[j])) break;
			swap(arr, k, j);
			k = j;
		}
	}
	
	public int delMax(int key) {
		int max = pq[1];
		swap(pq, 1, N--);
		sink(pq, 1);
		pq[N+1] = 0;
		return max;
	}
	
	private void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public void sort(int[] arr) {
		for (int k = N/2; k >= 1; k--)
			sink(arr, k);
		
		while (N > 1) {
			swap(pq, 1, N);
			--N;
			sink(pq, 1);
		}
	}
	
	public static void main(String args[]) {
		int[] arr1 = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		HPSort sort = new HPSort();
		for(int j=0; j < arr1.length; j++) {
			System.out.println(arr1[j]);
		}
		System.out.println(sort.N);
	}
}