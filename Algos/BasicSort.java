package Algos;

public class BasicSort {

	static void BubbleSort(int[] arr) {
		for(int k = 0; k < arr.length-1; k++) {
			for(int j=0; j <= arr.length-k-2; j++) {
				if (arr[j] > arr[j+1])
					swap(arr, j, j+1);
			}
		}
	}
	
	static void insertSort(int[] arr) {
		for(int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j-1;
			while (i > 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i = i -1;
			}
			arr[i+1] = key;
		}
	}
	
	static void selectSort(int[] arr) {
		for(int i=0; i < arr.length; i++) {
			int min = i;
			for(int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, min, i);
		}
	}
	
	static void stableSelSort(int[] arr) {
		for(int i=0; i < arr.length-1; i++) {
			int min = i;
			for(int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}				
			}
			int key = arr[min];
			while (min > i) {
				arr[min] = arr[min - 1];
				min--;
			}
			arr[i] = key;
		}
	}
	
	public static void main(String args[]) {
		int[] inpArr = {3, 2, -1, 9, 7, 5, 1};
		BubbleSort(inpArr);
		System.out.println(" Bubble Sort: ");
		for(int i=0; i < inpArr.length; i++) {
			System.out.printf("%d\t", inpArr[i]);
		}
		
		System.out.println();
		System.out.println(sortCharacters("testing"));
		int[] arr = {1, 2, 3, 4, 5, 5, 7, 8};
		for(int i = 0; i < arr.length; i++) {
			int resu = (i+1) ^ arr[i];
			if (resu != 0)
				System.out.println(i+1);
		}
		
		int[] inpArr1 = {3, 2, -1, 9, 7, 5, 1};
		selectSort(inpArr1);
		System.out.println(" Selection Sort: ");
		for(int i=0; i < inpArr1.length; i++) {
			System.out.printf("%d\t", inpArr1[i]);
		}
		
		int[] inpArr2 = {3, 2, -1, 9, 1, 5, 1};
		stableSelSort(inpArr2);
		System.out.println();
		System.out.println(" Stable Selection Sort: ");
		for(int i=0; i < inpArr2.length; i++) {
			System.out.printf("%d\t", inpArr2[i]);
		}
		
		//System.out.printf(" xor result: : %d", resu);
	}
	
	static String sortCharacters(String inString) {
        /*char[] chars = inString.toCharArray();
        
        Arrays.sort(chars);
        String s = new String(chars);*/
		
		/*Character[] charsArr = new Character[inString.length()];
		for(int i = 0; i < inString.length(); i++) {
			charsArr[i] = inString.charAt(i);
		}
        
		Arrays.sort(charsArr, new Comparator<Character>() {
			public int compare(Character c1, Character c2) {
				return Character.compare(c1, c2);
			}
		});
		
        StringBuilder sb = new StringBuilder(charsArr.length);
        for (Character c : charsArr)
            sb.append(c.charValue());
        
        return sb.toString();*/
		
		char[] inpArr = inString.toCharArray();
		int[] asciiArr = new int[256];
		
		for(int i = 0; i < inpArr.length; i++) {
			int asciiVal = inpArr[i];
			asciiArr[asciiVal]++;
		}
		
		int index = 0;
		for(int j=0; j < asciiArr.length; j++) {
			if (asciiArr[j] > 0) {
				while (true) {
					inpArr[index] = (char)j;
					asciiArr[j]--;
					index++;
					if (asciiArr[j] <= 0) break;
				}
			}
		}
		
		String s = new String(inpArr);
		
		return s;
    }
	
	static void swap(int[] arr1, int i, int j) {
		int tmp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = tmp;
	}
}
