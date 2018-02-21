import java.util.Comparator;

public class DiffSort {
	
	private int[] arr;
	
	/*public static void sort(Object[] a, Comparator comparator) {
		int N = arr.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0 && less(comparator, a[j], a[j-1]; j--)
					exch(a, j, j-1);
	}
	
	private static boolean less(Comparator<T> c, Object v, Object w) {
		return c.compare(v,  w) < 0;
	}
	
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}*/
	
	DiffSort(int[] inp) {
		arr = new int[10];
		for (int i = 0; i < inp.length; i++) {
			arr[i] = inp[i];
		}
		arr = inp;
	}
	
	public void print() {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d\t", arr[i]);
		}
		System.out.println();
	}
	
	public void insertSort() {
		for(int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}
			}
		}
	}
	
	public void selSort() {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
	}
	
	public void shellSort() {
		int N = arr.length;
		
		int h = 1;
		while (h < N/3) h = 3*h + 1;
		
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && arr[j] < arr[j-h]; j -= h) {
					int tmp = arr[j];
					arr[j] = arr[j-h];
					arr[j-h] = tmp;
				}
			}
			
			h = h/3;
		}
	}
	
	public static void main(String args[]) {
		int[] arr1 = {2, 6, 5, 4, 3, 9, 8, 7, 1};
		DiffSort ins = new DiffSort(arr1);
		ins.insertSort();
		System.out.println(" Insertion Sort: ");
		ins.print();
		int[] arr2 = {2, 6, 5, 4, 3, 9, 8, 7, 1};
		ins = new DiffSort(arr2);
		System.out.println(" Selection Sort: ");
		ins.selSort();
		ins.print();
		int[] arr3 = {8, 7, 1, 4, 3, 2, 6, 5, 9};
		ins = new DiffSort(arr3);
		System.out.println(" Shell Sort: ");
		ins.shellSort();
		ins.print();
	}
}