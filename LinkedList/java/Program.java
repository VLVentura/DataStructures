public class Program {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();

        System.out.println(list.isEmpty());

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(100);

        System.out.println(list.isEmpty());

        System.out.println(list.size());
        list.traverseList();

        list.remove(100);

        System.out.println();
        System.out.println(list.size());
        list.traverseList();
        System.out.println();
	}
}