// https://leetcode.com/problems/linked-list-cycle-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (slow != null) {

            slow = slow.next;
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (slow == null || fast == null || fast.next == null) return null;

        slow = head;

        while (slow != null) {

            if (fast == slow) return slow;
            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }
}