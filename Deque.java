import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	
	private final Node head;
	private int size = 0;
	
	private class Node {
		Item item;
		Node prev;
		Node next;
		
		private Node() {
			item = null;
			prev = null;
			next = null;
		}
		
		private Node(Item input, Node pre, Node nex) {
			item = input;
			this.prev = pre;
			this.next = nex;
		}
	}
	
	public Deque() {
		head = new Node();
		head.prev = head;
		head.next = head;
		size = 0;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		if (item == null)
			throw new IllegalArgumentException(" Null item passed");
		
		Node curr = head.next;
		Node newNode = new Node(item, head, curr);
		head.next = newNode;
		curr.prev = newNode;
		
		size++;
	}
	
	public void addLast(Item item) {
		if (item == null)
			throw new IllegalArgumentException(" Null item passed");
		
		Node curr = head.prev;
		Node newNode = new Node(item, curr, head);
		curr.next = newNode;
		head.prev = newNode;
		
		size++;
	}
	
	public Item removeFirst() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("No such element");
		}
		
		Node curr = head.next.next;
		Node del = head.next;
		Item item = del.item;
		head.next = curr;
		head.next.prev = head;
		del = null;
		size--;
		
		return item;
	}
	
	public Item removeLast() {
		if (isEmpty()) {
			throw new java.util.NoSuchElementException("No such element");
		}
		
		Node curr = head.prev.prev;
		Node del = head.prev;
		Item item = del.item;
		//System.out.println(curr.item);
		//System.out.println(del.item);
		head.prev = curr;
		head.prev.next = head;
		del = null;
		size--;
		
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = head.next;
		
		public boolean hasNext() {
			return current != head;
		}

		public Item next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException("No such element");
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operation unsupported");
		}
	}
	
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addLast(5);
		deque.addFirst(4);
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addLast(6);
		deque.addFirst(1);
		deque.removeLast();
		deque.removeLast();
		deque.addLast(7);
		deque.removeLast();
		deque.removeLast();
		deque.removeLast();
		//deque.removeLast();
		//deque.removeLast();
		//deque.removeLast();
		
		for (Integer item:deque) {
			for (Integer item1: deque) {
				System.out.println(item1.intValue());
			}
			System.out.println(item.intValue());
		}
	}
}