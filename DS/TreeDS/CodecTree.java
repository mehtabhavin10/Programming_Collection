package DS.TreeDS;

import DS.QueueDS.Queue;

public class CodecTree<T> {


	public String serialize(TreeNode root) {

		if (root == null) return "";
		return root.data + "," + serialize(root.left) + "," + serialize(root.right);
	}


	public TreeNode deserialize(String str) {

		if (str == null || str.equals("")) return null;

		String[] ip = str.split(",");
		Queue<String> q = new Queue<>();

		for (String s : ip) q.add(s);

		return constructTree(q);
	}


	private TreeNode constructTree(Queue<String> q) {

		while (!q.isEmpty()) {

			String curr = q.remove();

			if (curr.equals("")) return null;

			TreeNode<String> root = new TreeNode<>(curr);

			root.left = constructTree(q);
			root.right = constructTree(q);

			return root;
		}

		return null;
	}
}