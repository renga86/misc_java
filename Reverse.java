import java.util.LinkedHashMap;

public class Reverse {
	
	private Node head;
	
	private class Node {
		private int item;
		Node next;
		
		Node(int input) {
			item = input;
			next = null;
		}
	}
	
	Reverse() {
		head = null;
	}
	
	public void insert(int i) {
		Node node = new Node(i);
		if (head == null) {
			head = node;
			return;
		}
		Node tmp = head;
		node.next = tmp;
		head = node;
	}
	
	public void reverseIter() {
		Node curr = head;
		Node prev = null, nextnd;
		while (curr != null) {
			nextnd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextnd;
		}
		head = prev;
	}
	
	public void reverseRecur() {
		reverseRecurInternal(head);
	}
	
	public void reverseRecurInternal(Node p) {
		if (p.next == null) {
			head = p;
			return;
		}
		reverseRecurInternal(p.next);
		Node tmp = p.next;
		tmp.next = p;
		p.next = null;
	}
	
	public void reverseRecurHead() {
		head = reverseRecurHeadInternal(head);
	}
	
	public Node reverseRecurHeadInternal(Node p) {
		if (p.next == null) {
			head = p;
			return head;
		}
		head = reverseRecurHeadInternal(p.next);
		if (head.next == null) {
			head.next = p;
		} else {
			Node tmp = p.next;
			tmp.next = p;
			p.next = null;
		}
		return head;
	}
	
	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.printf("%d\n", curr.item);
			curr = curr.next;
		}
	}
	
	public static void main(String args[]) {
		Reverse rev = new Reverse();
		rev.insert(30);
		rev.insert(20);
		rev.insert(10);
		rev.print();
		
		System.out.println(" Printing reverse recursively with global head ");
		rev.reverseRecur();
		rev.print();
		
		System.out.println(" Printing reverse iteratively ");
		rev.reverseIter();
		rev.print();
		
		System.out.println(" Printing reverse recursively without global head");
		rev.reverseRecurHead();
		rev.print();
		
		System.out.println(Integer.valueOf("658") + Integer.valueOf("789"));
	}
}
