class Queue<T> {

	LinkedList<T> linkedList;

	Queue() {

		linkedList = new LinkedList<>();
	}

	Queue(int max) {

		linkedList = new LinkedList<>(max);
	}

	void add(T data) {

		linkedList.insertEnd(data);
	}


	T remove() {

		T op = linkedList.get(0);
		linkedList.deleteBegin();
		return op;
	}


	T peek() {
		return linkedList.get(0);
	}


	boolean isEmpty() {

		return linkedList.isEmpty();
	}

	int getSize() {
		return linkedList.getSize();
	}
}