class QueueUsingStack<T> {

	Stack<T> stk1, stk2;

	QueueUsingStack() {

		stk1 = new Stack<>();
		stk2 = new Stack<>();
	}

	QueueUsingStack(int max) {

		stk1 = new Stack<>(max);
		stk2 = new Stack<>(max);
	}

	void add(T val) {

		stk1.push(val);
	}


	T remove() {

		if (!stk2.isEmpty()) return stk2.pop();
		transfer();
		return stk2.pop();
	}


	T peek() {

		if (!stk2.isEmpty()) return stk2.peek();
		transfer();
		return stk2.peek();
	}


	void transfer() {

		while (!stk1.isEmpty()) stk2.push(stk1.pop());
	}


	boolean isEmpty() {
		return stk1.isEmpty() && stk2.isEmpty();
	}


	int getSize() {
		return stk1.getSize() + stk2.getSize();
	}
}