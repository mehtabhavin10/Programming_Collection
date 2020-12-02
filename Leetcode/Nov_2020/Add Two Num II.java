/*

https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3522/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode sumList = null;

        while (l1 != null || l2 != null || carry > 0) {

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(carry % 10);
            newNode.next = sumList;
            sumList = newNode;
            carry /= 10;
        }


        return sumList;
    }


    ListNode reverse(ListNode head) {

        ListNode tmp = head, newHead = null, prev;

        while (tmp != null) {

            prev = newHead;
            newHead = tmp;
            tmp = tmp.next;
            newHead.next = prev;
        }

        return newHead;
    }
}