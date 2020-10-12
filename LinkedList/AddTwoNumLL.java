// https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean carry = false;
        ListNode head = null, tail = null;

        while (l1 != null || l2 != null) {

            int sum = (carry ? 1 : 0);

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum > 9) carry = true;
            else carry = false;

            int v = sum % 10;

            ListNode newNode  = new ListNode(v);
            if (head == null) head = newNode;
            if (tail != null) tail.next = newNode;
            tail = newNode;
        }

        if (carry) {

            ListNode newNode  = new ListNode(1);
            if (head == null) head = newNode;
            if (tail != null) tail.next = newNode;
            tail = newNode;
        }

        return head;
    }
}