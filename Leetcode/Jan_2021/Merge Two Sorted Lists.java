/*

https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3592/


Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head, tail;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;

        } else {
            head = l2;
            l2 = l2.next;
        }

        tail = head;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {

                tail.next = l1;
                l1 = l1.next;

            } else {

                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        while (l1 != null) {

            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {

            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        tail.next = null;

        return head;
    }
}