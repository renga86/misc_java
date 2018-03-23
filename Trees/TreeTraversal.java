package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	private Node root;
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}
	
	public TreeTraversal() {
		root = null;
	}
	
	public boolean lookup(int data) {
		return(lookup(root, data));
	}
	
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return(false);
		}
		
		if (data == node.data) {
			return (true);
		}
		else if (data < node.data) {
			return(lookup(node.left, data));
		}
		else {
			return(lookup(node.right, data));
		}
	}
	
	public void insert(int data) {
		root = insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		}
		else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			}
			else {
				node.right = insert(node.right, data);
			}
		}
		
		return (node);
	}
	
	public void build123c() {
		root = null;
		root = insert(root, 2);
		root = insert(root, 1);
		root = insert(root, 3);
	}
	
	public void inorderPrintTree() {
		inorderPrint(root);
		System.out.println();
	}
	
	private void inorderPrint(Node node) {
		if (node == null) return;
		
		// left, node, right
		inorderPrint(node.left);
		System.out.println(node.data);
		inorderPrint(node.right);
	}
	
	public void printPostOrder() {
		postorderPrint(root);
		System.out.println();
	}
	
	private void postorderPrint(Node node) {
		if (node == null) return;
		
		postorderPrint(node.left);
		postorderPrint(node.right);
		
		System.out.println(node.data);
	}
	
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	
	public void printPreOrder(Node node) {
		
		// root, left, right
		System.out.println(node.data);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public void levelorderPrint() {
		if (root == null) return;
		
		printlevelOrder(root);
	}
	
	public void printlevelOrder(Node node) {
		if (node == null) return;
		
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			Node curr = nodes.remove();
			if (curr.left != null) {
				nodes.add(curr.left);
			}
			if (curr.right != null) {
				nodes.add(curr.right);
			}
		}
	}
	
	
	public int heightTree() {
		if (root == null) return -1;
		
		return heightTreeRecur(root);
	}
	
	public int heightTreeRecur(Node node) {
		if (node == null) return -1;
		
		int leftHeight = heightTreeRecur(node.left);
		int rightHeight = heightTreeRecur(node.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean checkBST1() {
		if (root == null) return false;
		
		return checkBST1Recur(root);
	}
	
	public boolean checkBST1Recur(Node node) {
		if (node == null) return true;
		
		if (isSubTreeLesser(node.left, node.data) && isSubTreeGreater(node.right, node.data) &&
				checkBST1Recur(node.left) && checkBST1Recur(node.right)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isSubTreeLesser(Node node, int currVal) {
		
		if (root == null) return true;
		
		if(node.data <= currVal && isSubTreeLesser(node.left, currVal) &&
				isSubTreeLesser(node.right, currVal)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isSubTreeGreater(Node node, int currVal) {
		
		if (root == null) return true;
		
		if(node.data > currVal && isSubTreeGreater(node.left, currVal) &&
				isSubTreeGreater(node.right, currVal)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBST2() {
		if (root == null) return false;
		
		return isBST2recur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST2recur(Node node, int min, int max) {
		
		if (node.data > min && node.data < max &&
				isBST2recur(node.left, min, node.data) &&
				isBST2recur(node.right, node.data, max)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBST3() {
		if (root == null) return false;
		
		return isBST3(root);
	}
	
	static class Wrapper {
		static int prevMin;
		static int level;
	}
	
	private boolean isBST3(Node node) {
		
		if (root == null) return true;
		
		isBST3(node.left);
		if (node.data > Wrapper.prevMin) {
			Wrapper.prevMin = node.data;
		} else {
			return false;
		}
		isBST3(node.right);
		
		return true;
	}
	
	Node prev;
	
	// avoid static variable counter and use prev Node
	public boolean isBST4(Node node) {
				
		if(node != null) {
			if (!isBST4(node.left))
				return false;
			
			if (prev != null && node.data <=  prev.data)
				return false;
			
			prev = node;
			
			return isBST4(node.right);
		}
	
		return true;
	}
	
	public int getLevel(int key) {
		if (root == null) return 0;
		
		getlevelrecur1(root, key, 1);
		
		return Wrapper.level;
	}
	
	private void getlevelrecur1(Node node, int key, int level) {
		
		if (node == null) return;
		
		if (node.data == key) {
			Wrapper.level = level;
		} else {
			getlevelrecur1(node.left, key, level++);
			getlevelrecur1(node.right, key, level++);
		}
	}
	
	int getlevelrecur2(Node node, int data, int level) {
		
		if (node == null) return 0;
		
		if (node.data == level) return level;
		
		int downlevel = getlevelrecur2(node.left, data, level+1);
		if (downlevel != 0)
			return downlevel;
		
		downlevel = getlevelrecur2(node.right, data, level+1);
		return downlevel;		
	}
	
	public void levelprintrecur() {
		if (root == null) return;
		
		levelorderrecurprint(root);
	}
	
	private void levelorderrecurprint(Node node) {
		
		int height = heightTree();
		for(int i=1;i <= height+1; i++) {
			levelutil(node, i);
		}
	}
	
	private void levelutil(Node node, int level) {
		if (root == null) return;
		
		if (level == 1) {
			System.out.println(node.data);
		} else {
			levelutil(node.left, level--);
			levelutil(node.right, level--);
		}
	}
	
	public void printpreorderIter(Node node) {
		Stack<Node> preorder = new Stack<Node>();
		
		preorder.push(node);
		
		while(!preorder.isEmpty()) {
			Node curr = preorder.pop();
			System.out.printf("%d\t", curr.data);
			if (curr.right != null) {
				preorder.push(curr.right);
			}
			if (curr.left != null) {
				preorder.push(curr.right);
			}
		}
	}
	
	public List<Integer> inorderIter() {
		if (root == null) return null;
		
		return inorderiterutil(root);
	}
	
	private List<Integer> inorderiterutil(Node root) {
        List<Integer> items = new LinkedList<Integer>();
        if (root == null) return items;
        
		Stack<Node> inorder = new Stack<Node>();
		
		inorder.push(root);
		Node curr = inorder.peek();
		
		while(!inorder.isEmpty()) {
			if (curr != null && curr.left != null) {
				inorder.push(curr.left);
				curr = curr.left;
			} else {
				Node recent = inorder.pop();
				//System.out.printf("%d\t", recent.val);
                items.add(recent.data);
				if (recent.right != null) {
					inorder.push(recent.right);
                    curr = recent.right;
				}
			}
		}
        
        return items;
	}
	
    public List<Integer> postorderTraversal() {
    	     List<Integer> items = new LinkedList<Integer>();
    	     if (root == null) return items;
    	     
    	     postorderiterutil(root, items);
    	     
    	     return items;
    }
    
    private void postorderiterutil(Node root, List<Integer> items) {
    		
    		Stack<Node> postorder = new Stack<Node>();
    		Stack<Node> printorder = new Stack<Node>();
    		
    		postorder.push(root);
    		    		
    		while(!postorder.isEmpty()) {
    			Node curr = postorder.peek();
    			printorder.push(curr);
    			postorder.pop();
    			if (curr.left != null) postorder.push(curr.left);
    			if (curr.right != null) postorder.push(curr.right);
    		}
    		
    		while(!printorder.isEmpty()) {
    			System.out.printf("%d\t", printorder.peek().data);
    			items.add(printorder.pop().data);
    		}
    }
}