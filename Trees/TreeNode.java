package Trees;

class TreeNode {
	char val;
	TreeNode left;
	TreeNode right;
	
	//Function to Insert Node in a Binary Search Tree
	static TreeNode Insert(TreeNode root,char data) {
		if(root == null) {
			root = new TreeNode();
			root.val = data;
			root.left = root.right = null;
		}
		else if(data <= root.val) root.left = Insert(root.left,data);
		else root.right = Insert(root.right,data);
		return root;
	}
}