package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {

	static void PrintLevelOrder(TreeNode root) {
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode topNode = q.peek();
			System.out.printf("%c\t", topNode.val);
			if (topNode.left != null)
				q.add(topNode.left);
			if (topNode.right != null)
				q.add(topNode.right);
			q.remove();
		}
		System.out.println();
	}

	static void PrintLevelkOrder(TreeNode root, int k) {
		if (root == null) return;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		if (k == 0) {
			TreeNode printNode = q.remove();
			System.out.println(printNode.val);
			return;
		}
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			
			while(nodeCount > 0) {
				TreeNode topNode = q.peek();
				System.out.println(topNode.val + " ");
				q.remove();
				if (topNode.left != null)
					q.add(topNode.left);
				if (topNode.right != null)
					q.add(topNode.right);
				nodeCount--;
			}
			System.out.println();
		}
	}
	
	static void postOrderRecur(TreeNode root) {
		if (root == null) return;
		
		postOrderRecur(root.left);
		postOrderRecur(root.right);
		System.out.printf("%c\t", root.val);
	}
	
	static void postOrderIter(TreeNode root) {
		if (root == null) return;
		
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> visitNodes = new Stack<TreeNode>();
		stack1.add(root);
		
		while (!stack1.isEmpty()) {
			TreeNode curr = stack1.peek();
			TreeNode visitNode = visitNodes.peek();
			if (curr == visitNode) {
				if (curr.right != null)
					visitNodes.add(stack1.peek());
				System.out.println(stack1.pop());
				visitNodes.pop();
			}
			else if (curr.left != null) {
				stack1.push(curr.left);
			} else {
				System.out.println(stack1.pop());
				curr = stack1.peek();
				if (curr.right != null)
					visitNodes.add(stack1.peek());
				else
					System.out.println(stack1.pop());
				visitNodes.add(stack1.peek());
			}
		}
	}
	
	static void printAllPaths(TreeNode endNode, Stack<Character> queue) {
		//System.out.printf(" endNode.val: %c ", endNode.val);
		//System.out.println(" printing element ");
		if (endNode == null) {
			return;
		}
		if (endNode != null && endNode.left == null && endNode.right == null) {
			queue.add(endNode.val);
			printPath(queue);
			return;
		}
		queue.add(endNode.val);
		printAllPaths(endNode.left, queue);
		printAllPaths(endNode.right, queue);
		queue.pop();
	}
	
	
	static void printPath(Stack<Character> que) {
		for (Character s: que) {
			System.out.printf("%c\t", s);
		}
		que.pop();
		System.out.println();
	}
	
	static void findLCA(TreeNode root, char n1, char n2) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		ArrayList<TreeNode> a1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> a2 = new ArrayList<TreeNode>();
		pathToNode(root, s1, n1, a1);
		/*for(Character c1: a1) {
			System.out.printf("%c\t", c1);
		}*/
		System.out.println();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		pathToNode(root, s2, n2, a2);
		/*for(Character c2: a2) {
			System.out.printf("%c\t", c2);
		}*/
		
		for(int i = 0; i < a1.size(); i++) {
			for(int j = 0; j < a2.size(); j++) {
				if (a2.get(j) == a1.get(i)) {
					System.out.printf("LCA: %c", (char)a1.get(i).val);
					i = a1.size();
					break;
				}
			}
		}
	}
	
	static void pathToNode(TreeNode root, Stack<TreeNode> stack1, char s1, ArrayList<TreeNode> a1) {
		if (root == null)
			return;
		
		if (root.val == s1) {
			while(!stack1.isEmpty()) {
				TreeNode curr = stack1.pop();
				a1.add(curr);
			}
		} else {
			stack1.add(root);
			pathToNode(root.left, stack1, s1, a1);
			pathToNode(root.right, stack1, s1, a1);
			if (!stack1.isEmpty())
				stack1.pop();
		}
	}
	
	public static void main(String args[]) {
		/*Code To Test the logic
	  Creating an example tree
	            M
			   / \
			  B   Q
			 / \   \
			A   C   Z
		 */
		TreeNode root = null;
		root = TreeNode.Insert(root,'F'); root = TreeNode.Insert(root,'D');
		root = TreeNode.Insert(root,'J'); root = TreeNode.Insert(root,'B'); 
		root = TreeNode.Insert(root,'E'); root = TreeNode.Insert(root,'G');
		root = TreeNode.Insert(root,'K'); root = TreeNode.Insert(root,'A');
		root = TreeNode.Insert(root,'C'); root = TreeNode.Insert(root,'I');
		root = TreeNode.Insert(root,'H'); 
		
		
		//Print Nodes in Level Order. 
		//PrintLevelOrder(root);
		//System.out.println();
		//PrintLevelkOrder(root, 1);
		//System.out.println();
		//System.out.println("Recursive Post-order");
		//postOrderRecur(root);
		//System.out.println();
		System.out.println("Iterative Post-order");
		postOrderIter(root);
		//Stack<Character> que = new Stack<Character>();
		//printAllPaths(root, que);
		
		//System.out.println(" LCA ");
		//findLCA(root, 'A', 'C');
	}
}

