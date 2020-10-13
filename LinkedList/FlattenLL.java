// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null) return head;

        Node tmp = head;
        Stack<Node> stk = new Stack<>();

        while (tmp != null) {

            if (tmp.child != null) {

                if (tmp.next != null) stk.push(tmp.next);
                tmp.next = tmp.child;
                tmp.next.prev = tmp;
                tmp.child = null;

            } else if (tmp.next == null && !stk.isEmpty()) {

                tmp.next = stk.pop();
                tmp.next.prev = tmp;
            }

            tmp = tmp.next;
        }

        return head;
    }
}