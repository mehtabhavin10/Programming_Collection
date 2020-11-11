/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.equals("")) return null;

        Queue<String> q = new LinkedList<>();
        String[] ip = data.split(",");

        for (String s : ip) q.add(s);

        return generate(q);
    }


    private TreeNode generate(Queue<String> q) {

        while (!q.isEmpty()) {

            String tmp = q.remove();

            if (tmp.equals("")) return null;

            TreeNode root = new TreeNode(Integer.parseInt(tmp));

            root.left = generate(q);
            root.right = generate(q);

            return root;
        }

        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));