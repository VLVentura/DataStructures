public class Node<K, V> {

	private K id;
	private V data;
	private Node<K, V> previousNode;
	private Node<K, V> nextNode;

	public Node(){
	}

	public Node(K id, V data){
		this.id = id;
		this.data = data;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}

	public Node<K, V> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<K, V> previousNode) {
		this.previousNode = previousNode;
	}

	public Node<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<K, V> nextNode) {
		this.nextNode = nextNode;
	}
}
