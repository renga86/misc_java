package Algos;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class QkSort {
	
	public void quickSort(int[] inputArr) {
		quickRecur(inputArr, 0, inputArr.length-1);
	}
	
	/*public int quickSelect(int[] inpArr, int start, int k) {
		int lo = 0, hi = inpArr.length-1;
		while (hi > lo) {
			int piInd = pivotIndex(inpArr, start, hi);
			if (piInd < k) {
				lo = piInd+1;
			} else if (piInd > k) {
				hi = piInd-1;
			} else {
				return inpArr[k];
			}
		}
		
		return inpArr[k];
	}*/
	
	/*public void threeWayPartition(int[] inpArr, int low, int high) {
		int i = low, lt = low, gt = high;

		if (high <= low) return;
		
		while(i <= gt) {
			if (inpArr[i] > inpArr[low]) {
				swap(inpArr, i, gt--);
			} else if (inpArr[i] < inpArr[low]) {
				swap(inpArr, lt++, i++);
			} else {
				i++;
			}
		}
		
		threeWayPartition(inpArr, low, lt-1);
		threeWayPartition(inpArr, gt+1, high);
		
	}*/
	
	private void quickRecur(int[] inpArr, int start, int end) {
		//System.out.printf(" Start:%d, \t End:%d\n",start, end);
		if (start < end) {
			int piInd = pivotIndex(inpArr, start, end);
			//System.out.printf("PI: %d\n", piInd);
			/*for(int k=start; k <= piInd-1;k++) {
				System.out.printf("Val: %d\t", inpArr[k]);
			}*/
			//System.out.println();
			quickRecur(inpArr, start, piInd-1);
			quickRecur(inpArr, piInd+1, end);
			//System.out.println();
		}
	}
	
	public int pivotIndex(int[] arr, int low, int high) {
		int i= low, j = high + 1;
		while (true) {
			while (arr[++i] < arr[low]) {
				if (i == high) break;
			}
			while (arr[--j] > arr[low]) {
				if (j == low) break;
			}
			
			if (i >= j) break;
			swap(arr, i, j);
		}
		
		swap(arr, j, low);
		
		return j;
	}
	
	public int quickSelect(int[] arr, int start, int k) {
		int low = start, high = arr.length - 1;
		while (high > low) {
			int j = pivotIndex(arr, low, high);
			if (j < k) low = j - 1;
			else if (j > k) high = j + 1;
			else return arr[k];
		}
		
		return arr[k];
	}
	
	public void threeWayPartition(int[] inpArr, int low, int high) {
		int lt = low, i = low, gt = high;
		
		if (high <= low) return;
		
		while (i <= gt) {
			if (inpArr[i] < inpArr[low]) { 
				swap(inpArr, lt++, i++);
				i++; lt++;
			} else if (inpArr[i] > inpArr[low]) {
				swap(inpArr, i, gt--);
			} else {
				i++;
			}
		}
		quickRecur(inpArr, low, lt-1);
		quickRecur(inpArr, gt+1, high);
	}
	
	/*public int pivotIndex(int[] arr, int low, int hi) {
		int i = low, j = hi+1;
		
		while(true) {
			while(arr[++i] < arr[low]) {
				if(i == hi) break;
			}
			while(arr[--j] > arr[low]) {
				if(j == low) break;
			}
			
			if (i >= j) break;
			swap(arr, i, j);
		}
		
		swap(arr, low, j);
		
		return j;
	}*/
	
	private void swap(int[] inpArr, int a, int b) {
		int temp = inpArr[b];
		inpArr[b] = inpArr[a];
		inpArr[a] = temp;
	}
	
	
	
	
	
	static String dutch_flag_sort(String balls) {
        return sortballs(balls, 0, balls.length()-1);
    }

    static String sortballs(String balls, int start, int end) {
        return partition(balls, start, end);
    }

    static String partition(String balls, int low, int high) {
		int lt = low, i = low, gt = high;
		char[] ballsChar = balls.toCharArray();
        char greenBall = 'G';
		
		if (high <= low) return "";
		
		while (i <= gt) {
			if (ballsChar[i] > greenBall) { 
				swap(ballsChar, lt++, i++);
			} else if (ballsChar[i] < greenBall) {
				swap(ballsChar, i, gt--);
			} else {
				i++;
			}
		}
		
		return String.copyValueOf(ballsChar);
	}
    
    static void recurBalls(char[] balls, int start, int end) {
		//System.out.printf(" Start:%d, \t End:%d\n",start, end);
		if (start < end) {
			//int piInd = pivotIndex(balls, start, end);
			//System.out.printf("PI: %d\n", piInd);
			/*for(int k=start; k <= piInd-1;k++) {
				System.out.printf("Val: %d\t", inpArr[k]);
			}*/
			//System.out.println();
			int piInd = 0;
			recurBalls(balls, start, piInd-1);
			recurBalls(balls, piInd+1, end);
			//System.out.println();
		}
	}
                
    static void swap(char[] balls, int i, int j) {
        char tmp = balls[i];
        balls[i] = balls[j];
        balls[j] = tmp;
    }
    
    public static void main(String args[]) {
		QkSort qksort = new QkSort();
		int[] inpArr = {1, 3,5, 2};
		//StdRandom.shuffle(inpArr);
		qksort.quickSort(inpArr);
		//for(int j = 0; j < inpArr.length; j++)
		//	System.out.println(inpArr[j]);
		//System.out.printf("%d\n", qksort.quickSelect(inpArr,0, 1));
		
		/*System.out.println();
		int[] inpArr2 = {3, 4, 5, 3, 2, 3};
		qksort.threeWayPartition(inpArr2, 0, inpArr2.length - 1);
		
		System.out.println("Second ");
		for(int j = 0; j < inpArr2.length; j++)
			System.out.printf("%d\t", inpArr2[j]);*/
		
		//int[] arr1 = {5, 6, 7, 8};
		//int[] arr2 = {1, 2, 3, 4, 0, 0, 0, 0};
		//int[] arr1= {11, 14, 24, 34, 44, 45, 45,47,61,64,72,82,103,104,122,122,131,138,145,148,150,151,185,198};
		//int[] arr2= {6,9,17,19,28,33,35,36,64,76,87,89,107,110,112,121,129,132,139,146,151,152,154,175,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] arr1 = {10, 10};
		int[] arr2 = {10, 10, 0, 0};
		merger_first_into_second(arr1, arr2);
		for(int j = 0; j < arr2.length; j++) {
			System.out.println(arr2[j]);
		}
		//System.out.println(dutch_flag_sort("GBGGRBRGRR"));
	}
    
    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int end1 = arr1.length-1, end2 = end1, end3 = arr2.length-1;
        //System.out.printf("%d %d\n", arr1[end1], arr2[end2]);
         
         while(end1 >= 0 && end2 >= 0) {
        	 	if (end1 < 0) {
        	 		arr2[end3--] = arr2[end2--];
        	 	} else if (end2 < 0) {
        	 		arr2[end3--] = arr2[end1--];
        	 	}else if (arr1[end1] <= arr2[end2]) {
        	 		arr2[end3--] = arr2[end2--];
        	 	} else {
        	 		arr2[end3--] = arr1[end1--];
        	 	}
         }
         
         return arr2;
    }
    
    static void swap(int[] arr1, int[] arr2, int i) {
    		int tmp = arr1[i];
    		arr2[i] = arr1[i];
    		arr1[i] = tmp;
    }
}
