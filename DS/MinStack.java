class MinStack<T extends Comparable<T>> {

	Stack<T> valueStk, minStk;


	MinStack() {

		valueStk = new Stack<>();
		minStk = new Stack<>();
	}

	MinStack(int max) {

		valueStk = new Stack<>(max);
		minStk = new Stack<>(max);
	}


	T getMin() {
		return minStk.peek();
	}


	void push(T val) {

		valueStk.push(val);
		if (minStk.isEmpty() || minStk.peek().compareTo(val) > 0) minStk.push(val);
	}


	T pop() {

		if (minStk.peek().compareTo(valueStk.peek()) == 0) minStk.pop();
		return valueStk.pop();
	}


	boolean isEmpty() {
		return valueStk.isEmpty();
	}


	T peek() {
		return valueStk.peek();
	}
}