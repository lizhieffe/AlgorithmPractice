package Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.TreeNode;

public class FindLCAInBST {
	/*
	 * we assume that the two nodes do exist in the tree
	 */
	public static TreeNode find(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null)
			return null;
		int v1 = n1.val;
		int v2 = n2.val;
		if (Math.max(v1, v2) < root.val)
			return find(root.left, n1, n2);
		if (Math.min(v1, v2) > root.val)
			return find(root.right, n1, n2);
		return root;
	}
	
	@Test
	public void test01() {
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(150);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(75);
		root.right.left = new TreeNode(125);
		root.right.right = new TreeNode(200);
		
		assertTrue(find(root, root.left, root.left.left).val == 50);
		assertTrue(find(root, root.left, root.left.right).val == 50);
		assertTrue(find(root, root.right.right, root.left.left).val == 100);

	}
}
