public class SplayTree<T extends Comparable<T>> implements Tree<T> {

	private int size;
	private Node<T> root;

	@Override
	public void insert(T data) {

		Node<T> tempNode = this.root;
		Node<T> parentNode = null;

		while(tempNode != null){
			parentNode = tempNode;

			if(data.compareTo(tempNode.getData()) < 0){
				tempNode = tempNode.getLeftNode();
			}
			else{
				tempNode = tempNode.getRightNode();
			}
		}

		tempNode = new Node<T>(data);
		tempNode.setParentNode(parentNode);

		if(parentNode == null){
			this.root = tempNode;
		}
		else if(parentNode.getData().compareTo(tempNode.getData()) < 0){
			parentNode.setRightNode(tempNode);
		}
		else{
			parentNode.setLeftNode(tempNode);
		}

		splay(tempNode);
		++this.size;
	}

	@Override
	public Node<T> find(T data) {
		Node<T> tempNode = this.root;

		while(tempNode != null){
			if(data.compareTo(tempNode.getData()) < 0){
				tempNode = tempNode.getLeftNode();
			}
			else if(data.compareTo(tempNode.getData()) > 0){
				tempNode = tempNode.getRightNode();
			}
			else{
				splay(tempNode);
				return tempNode;
			}
		}
		splay(tempNode);
		return null;
	}

	private void splay(Node<T> node){

		// If the parent is a null node, it means that the node is the root node
		while(node.getParentNode() != null){

			/* ZIG Situation
			 * Node is child of the root
			 */

			if(node.getParentNode().getParentNode() == null){
				// Node is a left child and the grandparent is null
				if(node.getParentNode().getLeftNode() == node){
					rightRotate(node.getParentNode());
				}
				// Node is a right child and the grandparent is null
				else{
					leftRotate(node.getParentNode());
				}
			}

			/* ZIG-ZIG Situation
			 * Node is a left-left child or a right-right child
			 */

			// Node is a left child AND parent is a left child
			else if(node.getParentNode().getLeftNode() == node
					&& node.getParentNode().getParentNode().getLeftNode() == node.getParentNode()){
				rightRotate(node.getParentNode().getParentNode());
				rightRotate(node.getParentNode());
			}
			// Node is a right child AND parent is a right child
			else if(node.getParentNode().getRightNode() == node
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
				leftRotate(node.getParentNode().getParentNode());
				leftRotate(node.getParentNode());
			}

			/* ZIG-ZAG Situation
			 * Node is a left-right child or a right-left child
			 */

			// Node is a left child AND parent is a right child
			else if(node.getParentNode().getLeftNode() == node
					&& node.getParentNode().getParentNode().getRightNode() == node.getParentNode()){
				rightRotate(node.getParentNode());
				leftRotate(node.getParentNode());
			}
			// Node is a right child AND parent is a left child
			else{
				leftRotate(node.getParentNode());
				rightRotate(node.getParentNode());
			}
		}
	}

	private void rightRotate(Node<T> node){
		Node<T> tempNode = node.getLeftNode();

		if(tempNode != null){
			node.setLeftNode(tempNode.getRightNode());

			if(tempNode.getRightNode() != null){
				tempNode.getRightNode().setParentNode(node);
			}

			tempNode.setParentNode(node.getParentNode());
		}

		if(node.getParentNode() == null){
			this.root = tempNode;
		}
		else if(node == node.getParentNode().getLeftNode()){
			node.getParentNode().setLeftNode(tempNode);
		}
		else{
			node.getParentNode().setRightNode(tempNode);
		}

		if(tempNode != null){
			tempNode.setRightNode(node);
		}

		node.setParentNode(tempNode);
	}

	private void leftRotate(Node<T> node){
		Node<T> tempNode = node.getRightNode();

		if(tempNode != null){
			node.setRightNode(tempNode.getLeftNode());

			if(tempNode.getLeftNode() != null){
				tempNode.getLeftNode().setParentNode(node);
			}

			tempNode.setParentNode(node.getParentNode());
		}

		if(node.getParentNode() == null){
			this.root = tempNode;
		}
		else if(node == node.getParentNode().getLeftNode()){
			node.getParentNode().setLeftNode(tempNode);
		}
		else{
			node.getParentNode().setRightNode(tempNode);
		}

		if(tempNode != null){
			tempNode.setLeftNode(node);
		}

		node.setParentNode(tempNode);
	}

	@Override
	public T getMin() {
		return min(this.root);
	}

	public T min(Node<T> node){
		if(node.getLeftNode() == null){
			return node.getData();
		}
		return min(node.getLeftNode());
	}

	@Override
	public T getMax() {
		return max(this.root);
	}

	public T max(Node<T> node){
		if(node.getRightNode() == null){
			return node.getData();
		}
		return max(node.getRightNode());
	}

	public void printRoot(){
		System.out.println(this.root.getData());
	}

	@Override
	public void traversal() {
		inOrder(this.root);
	}

	private void inOrder(Node<T> node){
		if(node == null){
			return;
		}
		inOrder(node.getLeftNode());
		System.out.println(node + " ");
		inOrder(node.getRightNode());
	}
}