public class Count8 {
	public int count(int n) {

		if (n == 0) return 0;

		if ((n % 10 == 8)) {
			System.out.printf("%d\n", n);
			return 2 + count(n/10);
		} else if (n % 10 == 8) {
			return 1 + count(n/10);
		} else {
			return count(n/10);
		}
	}
	
	public boolean groupSum(int start, int[] nums, int target) {
		  
		System.out.printf(" Method call: %d\t", target);
		
		  if (nums.length == start) {
		    return target == 0;
		  }
		  
		  System.out.printf(" 1st %d, value: %d\t", start, nums[start]);
		  
		  if (groupSum(start + 1, nums, target - nums[start])) return true;
		  
		  System.out.println();
		  System.out.printf(" 2nd %d, value: %d\t", start, nums[start]);
		  
		  if (groupSum(start + 1, nums, target)) return true;
		  
		  System.out.println();
		  System.out.printf(" 3rd %d, value: %d\t", start, nums[start]);
		  
		  return false;
		}
	
	public int Fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		System.out.printf(" n: %d\n", n);
		return Fib(n-1) + Fib(n-2);
	}

	public static void main(String args[]) {
		Count8 cnt = new Count8();
		//cnt.count(8088);
		
		cnt.groupSum(0, new int[]{2,4,8}, 10);
		cnt.Fib(4);
	}
}