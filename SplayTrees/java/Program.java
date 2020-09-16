public class Program {
	public static void main(String[] args) {
		Tree<Integer> spltree = new SplayTree<Integer>();

		spltree.insert(10);
		spltree.insert(-5);
		spltree.insert(0);
		spltree.insert(20);
		spltree.insert(30);

		spltree.printRoot();

		spltree.find(0);
		spltree.printRoot();

		System.out.println("Max: " + spltree.getMax());
		System.out.println("Min: " + spltree.getMin());

	}
}