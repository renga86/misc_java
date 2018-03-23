    /*
     * Complete the function below.
     */
    /*static String[] findZeroSum(int[] arr) {
        // Write your code here.
        Arrays.sort(arr);
        for(int i=0; i < arr.length; i++)
            System.out.println(arr[i]);
        ArrayList<String> list = new ArrayList<String>();
        for(int k = 0; k < arr.length; k++) {
            int elem = arr[k];
            for(int j = k+1; j < arr.length; j++) {
                for(int i = j+1; i < arr.length; i++) {
                    if (arr[i] + arr[j] + elem == 0) {
                        if (mid != -1) {
                    		String items = Integer.toString(elem) + "," + Integer.toString(arr[j]) + "," + Integer.toString(arr[i]);
                        // Prevent Duplicates
                        if (!(list.contains(items)))
                            list.add(items);
                        }
                        String items = Integer.toString(elem) + "," + Integer.toString(arr[j]) + "," + Integer.toString(arr[i]);
                        // Prevent Duplicates
                        if (!(list.contains(items)))
                            list.add(items);
                    }
                }
            }
        }
        
        return list.toArray(new String[list.size()]);
    }*/

    static String[] findZeroSum(int[] arr) {
		int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        
        // Major performance improvement over ArrayList contains()
        Set<String> list = new LinkedHashSet<String>();
        for(int k = 0; k < copy.length-2; k++) {
            int elem = copy[k];
            for(int j = k+1; j < copy.length-1; j++) {
                    int Sum = elem + copy[j];
                    int mid = BinarySearch(copy, -Sum, j+1, copy.length);
                    if (mid != -1) {
                    		String items = Integer.toString(elem) + "," + Integer.toString(copy[j]) + "," + Integer.toString(copy[mid]);
                        // Prevent Duplicates
                        list.add(items);
                        
                        //for(String s: list)
                    }
            }
        }
        
        return list.toArray(new String[list.size()]);
    }

    static int BinarySearch(int[] arr, int target, int start, int end) {
    		int low = start, high = end-1;
    		while (low <= high) {
			int mid = low + (high -low) / 2;
			if (arr[mid] == target) return mid;
			else if (target < arr[mid]) high = mid - 1;
			else low = mid + 1;
		}
		
		return -1;
    }
