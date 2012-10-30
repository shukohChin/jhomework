package ch21.ex21_07;

public class Test {
	public static void main(final String[] args) {
		final Stack<Integer> stack = new Stack<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());

		System.out.println("empty: " + stack.empty());

		try {
			System.out.println("peek: " + stack.peek());
		} catch (final Exception e) {
			System.out.println(e.getClass());
		}

		try {
			System.out.println("pop: " + stack.pop());
		} catch (final Exception e) {
			System.out.println(e.getClass());
		}

		stack.push(666);
		System.out.println("empty: " + stack.empty());
		System.out.println("pop: " + stack.pop());
		System.out.println("empty: " + stack.empty());

	}
}
