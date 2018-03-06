    static int[] mergeArrays(int[][] twoArr) {
        boolean flag = false;
        int[] outArr = new int[0];
        for(int i = 0; i < twoArr.length;) {
			if (i == 0) {
				if (twoArr[i][0] < twoArr[i][twoArr[i].length-1]) {
					flag = true;
				} else {
					flag = false;
				}
				outArr = new int[twoArr[i].length*2];
				mergeArrays(twoArr[i], twoArr[i+1], outArr, flag);
				i = i+2;
			} else {
				int[] tmpArr = new int[outArr.length];
				tmpArr = Arrays.copyOf(outArr, outArr.length);
				outArr = new int[twoArr[i].length+outArr.length];
				mergeArrays(twoArr[i], tmpArr, outArr, flag);
				i++;
			}
		}
        
        return outArr;
    }

    static void mergeArrays(int[] inpArr1, int[] inpArr2, int[] outArr, boolean flag) {
		int index = 0;
		int size1 = 0, size2 = 0;
		int endSize1 = inpArr1.length, endSize2 = inpArr2.length;
		
		while(size1 >= 0 && endSize1 > 0 && size2 >= 0 && endSize2 > 0 && (size1 < inpArr1.length) && (size2 < inpArr2.length)) {
            if (flag) {
			     if (inpArr1[size1] <= inpArr2[size2]) {
				    outArr[index++] = inpArr1[size1++];
			     } else {
				    outArr[index++] = inpArr2[size2++];
			     }
            } else {
                if (inpArr1[size1] >= inpArr2[size2]) {
					outArr[index++] = inpArr1[size1++];
				} else {
					outArr[index++] = inpArr2[size2++];
				}
            }
		}
		while(size1 < inpArr1.length) {
			outArr[index++] = inpArr1[size1++];
		}
		while(size2 < inpArr2.length) {
			outArr[index++] = inpArr2[size2++];
		}
	}
