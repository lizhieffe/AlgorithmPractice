package Utils;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public TreeNode(int x) { val = x; }
	public void print() {
		if (left != null)
			left.print();
		System.out.print(val + " ");
		if (right != null)
			right.print();
	}
}
