public class Program {
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();

		queue.pop_front();
		queue.push_back(1);
		queue.push_back(2);
		queue.push_back(3);
		queue.push_back(4);
		queue.push_back(5);

		System.out.println(queue.pop_front());
		System.out.println(queue.pop_front());
		System.out.println(queue.pop_front());
		System.out.println(queue.back());
		System.out.println(queue.size());
		System.out.println(queue.empty());
	}
}