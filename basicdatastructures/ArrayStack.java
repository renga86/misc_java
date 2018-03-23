package basicdatastructures;

public class ArrayStack {
	
	private int[] inpArr;
	private int top;
	private static final int CAP = 101;
	
	ArrayStack(int capacity) {
		inpArr = new int[capacity];
		top = -1;
	}
	
	public void push(int elem) throws Exception {
		if (top == CAP - 1) {
			System.out.println(" Stack overflown");
			return;
		}
		inpArr[++top] = elem;
	}
	
	public void pop() throws Exception {
		if (top == -1) {
			System.out.println(" No element to pop");
			return;
		}
		top--;
	}
	
	public int Top() {
		return inpArr[top];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return (top == 0);
	}
	
	
}
