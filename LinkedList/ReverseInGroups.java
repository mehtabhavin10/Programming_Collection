// https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1) return head;

        int len = 0;

        ListNode tmp = head;

        while (tmp != null) {

            tmp = tmp.next;
            len++;
        }

        return reverseRecursive(head, k, len / k);
    }

    ListNode reverseRecursive(ListNode head, int k, int index) {

        if (index == 0) return head;

        ListNode p = head, q = null, r = null, nextNode = null;
        int count = k;

        while (p != null && count > 0) {

            nextNode = p.next;
            r = q;
            q = p;
            p = p.next;
            q.next = r;
            count--;
        }

        if (nextNode != null) head.next = reverseRecursive(nextNode, k, index - 1);

        return q;
    }
}