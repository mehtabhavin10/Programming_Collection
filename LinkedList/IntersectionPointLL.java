// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode startA = headA, startB = headB;
        ListNode tmp1 = startA, tmp2 = startB;

        while (tmp1 != null && tmp2 != null) {

            if (tmp1 == tmp2) return tmp1;

            tmp1 = tmp1.next;
            tmp2 = tmp2.next;

            if (tmp1 == null) {

                tmp1 = startB;
                startB = null;
            }

            if (tmp2 == null) {

                tmp2 = startA;
                startA = null;
            }
        }

        return null;
    }
}