package Tree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Utils.TreeNode;
import Utils.TreeNodeUtil;

public class FindLCAInBT {
	
	/*
	 * assume each node have a reference to its parent
	 */
	public static TreeNode findUsingParentRef(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null || n1 == root || n2 == root)
			return root;
		int depth1 = TreeNodeUtil.findDepth(n1);
		int depth2 = TreeNodeUtil.findDepth(n2);
		if (depth1 < depth2) {
			TreeNode tmp = n1;
			n1 = n2;
			n2 = tmp;
			int tmpDepth = depth1;
			depth1 = depth2;
			depth2 = tmpDepth;
		}
		TreeNode t1 = n1;
		TreeNode t2 = n2;
		for (int i = 0; i < depth1 - depth2; i++)
			t1 = t1.parent;
		while (t1 != t2) {
			t1 = t1.parent;
			t2 = t2.parent;
		}
		return t1;
	}
	
	@Test
	public void test01() {
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.left.parent = root;
		root.right = new TreeNode(150);
		root.right.parent = root;
		root.left.left = new TreeNode(0);
		root.left.left.parent = root.left;
		root.left.right = new TreeNode(75);
		root.left.right.parent = root.left;
		root.right.left = new TreeNode(125);
		root.right.left.parent = root.right;
		root.right.right = new TreeNode(200);
		root.right.right.parent = root.right;
		
		assertTrue(findUsingParentRef(root, root.left, root.left.left).val == 50);
		assertTrue(findUsingParentRef(root, root.left, root.left.right).val == 50);
		assertTrue(findUsingParentRef(root, root.right.right, root.left.left).val == 100);

	}
}
