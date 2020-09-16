public class AvlTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> node, T data){
		if(node == null){
			return new Node(data);
		}

		if(data.compareTo(node.getData()) < 0){
			node.setLeftNode(insert(node.getLeftNode(), data));
		}
		else if(data.compareTo(node.getData()) > 0){
			node.setRightNode(insert(node.getRightNode(), data));
		}

		node.setHeightNode(Math.max(height(node.getRightNode()), height(node.getLeftNode())) + 1);
		node = settleViolation(node, data);

		return node;
	}

	private Node<T> settleViolation(Node<T> node, T data){
		int balance = getBalance(node);

		// Case 1: Single Right Rotation (Doubly-left heavy situation)
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0){
			return rightRotation(node);
		}
		// Case 2: Single Left Rotation (Doubly-right heavy situation)
		if(balance < -1 && data.compareTo(node.getRightNode().getData()) > 0){
			return leftRotation(node);
		}
		// Case 3: Left Rotation + Right Rotation (Left-Right situation)
		if(balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0){
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}
		// Case 4: Right Rotation + Left Rotation (Right-Left situation)
		if(balance < -1 && data.compareTo(node.getRightNode().getData()) < 0){
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}

		return node;
	}

	@Override
	public void remove(T data){
		root = remove(root, data);
	}

	private Node<T> remove(Node<T> node, T data){
		if(node == null){
			return node;
		}

		// Smaller
		if(data.compareTo(node.getData()) < 0){
			node.setLeftNode(remove(node.getLeftNode(), data));
		}
		// Greater
		else if(data.compareTo(node.getData()) > 0){
			node.setRightNode(remove(node.getRightNode(), data));
		}
		// Equal - time to delete
		else{
			// Case 1: is a leaf
			if(node.getRightNode() == null && node.getLeftNode() == null){
				return null;
			}
			// Case 2: has 1 child
			else if(node.getRightNode() == null){
				Node<T> temp = node;
				node = node.getLeftNode();
				temp = null;
			}
			else if(node.getLeftNode() == null) {
				Node<T> temp = node;
				node = node.getRightNode();
				temp = null;
			}
			// Case 3: has 2 childs
			else{
				T predecessor = max(node.getLeftNode());
				node.setData(predecessor);
				node.setLeftNode(remove(node.getLeftNode(), predecessor));
			}
		}

		node.setHeightNode(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		return settleDeletion(node);
	}

	private Node<T> settleDeletion(Node<T> node){
		int balance = getBalance(node);

		// Could be Case 1 (doubly-left heavy) or Case 3 (left right)
		if(balance > 1){
			// Case 3 - if this if is true (will execute this if and the return below)
			if(getBalance(node.getLeftNode()) < 0){
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}
			// Case 1 - else
			return rightRotation(node);
		}
		// Could be Case 2 (doubly-right heavy) or Case 4 (right - left)
		if(balance < -1){
			// Case 4 - if this if is true (will execute this if and the return below)
			if(getBalance(node.getRightNode()) > 0){
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			// Case 1 - else
			return leftRotation(node);
		}

		return node;
	}

	private Node<T> rightRotation(Node<T> node){
		System.out.println("Rotating to the right at the node: " + node.getData());

		Node<T> tempLeftNode = node.getLeftNode();
		Node<T> t = tempLeftNode.getRightNode();

		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);

		node.setHeightNode(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempLeftNode.setHeightNode(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

		return tempLeftNode;
	}

	private Node<T> leftRotation(Node<T> node){
		System.out.println("Rotating to the left at the node: " + node.getData());

		Node<T> tempRightNode = node.getRightNode();
		Node<T> t = tempRightNode.getLeftNode();

		tempRightNode.setLeftNode(node);
		node.setRightNode(t);

		node.setHeightNode(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempRightNode.setHeightNode(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

		return tempRightNode;
	}

	public int height(Node<T> node){
		if(node == null){
			return -1;
		}
		return node.getHeightNode();
	}

	private int getBalance(Node<T> node){
		if(node == null){
			return 0;
		}
		return height(node.getLeftNode()) - height(node.getRightNode());
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
		System.out.println(node.getData() + " ");
		inOrder(node.getRightNode());
	}

	private T max(Node<T> node){
		if(node.getRightNode() == null){
			return node.getData();
		}
		return max(node.getRightNode());
	}
}
