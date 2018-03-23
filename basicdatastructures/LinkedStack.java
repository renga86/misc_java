package basicdatastructures;

import java.util.LinkedHashMap;

public class LinkedStack {

	class Node {
		Node next;
		int data;
		
		Node(int elem) {
			data = elem;
			next = null;
		}
	}
	
	private Node top;
	
	LinkedStack() {
		top = null;
	}
	
	void push(int elem) {
		Node newNode = new Node(elem);
		newNode.next = top;
		top = newNode;
	}
	
	void pop() {
		Node currNode;
		if (top == null) return;
		currNode = top;
		top = top.next;
		currNode = null;
	}
	

	static Node find_middle_node(Node head) {
		if (head == null) return null;
		int count = 0;
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<Integer, Node>();
        int size = 0;
        Node tmp = head;
        
        while(tmp != null) {
        		map.put(count, tmp);
        		tmp = tmp.next;
        		count++;
        		size++;
        }
        
        int middle = 0;
        if (size % 2 == 0) {
        		middle = (size / 2) + 1;
        } else {
        		middle = size / 2;
        }
        
        Node ret = map.get(middle);
        
        return ret;
    }
}
