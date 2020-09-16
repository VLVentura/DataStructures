public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		root = insertNode(root, newNode);
		fixViolations(newNode);
	}

	private Node<T> insertNode(Node<T> root, Node<T> node){
		if(root == null){
			return node;
		}

		// Smaller
		if(node.getData().compareTo(root.getData()) < 0){
			root.setLeftNode(insertNode(root.getLeftNode(), node));
			root.getLeftNode().setParent(root);
		}
		// Greater
		else if(node.getData().compareTo(root.getData()) > 0) {
			root.setRightNode(insertNode(root.getRightNode(), node));
			root.getRightNode().setParent(root);
		}

		return root;
	}

	private void fixViolations(Node<T> node){
		Node<T> parentNode = null;
		Node<T> grandParentNode = null;

		while(node != root && node.getColor() != Color.BLACK && node.getParent().getColor() == Color.RED){
			parentNode = node.getParent();
			grandParentNode = node.getParent().getParent();

			// The parent node of the node we want to insert is a left child
			if(parentNode == grandParentNode.getLeftNode()){
				Node<T> uncle = grandParentNode.getRightNode();

				// The parent is RED (condition in the wile) and the uncle is also RED
				// Case 1: Recolor or Case 4: Recolor
				if(uncle != null && uncle.getColor() == Color.RED){
					grandParentNode.setColor(Color.RED);
					parentNode.setColor(Color.BLACK);
					uncle.setColor(Color.BLACK);
					// To check recursively if other parts in the red black tree if violated
					node = grandParentNode;
				}
				// The parent is RED (condition in the while) and the uncle is BLACK because the if above was not true
				// Case 2: Rotation or Case 3: Rotation + Recolor
				else{
					// Uncle is black and the node we want to insert is a right child
					// a) Case 2: Simple left rotation in the parent node
					if(node == parentNode.getRightNode()){
						leftRotation(parentNode);
						// To check recursively if other parts in the red black tree if violated
						node = parentNode;
						parentNode = node.getParent();
					}
					// Uncle is black and the node we want to insert is a left child
					// b) Case 3: Simple right rotation in the grand parent node + recolor
					rightRotation(grandParentNode);
					Color tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					// To check recursively if other parts in the red black tree if violated
					node = parentNode;

				}
			}
			// The parent node of the node we want to insert is a right child
			else{
				Node<T> uncle = grandParentNode.getLeftNode();

				// The parent is RED (condition in the wile) and the uncle is also RED
				// Case 1: Recolor or Case 4: Recolor
				if(uncle != null && uncle.getColor() == Color.RED){
					grandParentNode.setColor(Color.RED);
					parentNode.setColor(Color.BLACK);
					uncle.setColor(Color.BLACK);
					// To check recursively if other parts in the red black tree if violated
					node = grandParentNode;
				}
				// The parent is RED (condition in the while) and the uncle is BLACK because the if above was not true
				// Case 2: Rotation or Case 3: Rotation + Recolor
				else{
					// Uncle is black and the node we want to insert is a left child
					// a) Case 2: Simple right rotation in the parent node
					if(node == parentNode.getLeftNode()){
						rightRotation(parentNode);
						// To check recursively if other parts in the red black tree if violated
						node = parentNode;
						parentNode = node.getParent();
					}
					// Uncle is black and the node we want to insert is a left child
					// b) Case 3: Simple left rotation in the grand parent node + recolor
					leftRotation(grandParentNode);
					Color tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					// To check recursively if other parts in the red black tree if violated
					node = parentNode;
				}
			}
		}

		if(root.getColor() == Color.RED){
			root.setColor(Color.BLACK);
		}
	}

	private void rightRotation(Node<T> node){
		System.out.println("Right rotation at: " + node.getData());

		Node<T> tempLeftNode = node.getLeftNode();
		node.setLeftNode(tempLeftNode.getRightNode());

		// Left child will have this node as his parent
		if(node.getLeftNode() != null){
			node.getLeftNode().setParent(node);
		}

		// The rotation will made the parent of the node be the parent of his left child
		// and the node will be the new child
		tempLeftNode.setParent(node.getParent());

		// Now, we need to set the new child of the node's parent
		// a) If the rotation was in the root, it means that this node will be the new root
		if(tempLeftNode.getParent() == null){
			root = tempLeftNode;
		}
		// b) Check if this node is a left child, if it is, he'll be the left child of his 'ex' grand parent
		else if(node == node.getParent().getLeftNode()){
			node.getParent().setLeftNode(tempLeftNode);
		}
		// c) If it's not a left child, it's a right child, he'll be the right child of his 'ex' grand parent
		else{
			node.getParent().setRightNode(tempLeftNode);
		}

		// The conclusion of the rotation - the node is now the child and the tempLeftNode is his parent
		tempLeftNode.setRightNode(node);
		node.setParent(tempLeftNode);
	}

	private void leftRotation(Node<T> node){
		System.out.println("Left rotation at: " + node.getData());

		Node<T> tempRightNode = node.getRightNode();
		node.setRightNode(tempRightNode.getLeftNode());

		// Right child will have this node as his parent
		if(node.getRightNode() != null) {
			node.getRightNode().setParent(node);
		}

		// The rotation will made the parent of the node be the parent of his right child
		// and the node will be the new child
		tempRightNode.setParent(node.getParent());

		// Now, we need to set the new child of the node's parent
		// a) If the rotation was in the root, it means that this node will be the new root
		if(tempRightNode.getParent() == null){
			root = tempRightNode;
		}
		// b) Check if this node is a left child, if it is, he'll be the left child of his 'ex' grand parent
		else if(node == node.getParent().getLeftNode()){
			node.getParent().setLeftNode(tempRightNode);
		}
		// c) If it's not a left child, it's a right child, he'll be the right child of his 'ex' grand parent
		else{
			node.getParent().setRightNode(tempRightNode);
		}

		tempRightNode.setLeftNode(node);
		node.setParent(tempRightNode);
	}

	@Override
	public void traverse() {
		inOrder(this.root);
	}

	private void inOrder(Node<T> node){
		if(node == null){
			return;
		}
		inOrder(node.getLeftNode());
		System.out.println(node.getData());
		inOrder(node.getRightNode());
	}

}
