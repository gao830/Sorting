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
	// parent to its right child. If the deleted node is the root, set root as
	// its right child.
	// Case 2: If the node has left child, find the rightmost node of left
	// subtree(Or the leftmost of its right subtree?), then replace the node
	// with that rightmost node.

	public boolean delete(int element) {
		TreeNode current = root;
		TreeNode parent = null;
		while (current != null) {
			if (element > current.element) {
				parent = current;
				current = current.right;
			} else if (element < current.element) {
				parent = current;
				current = current.left;
			} else { // found element
				break;
			}

		}
		if (current == null) {
			return false;
		} else {
			// case 1
			if (current.left == null) {
				if (parent == null) {// Deleting root
					root = current.right;
				} else {
					if (element > parent.element) {
						parent.right = current.right;
					} else {
						parent.left = current.right;
					}
				}
			}
			// case 2
			else {
				TreeNode rightMost = current.left;
				TreeNode rightMostParent = current;
				while (rightMost.right != null) {
					rightMostParent = rightMost;
					rightMost = rightMost.right;
				}
				current.element = rightMost.element;
				if (rightMostParent.right == rightMost) {
					rightMostParent.right = rightMost.left;
				}

				// Current node has only left sub trees, rightMostParent =
				// current
				else {
					rightMostParent.left = rightMost.left;
				}
			}
			size--;
			return true;
		}

	}

	public int getSize() {
		return size;
	}

}

public class BST {

	public static void main(String[] args) {

		int[] list = { 100,60,105,30,70,101,106,10,45,65,80 };
		
		BinarySearchTree tree = new BinarySearchTree(list);
		tree.insert(35);
		tree.insert(33);
		tree.delete(45);
		tree.delete(105);
		tree.delete(60);
		tree.inOrderTraversal();
		System.out.println();
		tree.preOrderTraversal();
		System.out.println();
		
		tree.postOrderTraversal();

	}

}
