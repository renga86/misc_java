package recursion;

import java.util.Arrays;

public class Subset {

	public void subsetRecur(int[] array, int i, int op_idx, int[] op) {
		if (i == array.length) {
			printSubset(op, op_idx);
			return;
		}
		
		// Exclude
		subsetRecur(array, i+1, op_idx, op);
		// Include
		op[op_idx] = array[i];
		subsetRecur(array, i+1, op_idx+1, op);
	}
	
	public boolean subsetSum(int[] array, int target, int start) {
		if (start >= array.length) return target == 0;
		
		if (subsetSum(array, target - array[start], start+1) || subsetSum(array, target, start+1)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean groupSum6(int start, int[] nums, int target) {

		if (start >= nums.length) return (target == 0);

		if (nums[start] == 6) {
			if (groupSum6(start + 1, nums, target - nums[start])) {
				return true;
			} else {
				return false;
			}
		} else {
			if (groupSum6(start + 1, nums, target - nums[start]) || (groupSum6(start + 1, nums, target))) {
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean groupNoAdj(int start, int[] nums, int target) {
		if (start >= nums.length) return (target == 0);
		
		if (groupNoAdj(start+1, nums, target - nums[start]) || groupNoAdj(start+1, nums, target)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		Subset perm = new Subset();
		int[] input = {0, 1, 2};
		int[] op = new int[input.length];
		perm.subsetRecur(input, 0, 0, op);
		
		/*int[] sum = {8, 9, 4};
		System.out.println(perm.subsetSum(sum, 15, 0));
		
		int[] sum6 = {5, 6, 2};
		System.out.println(perm.groupSum6(0, sum6, 7));*/
		
		String[] array = generate_all_subsets("apple");
		/*for(int i = 0; i < array.length; i++) {
			System.out.println(array[i].toCharArray());
		}*/
		System.out.println(Arrays.toString(array));
	}
	
	public void printSubset(int[] array, int len) {
		for (int i = 0; i < len; i++) {
			System.out.printf("%d ",array[i]);
		}
		System.out.println();
	}
	
	static class Wrapper{
        static int index;
        static String[] finalString;
    }

    /*
     * Complete the function below.
     */
    static String[] generate_all_subsets(String s) {
    		Wrapper.finalString = new String[(int) Math.pow(2, s.length())];
        
        if (s == null || s.length() == 0) return Wrapper.finalString;
        
        char[] output = new char[s.length()];
        subsetRecur(s.toCharArray(), 0, 0, output);
        
        return Wrapper.finalString;
    }

    static void subsetRecur(char[] array, int i, int op_idx, char[] output) {
		if (i == array.length) {
			addSubSet(output, op_idx);
			return;
		}
		
		// Exclude
		subsetRecur(array, i+1, op_idx, output);
		// Include
		output[op_idx] = array[i];
		subsetRecur(array, i+1, op_idx+1, output);
	}

    static void addSubSet(char[] output, int len) {
        char[] newArr = new char[len];
        for(int i = 0; i < len; i++) {
            newArr[i] = output[i];
        }
        Wrapper.finalString[Wrapper.index] = Arrays.toString(newArr);
        Wrapper.index++;
	}
}
