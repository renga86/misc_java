
    /*
     * Complete the function below.
     */
    static int[] solve(int[] arr) {
        int oddIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (i > 0) {
                    if (i - oddIndex > 0) {
                        //System.out.printf(" Testing val: %d\t", arr[i]);
                        swap(arr, i, i - oddIndex);
                    } else {
                        swap(arr, i, oddIndex - i);
                    }
                }
            } else {
                oddIndex++;
            }
        }
        
        return arr;
    }

    static void swap(int[] arr, int i1, int i2) {
        //System.out.printf(" Testing inputs: %d%d%d%d\t", i1, i2, arr[i1], arr[i2]);
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
