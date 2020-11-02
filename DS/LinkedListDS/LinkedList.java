package DS.LinkedListDS;



public class LinkedList<T> {

	private class Node {

		T data;
		Node prev, next;

		Node(T d) {
			data = d;
		}
	}


	private Node head, tail;
	private int capacity, size;


	public LinkedList() {

		capacity = Integer.MAX_VALUE;
	}

	public LinkedList(int max) {

		capacity = max;
	}


	public void insertBegin(T val) {

		if (size >= capacity) return; // Exception

		Node newNode = new Node(val);

		if (tail == null) tail = newNode;

		if (head != null) {

			head.prev = newNode;
			newNode.next = head;
		}

		head = newNode;

		size++;
	}


	public void insertEnd(T val) {

		if (size >= capacity) return;

		Node newNode = new Node(val);

		if (head == null) head = newNode;

		if (tail != null) {

			tail.next = newNode;
			newNode.prev = tail;
		}

		tail = newNode;

		size++;
	}


	public void insertAt(T val, int i) {

		if (size >= capacity) return;

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

		size++;
	}


	public void deleteBegin() {

		if (head == null) return;

		if (head == tail) {

			head = null;
			tail = null;
			size--;
			return;
		}

		head = head.next;
		head.prev = null;

		size--;
	}


	public void deleteEnd() {

		if (tail == null) return;

		if (tail == head) {

			head = null;
			tail = null;
			size--;
			return;
		}

		tail = tail.prev;
		tail.next = null;
		size--;
	}


	public void deleteAt(int i) {

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

		size--;
	}


	public void traverse() {

		Node tmp = head;

		System.out.print("LL: ");

		while (tmp != null) {

			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}

		System.out.println();
	}


	public void reverseTraverse() {

		Node tmp = tail;

		System.out.print("LL: ");

		while (tmp != null) {

			System.out.print(tmp.data + " ");
			tmp = tmp.prev;
		}

		System.out.println();
	}


	public T get(int index) {

		if (head == null) return null;

		Node tmp = head;

		while (index-- > 0 && tmp != null) tmp = tmp.next;

		if (tmp == null) return null;
		return tmp.data;
	}


	public boolean isEmpty() {
		return head == null;
	}


	public int getSize() {
		return size;
	}
}