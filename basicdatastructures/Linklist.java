package basicdatastructures;

import java.util.Stack;


class Node {
	Node next;
	int data;
	
	Node(int elem) {
		data = elem;
		next = null;
	}
}

public class Linklist {
	
	private Node head;
	
	Linklist() {
		head = null;
	}
	
	void insertNth(int data, int pos) {
		Node newNode = new Node(data);
		int tmp = 0;
		Node curr = head;
		if (pos == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}
		while (tmp < pos - 2) {
			curr = curr.next;
			tmp++;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
	}
	
	void deleteNth(int pos) {
		Node tmp1 = head;
		int tmpPos = 0;
		if (pos == 1) {
			head = tmp1.next;
			tmp1 = null;
			return;
		}
		while(tmpPos < pos - 2) {
			tmp1 = tmp1.next;
			tmpPos++;
		}
		
		if (tmp1.next != null) {
			Node tmp2 = tmp1.next;
			tmp1.next = tmp2.next;
			tmp2 = null;
		}
	}
	
	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.printf("%d\t", curr.data);
			curr = curr.next;
		}
	}
	
	public void reverseList() {
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
	
	public void printRevRecur() {
		printRecur(head, false);
	}
	
	public void printRecur(Node node, boolean val) {
		if (node == null) {
			return;
		}
		
		if (val)
			System.out.printf("%d\t", node.data);
		printRecur(node.next, val);
		if (!val)
			System.out.printf("%d\t", node.data);
	}
	
	public void printForRecur() {
		printRecur(head, true);
	}
	
	public String reverseString(String input) {
		Stack<Character> st = new Stack<Character>();
		char[] inpArr = input.toCharArray();
		for(int i = 0; i < inpArr.length; i++) {
			st.push(inpArr[i]);
		}
		for(int j = 0; j < inpArr.length; j++) {
			inpArr[j] = st.pop();
		}
		
		return new String(inpArr);
	}
	
	static int sum(Linklist l1, Linklist l2) {
		l1.print();
		l2.print();
		return 0;
	}
	
	public static void main(String args[]) {
		/*Linklist list = new Linklist();
		list.insertNth(1, 1);
		list.insertNth(2, 2);
		list.insertNth(3, 3);
		list.insertNth(4, 2);
		list.print();
		
		System.out.println();
		list.deleteNth(2);
		list.deleteNth(3);
		list.print();
		
		System.out.println();
		list.insertNth(5, 2);
		list.insertNth(6, 3);
		list.print();
		System.out.println();
		//list.reverseList();
		//list.print();
		
		list.printForRecur();
		System.out.println();
		list.printRevRecur();*/
		
		/*Linklist list1 = new Linklist();
		list1.insertNth(1, 1);
		list1.insertNth(2, 2);
		list1.insertNth(3, 9);*/
		
		Linklist list2 = new Linklist();
		list2.insertNth(1, 1);
		list2.insertNth(2, 2);
		list2.insertNth(3, 3);
		list2.insertNth(4, 4);
		list2.insertNth(7, 5);
		list2.insertNth(0,6);
		list2.insertNth(5,7);
		list2.insertNth(9,8);
		list2.print();
		System.out.println();
		
		//list2.insertNth(3, 9);
		
		//System.out.println(list.reverseString("hello"));
		
		//System.out.printf("%d\n", sum(list1,list2));
		
		Node n3 = list2.oddEvenList(list2);
		while (n3 != null) {
			System.out.printf("%d\t", n3.data);
			n3 = n3.next;
		}
		
		/*Node n3 = list2.swap_nodes(list2, 4);
		while (n3 != null) {
			System.out.printf("%d\t", n3.data);
			n3 = n3.next;
		}*/
	}
	
	public Node oddEvenList(Linklist list2) {
		Node oddNodes = new Node(0);
		Node oddNodesIter = oddNodes;
		Node evenNodes = new Node(0);
		Node evenNodesIter = evenNodes;
		Node curr = head;
        
        while (oddNodes != null && evenNodes != null && curr != null && curr.next != null) {
            oddNodes.next = curr;
            evenNodes.next = curr.next;
            curr = curr.next.next;
            oddNodes = oddNodes.next;
            evenNodes = evenNodes.next;
            //System.out.printf(" Odd: %d\t ", oddNodes.data);
        }
        
        if (curr != null) {
        		oddNodes.next = curr;
        		oddNodes = oddNodes.next;
    		}
        oddNodes.next = null;
        evenNodes.next = null;
       
        Node modList = head;
        /*while(oddNodesIter != null) {
        		System.out.printf("Odd: %d\t", oddNodesIter.data);
        		oddNodesIter = oddNodesIter.next;
        }
        while(evenNodesIter != null) {
    			System.out.printf("Even: %d\t", evenNodesIter.data);
    			evenNodesIter = evenNodesIter.next;
        }*/
        //evenNodesIter = 
        oddNodesIter = oddNodesIter.next;
        evenNodesIter = evenNodesIter.next;
        while(oddNodesIter.next != null) {
            modList = oddNodesIter;
            modList = modList.next;
            oddNodesIter = oddNodesIter.next;
        }
        
        while(evenNodesIter != null) {
            modList.next = evenNodesIter;
            modList = modList.next;
            evenNodesIter = evenNodesIter.next;
        }
        
        return head;
    }
	
	public Node swap_nodes(Linklist node, int k) {
        Node curr = head;
        int size = 0;
        Node small = head;
        Node big = head;
        
        while (curr != null) {
            curr = curr.next;
            size++;
            if (size < k-1) {
            		small = small.next;
            }
        }
        
        int endIndex = size - k;
        
        for(int j = 0; j < endIndex - 1; j++) {
            big = big.next;
        }
        
        if (k == 1 || k == size) {
        		Node tmp1 = head.next;
        		Node tmp2 = head;
        		Node tmp3 = null;
        		if (k == 1)
        			tmp3 = big.next;
        		else
        			tmp3 = small.next;
        		
        		tmp2.next = null;
        		head = tmp3;
        		head.next = tmp1;
        		
        		if (k == 1) {
        			big.next = tmp2;
        			big.next.next = null;
        		} else {
        	 		small.next = tmp2;
            		small.next.next = null;
        		}
        				
        		return head;
        }
        
       System.out.printf(" Small: %d, Big: %d \n", small.data, big.data);
        if (small != big) {
	        	Node tmp1 = small.next;
	        	Node tmp2 = big.next;
	        	Node tmp3 = small.next.next;
	        	Node tmp4 = big.next.next;
	
	        	tmp1.next = null;
	        	
	        	tmp2.next = null;
	
	        	small.next = tmp2;
	        	small.next.next = tmp3;
	
	        	big.next = tmp1;
	        	big.next.next = tmp4;
        }
        
        return head;
    }
}