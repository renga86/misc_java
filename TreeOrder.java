import java.util.LinkedList;
import java.util.Queue;

public class TreeOrder {

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
	
	TreeOrder() {
		root = null;
	}
	
	private void LevOrder() {
		LevOrderInternal(root);
	}
	
	void LevOrderInternal(Node root) {
		if (root == null) return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.peek();
			System.out.printf("%d\t", curr.data);
			if (curr.left != null) q.add(curr.left);
			if (curr.right != null) q.add(curr.right);
			q.remove();
		}
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
	
	void PreOrder() {
		PreOrderInt(root);
	}
	
	void PostOrder() {
		PostOrderInt(root);
	}

	void InOrder() {
		InOrderInt(root);
	}
	
	private void PreOrderInt(Node root) {
		if (root == null) return;
		System.out.printf("%d\t", root.data);
		PreOrderInt(root.left);
		PreOrderInt(root.right);
	}
	
	private void PostOrderInt(Node root) {
		if (root == null) return;
		PostOrderInt(root.left);
		PostOrderInt(root.right);
		System.out.printf("%d\t", root.data);
	}
	
	private void InOrderInt(Node root) {
		if (root == null) return;
		InOrderInt(root.left);
		System.out.printf("%d\t", root.data);
		InOrderInt(root.right);
	}
	
	public static void main(String args[]) {
		TreeOrder node = new TreeOrder();
		node.Insert(15);
		node.Insert(7);
		node.Insert(20);
		node.Insert(25);
		node.Insert(8);
		node.Insert(12);
		node.Insert(30);
		
		node.LevOrder();
		System.out.println();
		node.PreOrder();
		System.out.println();
		node.PostOrder();
		System.out.println();
		node.InOrder();
	}
}
