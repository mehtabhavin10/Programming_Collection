// https://leetcode.com/problems/rotate-list/

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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;

        int n = 1;

        ListNode tmp = head;

        while (tmp.next != null) {

            n++;
            tmp = tmp.next;
        }

        k = k % n;

        if (k == 0) return head;

        tmp.next = head;
        tmp = head;

        ListNode par = null;

        while (n - k > 0) {

            par = tmp;
            tmp = tmp.next;
            n--;
        }

        par.next = null;
        return tmp;
    }
}