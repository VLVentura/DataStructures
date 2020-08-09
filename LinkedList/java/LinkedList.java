package LinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {

	private Node<T> root;
	private int sizeOfList;

	@Override
	public void insert(T data) {
		++this.sizeOfList;

		if(root == null){
			this.root = new Node<>(data);
		}
		else{
			insertDataAtBeginning(data);
		}
	}

	// O(1)
	private void insertDataAtBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(root);
		this.root = newNode;
	}

	// O(N)
	private void insertDataAtEnd(T data, Node<T> node){
		if(node.getNextNode() != null){
			insertDataAtEnd(data, node.getNextNode());
		}
		else{
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
		}
	}

	@Override
	public void remove(T data) {
		if(this.root == null){
			return;
		}

		--this.sizeOfList;
		if(this.root.getData().compareTo(data) != 0){
			remove(data, root, root.getNextNode());
		}
		else{
			this.root = this.root.getNextNode();
		}
	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
		if(actualNode == null){
			return;
		}
		if(actualNode.getData().compareTo(dataToRemove) != 0){
			remove(dataToRemove, actualNode, actualNode.getNextNode());
		}
		else{
			previousNode.setNextNode(actualNode.getNextNode());
			actualNode = null;
		}
	}

	@Override
	public void reverse(){
		Node<T> previousNode = null;
		Node<T> nextNode = null;
		Node<T> currentNode = this.root;

		while(currentNode != null){
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);

			previousNode = currentNode;
			currentNode = nextNode;
		}

		this.root = previousNode;
	}

	@Override
	public T middle(){
		Node<T> faster = this.root;
		Node<T> slower = this.root;

		while(faster.getNextNode() != null && faster.getNextNode().getNextNode() != null){
			faster = faster.getNextNode().getNextNode();
			slower = slower.getNextNode();
		}
		return slower.getData();
	}

	@Override
	public void traverseList() {
		traverseList(this.root);
	}

	private void traverseList(Node<T> node) {
		if(node == null){
			return;
		}
		System.out.print(node.getData() + " ");
		traverseList(node.getNextNode());
	}

	@Override
	public int size() {
		return this.sizeOfList;
	}

	@Override
	public boolean isEmpty() {
		if(this.root == null){
			return true;
		}
		return false;
	}
}