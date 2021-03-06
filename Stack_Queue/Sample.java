package Stack_Queue;

import DS.LinkedListDS.LinkedList;

public class Sample {

	public static void main(String[] args) {

		LinkedList<Integer> linkedList = new LinkedList<>();

		linkedList.insertBegin(23);
		linkedList.insertBegin(12);
		linkedList.insertBegin(56);
		linkedList.insertBegin(89);

		linkedList.traverse();

		linkedList.insertEnd(89);
		linkedList.insertEnd(45);
		linkedList.insertEnd(32);

		linkedList.traverse();

		linkedList.insertAt(33, 6);
		linkedList.insertAt(1, 0);
		linkedList.insertAt(99, 3);

		linkedList.traverse();
		linkedList.reverseTraverse();

		linkedList.deleteBegin();
		linkedList.deleteBegin();

		linkedList.traverse();

		linkedList.deleteAt(4);
		linkedList.deleteAt(3);

		linkedList.traverse();

		linkedList.deleteEnd();
		linkedList.deleteEnd();

		linkedList.traverse();
	}
}