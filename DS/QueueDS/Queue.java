package DS.QueueDS;

import DS.LinkedListDS.LinkedList;



public class Queue<T> {

	private LinkedList<T> linkedList;

	public Queue() {

		linkedList = new LinkedList<>();
	}

	public Queue(int max) {

		linkedList = new LinkedList<>(max);
	}

	public void add(T data) {

		linkedList.insertEnd(data);
	}


	public T remove() {

		T op = linkedList.get(0);
		linkedList.deleteBegin();
		return op;
	}


	public T peek() {
		return linkedList.get(0);
	}


	public boolean isEmpty() {

		return linkedList.isEmpty();
	}

	public int getSize() {
		return linkedList.getSize();
	}
}