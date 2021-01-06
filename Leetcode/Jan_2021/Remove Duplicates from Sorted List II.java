/*

https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3593/


Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.



Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]


Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

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
class Solution {
	public ListNode deleteDuplicates(ListNode head) {

		ListNode dummy = new ListNode();
		ListNode prev = dummy;
		prev.next = head;

		while (head != null) {
			if (head.next == null) {
				break;
			}
			if (head.next != null && head.val != head.next.val) {
				prev = head;
				head = head.next;
			} else {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				prev.next = head.next;
				head = prev.next;
				if (prev.next != null && prev.next.next != null) {
					head = prev;
				} else if (prev.next == null || (prev.next != null && prev.next.next == null)) {
					head = null;
				}
			}
		}
		return dummy.next;
	}
}