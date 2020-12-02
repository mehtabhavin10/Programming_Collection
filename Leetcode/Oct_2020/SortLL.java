/*

https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3493/

Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?



Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105

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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        List<Integer> ip = new ArrayList<>();

        ListNode tmp = head;

        while (tmp != null) {

            ip.add(tmp.val);
            tmp = tmp.next;
        }

        Collections.sort(ip);

        tmp = head;

        for (int i : ip) {

            tmp.val = i;
            tmp = tmp.next;
        }

        return head;
    }
}

// Complexity: Time - O(NlogN), Space - O(N)

// ----------------------

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
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head, par = null;

        while (fast != null && fast.next != null) {

            par = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        par.next = null;

        return merge(sortList(head), sortList(slow));
    }

    ListNode merge(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode tail = head;

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

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return head.next;
    }
}

// Complexity: Time - O(NlogN), Space - O(1)