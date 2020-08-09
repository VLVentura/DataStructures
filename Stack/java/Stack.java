package Stack;

public class Stack<T extends Comparable<T>>{
	private Node<T> root;
	private int size;

	public void push(T data){
		++this.size;
		if(this.root == null){
			this.root = new Node(data);
		}
		else{
			Node<T> newNode = new Node<>(data);
			newNode.setNextNode(this.root);
			this.root = newNode;
		}

	}

	public T pop(){
		T itemToPop = this.root.getData();

		Node<T> temp;
		this.root = this.root.getNextNode();
		temp = null;

		--this.size;
		return  itemToPop;
	}

	public T top(){
		return this.root.getData();
	}

	public int size(){
		return this.size;
	}

	public boolean empty(){
		if(this.size == 0){
			return true;
		}
		return false;
	}
}
