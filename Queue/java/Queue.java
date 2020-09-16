public class Queue<T extends Comparable<T>> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int sizeOfList;

	public void push_back(T data){
		++this.sizeOfList;

		Node<T> previousLastNode = lastNode;
		lastNode = new Node(data);
		this.lastNode.setNextNode(null);

		if(empty()){
			this.firstNode = this.lastNode;
		}
		else{
			previousLastNode.setNextNode(lastNode);
		}
	}

	public T pop_front(){
		if(firstNode == null){
			return null;
		}

		T itemToPop = this.firstNode.getData();

		Node<T> temp = this.firstNode;
		this.firstNode = this.firstNode.getNextNode();
		temp = null;

		--this.sizeOfList;
		return itemToPop;
	}

	public T front(){
		return this.firstNode.getData();
	}

	public T back(){
		return this.lastNode.getData();
	}

	public boolean empty(){
		return this.firstNode == null;
	}

	public int size(){
		return this.sizeOfList;
	}
}
