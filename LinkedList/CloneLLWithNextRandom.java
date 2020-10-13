// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node tmp = head, newHead = null, newTail = null;
        Map<Node, Node> map = new HashMap<>();


        while (tmp != null) {

            Node newNode = new Node(tmp.val);
            if (newHead == null) newHead = newNode;
            if (newTail != null) newTail.next = newNode;
            newTail = newNode;

            map.put(tmp, newNode);

            tmp = tmp.next;
        }

        tmp = head;
        newTail = newHead;

        while (tmp != null) {

            if (tmp.random != null) newTail.random = map.get(tmp.random);

            tmp = tmp.next;
            newTail = newTail.next;
        }

        return newHead;
    }
}