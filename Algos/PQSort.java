package Algos;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQSort {
	
	static int[] topK(int[] arr, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if (!pq.contains(arr[i]))
				pq.add(arr[i]);
			if (pq.size() > k) {
				pq.remove();
			}
		}
		
		int[] retArr = new int[pq.size()];
		int index = 0;
		
		for (Integer ints : pq) {
			retArr[index] = ints;
			index++;
		}
        
		return retArr;
    }
	
	public static void main(String args[]) {
		int[] arr = {1, 5, 1, 5, 1};
		int[] arr1 = PQSort.topK(arr, 2);
		
		for(int j = 0; j < arr1.length; j++)
			System.out.printf("%d\t", arr1[j]);
		
		int[] arr2 = new int[999000];
		for (int i =0; i < 999000; i++) {
			arr2[i] = i;
		}
		
		int[] arr3 = PQSort.topK(arr2, 10);
		
		for(int j = 0; j < arr3.length; j++)
			System.out.printf("%d\t", arr3[j]);
		
		int[][] arr5 = { {6,7,8,9,10},
				{1,2,3,4,5},
				{0,9,10, 11}};
		
		PQSort.mergeArrays(arr5, 5, 3);
	}
	
	static void mergeArrays(int[][] arr5, int n, int k) {
		
		int[] output = new int[n*k];
		
		PriorityQueue<Integer> inte = new PriorityQueue<Integer>();
		for(int i = 0; i < arr5.length; i++) {
			inte.add(arr5[i][0]);
		}
	}
}