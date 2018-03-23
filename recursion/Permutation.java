package recursion;

import java.util.Arrays;

public class Permutation {

	static String[] output;
	
	public void permute(char[] array, int k) {
		if (k == array.length) {
			printPerm(array, k);
			return;
		}
		
		for(int i = k; i < array.length; i++) {
			System.out.printf("%d: %d\t", i, k);
			swap(array, i, k);
			permute(array, k+1);
			System.out.printf("%c: %c\t", array[i], array[k]);
			swap(array, i, k);
		}
		
	}
	
	public static void main(String args[]) {
		Permutation perm = new Permutation();
		String input = "ABC";
		perm.permute(input.toCharArray(), 0);
		
		StringBuilder test = new StringBuilder();
		test.append(1).append("->");
		System.out.println(test.toString());
		
		//System.out.println("abcd".substring(2));
		String[] out = perm.generate_all_substrings("abcd");
		System.out.println(Arrays.toString(out));
	}
	
	public void printPerm(char[] array, int len) {
		for (int i = 0; i < len; i++) {
			System.out.printf("%c",array[i]);
		}
		System.out.println();
	}
	
	public void swap(char[] array, int i, int j) {
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	static String[] generate_all_expressions(String s, long target) {
		
		return output;
    }
	
	public String[] generate_all_substrings(String s) {
		String[] output = new String[100];
		int index = 0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j <= s.length(); j++) {
				output[index] = s.substring(i, j);
				if (!palindrome(output[index])) {
					output[index] = "";
				}
				index++;
			}
		}
		
		return output;
	}
	
	private boolean palindrome(String str) {
		int i = 0, j = str.length()-1;
		return paliRecur(str, i, j);
	}

	private boolean paliRecur(String str, int i, int j) {
		if (str == null || str.length() == 0 || i == j)
			return true;

		if (str.charAt(i) == str.charAt(j)) {
			paliRecur(str, i++, --j);
		} else {
			return false;
		}
		
		return true;
	}
 }