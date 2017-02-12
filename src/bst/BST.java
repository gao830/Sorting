package bst;

class TreeNode {
	int element;
	TreeNode left;
	TreeNode right;

	public TreeNode(int element) {
		this.element = element;
	}
}

class BinarySearchTree {
	private int size = 0;
	private TreeNode root;

	public BinarySearchTree() {

	}

	public BinarySearchTree(int[] list) {

		for (int element : list) {
			insert(element);
		}
	}

	public boolean search(int element) {

		return false;
	}

	public boolean insert(int element) {

		if (root == null) {
			root = new TreeNode(element);
		}

		else {
			// System.out.println("not null");
			TreeNode current = root;
			TreeNode parent = null;
			while (current != null) {
				if (element > current.element) {
					parent = current;
					current = current.right;

				} else if (element < current.element) {
					parent = current;
					current = current.left;

				} else {
					// System.out.println("Duplicated element");
					return false;
				}

			}
			if (element > parent.element) {
				parent.right = new TreeNode(element);
			} else {
				parent.left = new TreeNode(element);
			}

		}
		size++;
		// System.out.println(element);
		return true;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void inOrderTraversal(TreeNode root) {

		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.element + " ");
		inOrderTraversal(root.right);

	}

	private void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.element + " ");

	}

	private void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	// Case 1: The node to be deleted does not have left child. Just connect its
	// parent to its right child If the deleted node is the root, set root as
	// its right child.
	// Case 2: If the node has left child, find the rightmost node of left
	// subtree(Or the leftmost of its right subtree?), then replace the node with

	public void delete(int element) {

	}

	public int getSize() {
		return size;
	}

}

public class BST {

	public static void main(String[] args) {

		int[] list = { 45, 57, 55, 67, 100, 107, 60 };
		BinarySearchTree tree = new BinarySearchTree(list);
		tree.inOrderTraversal();
		System.out.println();
		tree.preOrderTraversal();
		System.out.println();
		tree.postOrderTraversal();

	}

}
