package Algos;

public class MSort {

	public void merSort(int[] inputArr) {
		int[] outArr = new int[inputArr.length];
		merRecur(inputArr, 0, inputArr.length-1, outArr);
		for(int j = 0; j < outArr.length; j++)
			System.out.printf("%d\t", outArr[j]);
	}
	
	private void merRecur(int[] inpArr, int start, int end, int[] outArr) {
		if (start < end) {
			int mid = (start + end) / 2;
			merRecur(inpArr, start, mid, outArr);
			merRecur(inpArr, mid+1, end, outArr);
			merge(inpArr, start, mid, end, outArr);
		}
	}
	
	private void merge(int[] inpArr, int start, int mid, int end, int[] outArr) {
		int left = start, right = mid+1;
		int index = 0;
		
		while(left <= mid && right <= end) {
			if (inpArr[left] <= inpArr[right])
				outArr[index++] = inpArr[left++];
			else
				outArr[index++] = inpArr[right++];
		}
		
		while (left <= mid) {outArr[index++] = inpArr[left++];}
		while (right <= end) {outArr[index++] = inpArr[right++];}
		
		index = 0;
		for(int j = start; j <= end; j++) {
			inpArr[j] = outArr[index];
			index++;
		}
	}
	
	private int[] mergeArrays(int[] inpArr1, int[] inpArr2, int[] outArr, boolean flag) {
		int index = 0;
		int size1 = 0, size2 = 0;
		int endSize1 = inpArr1.length, endSize2 = inpArr2.length;
		
		for(int j=0; j < outArr.length; j++) {
			System.out.printf("%d\t", outArr[j]);
		}
		
		System.out.println();
		if (flag) {
			while(size1 >= 0 && endSize1 > 0 && size2 >= 0 && endSize2 > 0 && (size1 < inpArr1.length) && (size2 < inpArr2.length)) {
				if (inpArr1[size1] <= inpArr2[size2]) {
					outArr[index++] = inpArr1[size1++];
				} else {
					outArr[index++] = inpArr2[size2++];
				}
			}
			while(size1 < inpArr1.length) {
				outArr[index++] = inpArr1[size1++];
			}
			while(size2 < inpArr2.length) {
				outArr[index++] = inpArr2[size2++];
			}
		} else {
			while(size1 >= 0 && endSize1 > 0 && size2 >= 0 && endSize2 > 0 && (size1 < inpArr1.length) && (size2 < inpArr2.length)) {
				if (inpArr1[size1] >= inpArr2[size2]) {
					outArr[index++] = inpArr1[size1++];
				} else {
					outArr[index++] = inpArr2[size2++];
				}
			}
			while(size1 < inpArr1.length) {
				outArr[index++] = inpArr1[size1++];
			}
			while(size2 < inpArr2.length) {
				outArr[index++] = inpArr2[size2++];
			}
		}
		
		return outArr;
	}
	
	public static void main(String args[]) {
		MSort mergesort = new MSort();
		//int[] inpArr = {6, 2, 3, 1};
		//mergesort.merSort(inpArr);
		//int[] outArr = new int[0];
		//boolean flag = false;
		int[] arr = {5, 7, 1, 2, 6, 4};
		//int[] arr = {4, 5, 6, 1, 2, 3};
		mergesort.merSort(arr);
		//mergesort.merge(arr, 0, 3, arr.length-1)
		
		/*int[][] twoArr = {{1,3,5,7}, {2,4,6,8}, {9,10,11}};
		for(int i = 0; i < twoArr.length;) {
			if (i == 0) {
				if (twoArr[i][0] < twoArr[i][twoArr[i].length-1]) {
					flag = true;
				} else {
					flag = false;
				}
				outArr = new int[twoArr[i].length*2];
				mergesort.mergeArrays(twoArr[i], twoArr[i+1], outArr, flag);
				i = i+2;
			} else {
				int[] tmpArr = new int[outArr.length];
				tmpArr = Arrays.copyOf(outArr, outArr.length);
				outArr = new int[twoArr[i].length+outArr.length];
				mergesort.mergeArrays(twoArr[i], tmpArr, outArr, flag);
				i++;
			}
		}
		
		for(int j=0; j < outArr.length; j++) {
			System.out.println(outArr[j]);
		}*/
	}
}
