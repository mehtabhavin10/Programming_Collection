package DS;

import DS.TreeDS.*;

class DriverCode {

	public static void main(String[] args) {


		int[] a = {10, 8, 7, 9, 12, 11, 13};


		CodecTree<Integer> codec = new CodecTree<>();

		String ip = "";

		for (int i = a.length - 1; i >= 0; i--) ip = a[i] + "," + ip;

		System.out.println(ip);

		TreeNode<Integer> root = codec.deserialize(ip);

		System.out.println(codec.serialize(root));
	}
}