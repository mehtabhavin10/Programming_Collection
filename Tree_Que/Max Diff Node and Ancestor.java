/*

https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1#

Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B.

Example 1:

Input:
    5
 /    \
2      1
Output: 4
Explanation:The maximum difference we can
get is 4, which is bewteen 5 and 1.
Example 2:

Input:
      1
    /    \
   2      3
           \
            7
Output: -1
Explanation:The maximum difference we can
get is -1, which is between 1 and 2.
Your Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of edges <= 104
0 <= Data of a node <= 105

*/

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Tree {

    int maxDiff;

    int maxDiff(Node root) {
        //your code here

        if (root == null || (root.left == null && root.right == null)) return 0;

        maxDiff = Integer.MIN_VALUE;
        traverse(root.left, root.data);
        traverse(root.right, root.data);

        return maxDiff;
    }

    void traverse(Node root, int max) {

        if (root == null) return;
        maxDiff = Math.max(maxDiff, max - root.data);
        traverse(root.left, Math.max(root.data, max));
        traverse(root.right, Math.max(root.data, max));
    }
}
