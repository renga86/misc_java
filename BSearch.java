
public class BSearch {

	public int IterAlgo(int[] arr, int n, int x) {
		int low = 0, high = n- 1;
		
		while (low <= high) {
			int mid = low + (high -low) / 2;
			if (arr[mid] == x) return mid;
			else if (x < arr[mid]) high = mid - 1;
			else low = mid + 1;
		}
		
		return -1;
	}
	
	public int RecurAlgo(int[] arr, int low, int high, int x) {
		
		if (low > high) return -1;
		int mid = low + (high - low) / 2;
		if (arr[mid] == x) return mid;
		else if (x < arr[mid]) return RecurAlgo(arr, low, mid - 1, x);
		else return RecurAlgo(arr, mid+1, high, x);		
	}
	
	public int FirstOccur(int[] arr, int n, int x) {
		int low = 0, high = n- 1, result = -1;
		
		while (low <= high) {
			int mid = low + (high -low) / 2;
			if (arr[mid] == x) {result =  mid;high=mid-1;}
			else if (x < arr[mid]) high = mid - 1;
			else low = mid + 1;
		}
		
		return result;
	}
	
	public int LastOccur(int[] arr, int n, int x) {
		int low = 0, high = n- 1, result = -1;
		
		while (low <= high) {
			int mid = low + (high -low) / 2;
			if (arr[mid] == x) {result =  mid;low=mid+1;}
			else if (x < arr[mid]) high = mid - 1;
			else low = mid + 1;
		}
		
		return result;
	}
	
	public int RepeatOccur(int[] arr, int n, int x) {
		
		int lastindex = LastOccur(arr, n, x);
		int firstindex = FirstOccur(arr, n, x);
		return lastindex - firstindex + 1;
	}
	
	public int RotateCount(int[] arr, int n) {
		int low = 0, high = n-1;
		
		while (low <= high) {
			if (arr[low] <= arr[high]) return low;
			int mid = (low+high)/2;
			int next = (mid+1)%n, prev = (mid+n-1)%n;
			if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) return mid;
			else if (arr[mid] <= arr[high]) high= mid - 1;
			else if (arr[mid] >= arr[low]) low = mid+1;
		}
		
		return -1;
	}
	
	public int RotateFind(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		
		while (low <= high) {
			int mid = (low+high)/2;
			if (x == arr[mid]) return mid;
			if (arr[mid] <= arr[high]) {
				if(x > arr[mid] && x <= arr[high]) low = mid + 1;
				else high = mid-1;
			}
			else {
				if(arr[low] <=x && x<arr[mid]) high = mid-1;
				else low = mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		BSearch test = new BSearch();
		int[] arr = {10, 15, 20, 56, 75, 89, 100};
		System.out.printf("Iter Printing result: %d \n", test.IterAlgo(arr, arr.length, 20));
		System.out.printf("Recur Printing result: %d \n", test.RecurAlgo(arr, 0, arr.length-1, 20));
		int[] arr1 = {15, 10, 10, 56, 75, 89, 100};
		System.out.printf("First occur Printing result: %d \n", test.FirstOccur(arr1, arr1.length, 10));
		System.out.printf("Last occur Printing result: %d \n", test.LastOccur(arr1, arr1.length, 10));
		int[] arr2 = {10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.printf("Repeat occur Printing result: %d \n", test.RepeatOccur(arr2, arr2.length, 10));
		int[] arr3 = {1, 10, 10, 10, 10, 89, 100, 200, 300};
		System.out.printf("Repeat occur Printing result: %d \n", test.RepeatOccur(arr3, arr3.length, 10));
		int[] arr4 = {8, 11, 12, 15, 18, 3};
		System.out.printf("Rotate find Printing result: %d \n", test.RotateCount(arr4, arr4.length));
		
		int[] arr5 = {12, 14, 18, 21, 3, 6, 8, 9};
		System.out.printf("Rotate find Printing result: %d \n", test.RotateFind(arr5, arr5.length, 9));
	}
}
