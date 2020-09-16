public interface Tree<T extends Comparable<T>> {
	public Node<T> getRoot();
	public void traversal();
	public void insert(T data);
	public void remove(T data);
	public T getMax();
	public T getMin();
	public boolean compareTo(Tree<T> anotherTree);
	public T getKSmallest(int k);
}
