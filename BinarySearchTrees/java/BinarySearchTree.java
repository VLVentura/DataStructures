package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	private Node<T> root;

	@Override
	public Node<T> getRoot(){
		return this.root;
	}

	@Override
	public void traversal() {
		inOrder(root);
	}

	private void inOrder(Node<T> node) {
		if (node == null) {
			// System.out.println("NULL");
			return;
		}
		inOrder(node.getLeftNode());
		System.out.print(node.getData() + " ");
		inOrder(node.getRightNode());
	}

	@Override
	public void insert(T data) {
		root = insertNode(data, root);
	}

	private Node<T> insertNode(T data, Node<T> node) {
		if (node == null) {
			node = new Node<T>(data);
		} else {
			// Smaller
			if (data.compareTo(node.getData()) < 0) {
				node.setLeftNode(insertNode(data, node.getLeftNode()));
			}
			// Greater
			else {
				node.setRightNode(insertNode(data, node.getRightNode()));
			}
		}
		return node;
	}

	@Override
	public void remove(T data) {
		root = delete(data, root);
	}

	private Node<T> delete(T data, Node<T> node) {
		if (node == null) {
			return node;
		}

		// Smaller
		if (data.compareTo(node.getData()) < 0) {
			node.setLeftNode(delete(data, node.getLeftNode()));
		}
		// Greater
		else if (data.compareTo(node.getData()) > 0) {
			node.setRightNode(delete(data, node.getRightNode()));
		}
		// Equal - time to delete
		else {
			// Case 1: No child - the node is a leaf
			if (node.getLeftNode() == null && node.getRightNode() == null) {
				node = null;
			}
			// Case 2: Has 1 child
			else if (node.getLeftNode() == null) {
				Node<T> temp = node;
				node = node.getRightNode();
				temp = null;
			} else if (node.getRightNode() == null) {
				Node<T> temp = node;
				node = node.getLeftNode();
				temp = null;
			}
			// Case 3: Has 2 childs
			else {
				T maxElement = max(node.getLeftNode());
				node.setData(maxElement);
				node.setLeftNode(delete(maxElement, node.getLeftNode()));
			}
		}
		return node;
	}

	@Override
	public T getMax() {
		if (root.getRightNode() == null) {
			return root.getData();
		}
		return max(root.getRightNode());
	}

	private T max(Node<T> node) {
		if (node.getRightNode() == null) {
			return node.getData();
		}
		return max(node.getRightNode());
	}

	@Override
	public T getMin() {
		if (root.getLeftNode() == null) {
			return root.getData();
		}
		return min(root.getLeftNode());
	}

	private T min(Node<T> node) {
		if (node.getLeftNode() == null) {
			return node.getData();
		}
		return min(node.getLeftNode());
	}

	@Override
	public boolean compareTo(Tree<T> anotherTree){
		return equals(this.root, anotherTree.getRoot());
	}

	private boolean equals(Node<T> firstRoot, Node<T> secondRoot){
		if(firstRoot == null || secondRoot == null){
			return firstRoot == secondRoot;
		}
		if(firstRoot.getData().compareTo(secondRoot.getData()) != 0){
			return false;
		}

		return equals(firstRoot.getLeftNode(), secondRoot.getLeftNode()) &&
				equals(firstRoot.getRightNode(), secondRoot.getRightNode());
	}

	@Override
	public T getKSmallest(int k){
		return kthSmallest(root, k);
	}

	private T kthSmallest(Node<T> node, int k){
		int n = numberOfNodes(node.getLeftNode()) + 1;

		if(n == k){
			return node.getData();
		}
		if(n > k){
			return kthSmallest(node.getLeftNode(), k);
		}
		if(n < k){
			return kthSmallest(node.getRightNode(), k-n);
		}

		return null;
	}

	private int numberOfNodes(Node<T> root){
		if(root == null){
			return 0;
		}
		return numberOfNodes(root.getLeftNode()) + numberOfNodes(root.getRightNode()) + 1;
	}
}
