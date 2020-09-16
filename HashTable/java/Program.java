public class Program {
	public static void main(String[] args) {
		HashTable<String, Integer> hashTable = new HashTable<String, Integer>();

		hashTable.put("Vinicius", 10);
		hashTable.put("Ana", 20);
		hashTable.put("Nathália", 30);

		System.out.println(hashTable.get("Nathália"));

		System.out.println(hashTable.size());

		hashTable.remove("Vinicius");

		System.out.println(hashTable.size());
	}
}