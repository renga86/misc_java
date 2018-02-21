
public class ReverseStack {

	private Node top;
	
	private class Node {
		private int item;
		Node link;
		
		Node(int input) {
			item = input;
			link = null;
		}
	}
	
	public void push(int i) {
		Node tmp = new Node(i);
		tmp.link = top;
		top = tmp;
	}
	
	public void pop() {
		if (top == null) 
			return;
		Node tmp;
		tmp = top;
		top = top.link;
		tmp = null;
	}
	
	public boolean isEmpty() {
		return top != null;
	}
	
	public void print() {
		Node tmp = top;
		while (tmp != null) {
			System.out.printf("%d\n", tmp.item);
			tmp = tmp.link;
		}
	}
	
	public void reverse() {
		Node curr = top;
		while (curr != null) {
			push(curr.item);
			curr = curr.link;
		}
		
		curr = top;
		pop();
		while (!isEmpty()) {
			curr.link = top;
			pop();
			curr = curr.link;
		}
		curr.link = null;
	}
	
	public static void main(String args[]) {
		ReverseStack rev = new ReverseStack();
		rev.push(1);
		//rev.push(2);
		//rev.push(3);
		//rev.pop();
		//rev.pop();
		rev.print();
		rev.reverse();
		rev.print();
	}
}
