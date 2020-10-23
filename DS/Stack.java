class Stack<T> {

	LinkedList<T> linkedList;

	Stack() {

		linkedList = new LinkedList<>();
	}

	void push(T data) {

		linkedList.insertBegin(data);
	}


	T pop() {

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
}