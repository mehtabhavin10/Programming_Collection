package DS.StackDS;

public class MinStack<T extends Comparable<T>> {

	private Stack<T> valueStk, minStk;


	public MinStack() {

		valueStk = new Stack<>();
		minStk = new Stack<>();
	}

	public MinStack(int max) {

		valueStk = new Stack<>(max);
		minStk = new Stack<>(max);
	}


	public T getMin() {
		return minStk.peek();
	}


	public void push(T val) {

		valueStk.push(val);
		if (minStk.isEmpty() || minStk.peek().compareTo(val) > 0) minStk.push(val);
	}


	public T pop() {

		if (minStk.peek().compareTo(valueStk.peek()) == 0) minStk.pop();
		return valueStk.pop();
	}


	public boolean isEmpty() {
		return valueStk.isEmpty();
	}


	public T peek() {
		return valueStk.peek();
	}
}