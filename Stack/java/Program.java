public class Program {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.top());
		int n = stack.pop();
		System.out.println("n: " + n);
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.size());
	}
}