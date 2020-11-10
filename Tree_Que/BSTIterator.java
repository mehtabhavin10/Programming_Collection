// https://leetcode.com/problems/binary-search-tree-iterator/submissions/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    Stack<TreeNode> stk;
    TreeNode tmp;

    public BSTIterator(TreeNode root) {

        stk = new Stack<>();
        tmp = root;
    }

    /** @return the next smallest number */
    public int next() {

        int op;
        moveLeft();
        tmp = stk.pop();
        op = tmp.val;
        tmp = tmp.right;
        return op;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return tmp != null || !stk.isEmpty();
    }


    private void moveLeft() {

        while (tmp != null) {

            stk.push(tmp);
            tmp = tmp.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */