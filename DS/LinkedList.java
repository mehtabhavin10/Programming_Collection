class LinkedList<T> {

	class Node {

		T data;
		Node prev, next;

		Node(T d) {
			data = d;
		}
	}


	Node head, tail;


	void insertBegin(T val) {

		Node newNode = new Node(val);

		if (tail == null) tail = newNode;

		if (head != null) {

			head.prev = newNode;
			newNode.next = head;
		}

		head = newNode;
	}


	void insertEnd(T val) {

		Node newNode = new Node(val);

		if (head == null) head = newNode;

		if (tail != null) {

			tail.next = newNode;
			newNode.prev = tail;
		}

		tail = newNode;
	}


	void insertAt(T val, int i) {

		if (i == 0) {

			insertBegin(val);
			return;
		}

		int c = 1;
		Node tmp = head;

		while (tmp != null && c < i) {

			tmp = tmp.next;
			c++;
		}

		if (tmp == null || tmp.next == null) insertEnd(val);

		Node newNode = new Node(val);

		newNode.next = tmp.next;
		newNode.prev = tmp;
		tmp.next.prev = newNode;
		tmp.next = newNode;
	}


	void deleteBegin() {

		if (head == null) return;

		if (head == tail) {

			head = null;
			tail = null;
			return;
		}

		head = head.next;
		head.prev = null;
	}


	void deleteEnd() {

		if (tail == null) return;

		if (tail == head) {

			head = null;
			tail = null;
			return;
		}

		tail = tail.prev;
		tail.next = null;
	}


	void deleteAt(int i) {

		if (i == 0) {

			deleteBegin();
			return;
		}

		if (head == null) return;

		Node tmp = head;
		int c = 1;

		while (tmp != null && c < i) {

			tmp = tmp.next;
			c++;
		}

		if (tmp == null) return;

		if (tmp.next == null) deleteEnd();

		tmp.next.next.prev = tmp;
		tmp.next = tmp.next.next;
	}


	void traverse() {

		Node tmp = head;

		System.out.print("LL: ");

		while (tmp != null) {

			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}

		System.out.println();
	}


	void reverseTraverse() {

		Node tmp = tail;

		System.out.print("LL: ");

		while (tmp != null) {

			System.out.print(tmp.data + " ");
			tmp = tmp.prev;
		}

		System.out.println();
	}
}