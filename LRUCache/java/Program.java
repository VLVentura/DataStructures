public class Program {
	public static void main(String[] args) {
		LRUCache<String, Integer> lru = new LRUCache<>();

		lru.put("@gmail", 1);
		lru.put("@hotmail", 2);
		lru.put("@ig", 3);
		lru.put("@yahoo", 4);

		System.out.println(lru.get("@gmail"));
		lru.show();

		System.out.println(lru.get("@ig"));
		lru.show();
	}
}