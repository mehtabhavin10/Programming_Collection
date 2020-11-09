// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if (root == null) return root;

        Node dummy = new Node(-1);
        Node head = root;
        Node prev = dummy;

        while (head != null) {

            Node curr = head;

            while (curr != null) {

                if (curr.left != null) {

                    prev.next = curr.left;
                    prev = prev.next;
                }

                if (curr.right != null) {

                    prev.next = curr.right;
                    prev = prev.next;
                }

                curr = curr.next;
            }

            head = dummy.next;
            dummy.next = null;
            prev = dummy;
        }

        return root;
    }
}