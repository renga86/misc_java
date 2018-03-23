import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.algs4.MaxPQ;


class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TreeOrder {

	private Node root;
	
	TreeOrder() {
		root = null;
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
	
	public Node Insert(int key) {
		root = insertRec(root, key);
		return root;
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
	
	public Node mergeTrees(Node n1, Node n2) {
		Queue<Node> q1 = new LinkedList<>();
		storeNodes(n1, q1);
		int size1 = q1.size();
		int i = 0, j = 0;
		int[] arr1 = new int[q1.size()];
 		while (!q1.isEmpty()) {
			Node node = q1.remove();
			arr1[i++] = node.data;
		}
		Queue<Node> q2 = new LinkedList<>();
		storeNodes(n2, q2);
		int size2 = q2.size();
		int[] arr2 = new int[q2.size()];
		while (!q2.isEmpty()) {
			Node node = q2.remove();
			arr2[j++] = node.data;
		}
		
		int[] arr3 = new int[size1+ size2];
		mergeArrays(arr1, arr2, arr3);
		
		Node root3 = null;
		for(int m = 0; m < arr3.length; m++) {
			root3 = insertRec(root3, arr3[m]);
		}
		
		return root3;
	}
	
	private void mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
		
		int high1 = arr1.length-1, high2 = arr2.length-1, low1 = 0, low2 = 0;
		int low3 = 0;
		while(low2 <= high2 && low1 <= high1) {
			if (arr1[low1] <= arr2[low2]) {
				arr3[low3++] = arr1[low1++];
			} else {
				arr3[low3++] = arr2[low2++];
			}
		}
		
		while (low1 <= high1 && low3 < arr3.length) {
			arr3[low3++] = arr1[low1++];
		}
		while (low2 <= high2 && low3 < arr3.length) {
			arr3[low3++] = arr2[low2++];
		}
	}
	
	private void storeNodes(Node n1, Queue<Node> q1) {
		if (n1 == null) return;
		
		storeNodes(n1.left, q1);
		q1.add(n1);
		storeNodes(n1.right, q1);
	}
	
	public static void main(String args[]) {
		/*TreeOrder node = new TreeOrder();
		Node root1 = null;
		root1 = node.Insert(2);
		root1 = node.Insert(1);
		root1 = node.Insert(3);
		/*node.Insert(25);
		node.Insert(8);
		node.Insert(12);
		node.Insert(30);*/
		
		TreeOrder node1 = new TreeOrder();
		/*Node root2 = null;
		root2 = node1.Insert(3);
		root2 = node1.Insert(9);
		root2 = node1.Insert(20);
		root2 = node1.Insert(15);
		root2 = node1.Insert(7);*/
		
		/*node.LevOrder();
		System.out.println();
		node.PreOrder();
		System.out.println();
		node.PostOrder();
		System.out.println(); 
		node.InOrderInt(root1);
		System.out.println();
		node1.InOrderInt(root2);
		System.out.println();*/
		
		/*Node root3 = node1.mergeTrees(root1, root2);
		node1.InOrderInt(root3);
		System.out.println();
		
		node1.InOrderInt(root2);
		System.out.println();
		System.out.println(node1.hasPathSum(root2, 13));*/
				
		//System.out.println(" Pre-order without recursion ");
		Node root4 = null;
		root4 = node1.Insert(4);
		root4 = node1.Insert(2);
		root4 = node1.Insert(1);
		root4 = node1.Insert(3);
		
		/*List<Integer> listItems = node1.preOrderTraversal(root4);
		for(Integer i: listItems) {
			System.out.printf("%d\t", i);
		}*/
		
		//System.out.println();
		
		//System.out.println(node1.levelOrder(root4));

		/*Node root2 = null;
		root2 = node1.Insert(3);
		root2 = node1.Insert(9);
		root2 = node1.Insert(20);
		root2 = node1.Insert(15);
		root2 = node1.Insert(7);
		
		List<List<Integer>> list1 = node1.levelOrder(root2);
		for (int k = 0; k < list1.size(); k++) {
			List<Integer> l2 = list1.get(k);
			
			for(int j = 0; j < l2.size(); j++) {
				System.out.printf("%d\t", l2.get(j));
			}
			System.out.println();
		}*/
		
		/*System.out.println("Post-order tree traversal");
		
		TreeOrder node2 = new TreeOrder();
		Node root2 = null;
		root2 = node2.Insert(3);
		root2 = node2.Insert(4);
		root2 = node2.Insert(2);*/
		
		TreeOrder node3 = new TreeOrder();
		Node root3 = null;
		root3 = node3.Insert(8);
		root3 = node3.Insert(5);
		root3 = node3.Insert(10);
		root3 = node3.Insert(3);
		root3 = node3.Insert(6);
		//root3 = node3.Insert(2);
		
		//System.out.println(node2.diameterOfBinaryTree(root2));
		
		/*root2 = node2.Insert(5);
		root2 = node2.Insert(20);
		root2 = node2.Insert(3);
		root2 = node2.Insert(7);*/
		
		/*List<Integer> postItems = node2.postOrderTraversal(root5);
		for(Integer i: postItems) {
			System.out.printf("%d\t", i);
		}*/
		
		//System.out.println(node2.isBST(root2));
		
		//System.out.println(node2.levelOrder(root2));
		//System.out.println(node2.levelOrder(root3));
		
		//System.out.println(isSubtree(root2, root3));
		
		//System.out.printf("Kth elem: %d\n", node3.kthElemRecur(root3, 1));
		
		/*System.out.printf("%d", node3.retMin(root3));
		
		node3.printPathsStan(root3);*/
		
		//System.out.printf("%d\n", node3.findKthLargest(2));
		
		//System.out.println(node3.levelOrder(root3));
		node3.mirrorTree(root3);
	}
	
	public int kthElem(Node root, int k) {
		if (root == null) return Integer.MAX_VALUE;
		
		int kth = kthElemRecur(root, k);
		
		return kth;
	}
	
	public int findKthLargest(int k) {
		int[] nums = {3,2,1,5,6,4};
		MaxPQ<Integer> queue = new MaxPQ<>();
		
		for(int i = 0; i < nums.length; i++) {
			queue.insert(nums[i]);
		}
		
		while (--k != 0) {
			queue.delMax();
		}
		
		return queue.delMax();
    }
	
	private int kthElemRecur(Node root, int k) {
		if (root == null) return k;
		
		kthElemRecur(root.left, k);
		System.out.printf("k: %d\t", k);

		k--;	if (k == 0) {
			System.out.printf(" Elem: %d ", root.data);
			return root.data;
		}
		
		kthElemRecur(root.right, k);
		
		return k;
	}
	
	public boolean hasPathSum(Node root, int sum) {
        
        if (root == null) {
        		return (sum == 0);
        }
        
        return (hasPathSum(root.left, sum - root.data) ||
        		(hasPathSum(root.right, sum - root.data)));
    }
	
	public void printPathsStan(Node root) {
		if (root == null) return;
		
		System.out.println();
		int[] newArr = new int[100];
		printPathsStanRecur(root, newArr, 0);
	}
	
	private void printPathsStanRecur(Node node, int[] path, int pathLen) {
		if (node == null) {
			System.out.println(" yes need to print data ");
			return;
		}
		
		path[pathLen++] = node.data;
		System.out.printf("%d\t", node.data);
		printPathsStanRecur(node.left, path, pathLen);
		if (node.right != null)
			printPathsStanRecur(node.right, path, pathLen);
		pathLen--;
	}
	
	public List<Integer> preOrderTraversal(Node root) {
		
		if (root == null)
			return null;
		
		List<Integer> items = new LinkedList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		
		items.add(root.data);
		if(root.right != null) stack.push(root.right);
		if(root.left != null) stack.push(root.left);
		
		while(!stack.isEmpty()) {
			Node top = stack.pop();
			items.add(top.data);
			
			if (top.right != null) {
				stack.push(top.right);
			}
			if (top.left != null) {
				stack.push(top.left);
			}
		}
		
        return items;
    }
	
	public List<Integer> postOrderTraversal(Node root) {
		
		if (root == null)
			return null;
		
		List<Integer> items = new LinkedList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		
		stack.push(root);
		
		Node top = stack.peek();
		while (top.left != null) {
			stack.push(top.left);
		}
		
		while(!stack.isEmpty()) {
			Node lastNode = stack.pop();
			System.out.println(lastNode.data);
			
			if(lastNode.right != null) {
				stack.push(lastNode.right);
			}
		}
		
        return items;
    }
	
	public boolean isBST(Node root) {
		if (root == null) return true;
		
		boolean isLeft = false;
		boolean isRight = false;
		
		if (root.left != null) {
			isLeft = isBSTRecur(root.left, root.data, false);
			if (!isLeft) return false;
		}
		if (root.right != null){
			isRight = isBSTRecur(root.right, root.data, true);
			if (!isRight) return false;
		}
		
		if ((root.left != null && isBST(root.left)) &&
				(root.right != null && isBST(root.right))) {
			return true;
		}
		
		return true;
	}
	
	public boolean isBSTRecur(Node node, int val, boolean check) {
		if (node == null) return true;
		
		System.out.printf("%d \t ", node.data);
		if (!check) {
			if (node.data > val) {
				return false;
			}
		} else {
			if (node.data <= val) {
				return false;
			}
		}
		if ((node.left != null && isBSTRecur(node.left, val, check)) && 
				(node.right != null && isBSTRecur(node.right, val, check)))
			return true;
		
		return true;
	}
	
	/*public List<List<Integer>> levelOrderRe(Node root) {
		List<List<Integer>> items = new LinkedList<List<Integer>>();
		
		if (root == null) return items;
		
		//levelOrderRecur(items, )
	}*/
	
	public int retMin(Node root) {
		return wrapperMin(root);
	}
	
	public int wrapperMin(Node root) {
		
		if (root == null) return Integer.MAX_VALUE;
		
		int min = retMin(root.left);
		
		if (min < root.data)
			return min;
		
		return root.data;
		
	}
	
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
				
		while(!queue.isEmpty()) {
			int stackSize = queue.size();
			List<Integer> newlist = new LinkedList<Integer>();
			while (stackSize > 0) {
				Node curr = queue.poll();
				newlist.add(curr.data);
				//System.out.printf("curr.data:%d\t", curr.data);
				//System.out.printf("%d\t", curr.data);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
				stackSize--;
			}
			System.out.println();
			list.add(newlist);
		}
		
		return list;
    }
	
