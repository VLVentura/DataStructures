package LRU;

public class DoublyLinkedList<K, V> {

	private Node<K, V> headNode;
	private Node<K, V> tailNode;

	public DoublyLinkedList(){
	}

	public Node<K, V> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Node<K, V> headNode) {
		this.headNode = headNode;
	}

	public Node<K, V> getTailNode() {
		return tailNode;
	}

	public void setTailNode(Node<K, V> tailNode) {
		this.tailNode = tailNode;
	}
}
