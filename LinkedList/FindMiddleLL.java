// https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode middleNode(ListNode head) {

        if (head.next == null) return head;

        ListNode fastTmp = head.next;

        while (fastTmp != null) {

            head = head.next;

            if (fastTmp.next == null) break;

            fastTmp = fastTmp.next.next;
        }

        return head;
    }
}