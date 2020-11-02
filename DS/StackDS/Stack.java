package DS.StackDS;

import DS.LinkedListDS.LinkedList;

public class Stack<T> {

	private LinkedList<T> linkedList;

	public Stack() {

		linkedList = new LinkedList<>();
	}

	public Stack(int max) {

		linkedList = new LinkedList<>(max);
	}

	public void push(T data) {

		linkedList.insertBegin(data);
	}


	public T pop() {

		T op = linkedList.get(0);
		linkedList.deleteBegin();
		return op;
	}


	public T peek() {

		if (isEmpty()) return null;
		return linkedList.get(0);
	}


	public boolean isEmpty() {

		return linkedList.isEmpty();
	}

	public int getSize() {
		return linkedList.getSize();
	}
}