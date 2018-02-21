
public class BSTNode {

	private class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	
	BSTNode() {
		root = null;
	}
	
	public void Insert(int key) {
		root = insertRec(root, key);
	}
	
	private Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key <= root.data) {
			root.left = insertRec(root.left, key);
		} else {
			root.right = insertRec(root.right, key);
		}
		
		return root;
	}
	
	public boolean search(int key) {
		return searchRec(root, key);
	}
	
	private boolean searchRec(Node root, int key) {
		if (root == null) {
			return false;
		} else if (key < root.data) {
			return searchRec(root.left, key);
		} else if (key > root.data) {
			return searchRec(root.right, key);
		} else {
			return true;
		}
	}
	
	public int maximum() {
		return maxRec(root);
	}
	
	private int maxRec(Node root) {
		if (root == null)
			return -1;
		
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}
	
	public int maxRecur() {
		return maxInternalRecur(root);
	}
	
	private int maxInternalRecur(Node root) {
		if (root == null)
			return -1;
		
		int max = -1;
		max = maxInternalRecur(root.right);
		if (max < root.data) {
			max = root.data;
		}
		
		return max;
	}
	
	public int minRecur() {
		return minInternalRecur(root);
	}
	
	private int minInternalRecur(Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		
		int min = Integer.MAX_VALUE;
		min = minInternalRecur(root.left);
		if (min > root.data) {
			min = root.data;
		}
		
		return min;
	}
	
	public int min() {
		return minRec(root);
	}
	
	private int minRec(Node root) {
		if (root == null)
			return -1;
		
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}
	
	public int Height() {
		return HeightInternal(root);
	}
	
	private int HeightInternal(Node root) {
		if (root == null)
			return -1;
		
		return 1 + Math.max(HeightInternal(root.left), HeightInternal(root.right));
	}
	
	public boolean isBST() {
		return isBSTInternal(root);
	}
	
	private boolean isSubTreeGreater(Node root, int val) {
		if (root == null) return true;
		
		if (root.data > val && isSubTreeGreater(root.left, val) &&
				isSubTreeGreater(root.right, val)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isSubTreeLesser(Node root, int val) {
		if (root == null) return true;
		
		if (root.data <= val && isSubTreeLesser(root.left, val) &&
				isSubTreeLesser(root.right, val)) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isBSTInternal(Node root) {
				
		if (root == null)
			return true;
		
		/*if (root.left != null && root.left.data <= root.data) {
			System.out.printf(" left: %d\n", root.data);
			isLeft = isBSTInternal(root.left);
		} else if (root.right != null && root.right.data > root.data) {
			System.out.printf(" right: %d\n", root.data);
			isRight = isBSTInternal(root.right);
		} */
		
		if (isSubTreeLesser(root.left, root.data) && 
				isSubTreeGreater(root.right, root.data) &&
				isBSTInternal(root.left) &&
				isBSTInternal(root.right)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		BSTNode node = new BSTNode();
		node.Insert(15);
		node.Insert(7);
		node.Insert(1);
		/*node.Insert(25);
		node.Insert(8);
		node.Insert(12);
		node.Insert(30);*/
		System.out.printf(" Search return val: " + node.search(50));
		System.out.println();
		System.out.printf(" Max val (Iter): " + node.maximum());
		System.out.println();
		System.out.printf(" Min val (Iter): " + node.min());
		System.out.println();
		
		System.out.printf(" Max val (Recur): " + node.maxRecur());
		System.out.println();
		System.out.printf(" Min val (Recur): " + node.minRecur());
		System.out.println();
		
		System.out.printf(" Height of tree: " + node.Height());
		System.out.println();
		
		System.out.printf(" isBST(): " + node.isBST());
		System.out.println();
		
		
		
	}
}