	public int diameterOfBinaryTree(Node root) {
        int leftMaxHeight = treeHeight(root.left);
        System.out.printf("%d\n", leftMaxHeight);
        int rightMaxHeight = treeHeight(root.right);
        System.out.printf("%d\n", rightMaxHeight);
        
        return Math.abs(leftMaxHeight + rightMaxHeight);
    }
	
	public int treeHeight(Node root) {
		if (root == null) return -1;
		
		int leftHeight = treeHeight(root.left);
		int rightHeigth = treeHeight(root.right);
		
		return Math.max(leftHeight, rightHeigth) + 1;
	}
	
	/*static boolean isSubtree(Node s, Node t) {
        if (s == null || t == null) return false;
        
		Vector<Node> vect = new Vector<Node>();
		//vect.
        //return isSubtreeRecur(s, t);
    }*/
	
	static boolean isSubtreeRecur(Node s, Node t) {
		if (s == null || t == null) return true;
		
		if (s.data == t.data && isSubtreeRecur(s.left, t.left) &&
	    		(isSubtreeRecur(s.right, t.right))) {
	    		return true;
	    } else {
	    		System.out.println(" false ");
	    		return false;
	    }
		
		
	}
	
	public void mirrorTree(Node node) {
		//int[] array = new int[100];
		System.out.println(levelOrder(node));
		mirrorTreeRecur(node);
		System.out.println(" After mirroring ");
		System.out.println(levelOrder(node));
	}
	
	public void mirrorTreeRecur(Node node) {
		if (node == null) return;
		
		mirrorTreeRecur(node.left);
		mirrorTreeRecur(node.right);
		
		Node tmp = node.left;
		node.left = node.right;
		node.right = tmp;
	}
}