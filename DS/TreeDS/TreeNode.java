package DS.TreeDS;


public class TreeNode<T extends Comparable<? super T>> {

	public T data;
	public TreeNode left, right;
	public Integer height;

	public TreeNode(T d) {

		data = d;
		height = 1;
	}
}