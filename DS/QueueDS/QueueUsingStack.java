package DS.QueueDS;

import DS.StackDS.Stack;



public class QueueUsingStack<T> {

	private Stack<T> stk1, stk2;

	public QueueUsingStack() {

		stk1 = new Stack<>();
		stk2 = new Stack<>();
	}

	public QueueUsingStack(int max) {

		stk1 = new Stack<>(max);
		stk2 = new Stack<>(max);
	}

	public void add(T val) {

		stk1.push(val);
	}


	public T remove() {

		if (!stk2.isEmpty()) return stk2.pop();
		transfer();
		return stk2.pop();
	}


	public T peek() {

		if (!stk2.isEmpty()) return stk2.peek();
		transfer();
		return stk2.peek();
	}


	public void transfer() {

		while (!stk1.isEmpty()) stk2.push(stk1.pop());
	}


	public boolean isEmpty() {
		return stk1.isEmpty() && stk2.isEmpty();
	}


	public int getSize() {
		return stk1.getSize() + stk2.getSize();
	}
}