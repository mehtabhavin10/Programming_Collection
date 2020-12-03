/*

Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */



// O(N) space solution, Time is O(N) for both methods:

class Solution {

	Random r;
	List<Integer> ip;

	/** @param head The linked list's head.
	    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {

		r = new Random();
		ip = new ArrayList<>();

		while (head != null) {

			ip.add(head.val);
			head = head.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {

		return ip.get(r.nextInt(ip.size()));
	}
}



// O(1) space solution, Time is O(N) for both methods:

class Solution {

	ListNode head;
	int len;
	Random r;
	/** @param head The linked list's head.
	    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {

		r = new Random();
		this.head = head;
		len = 0;

		while (head != null) {
			head = head.next;
			len++;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {

		int i = r.nextInt(len);
		ListNode tmp = head;

		while (i-- > 0) tmp = tmp.next;
		return tmp.val;
	}
}