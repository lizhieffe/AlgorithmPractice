package Utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeNodeUtil {

	public static int findDepth(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + findDepth(node.parent);
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
		assertTrue(findDepth(null) == 0);
		assertTrue(findDepth(root) == 1);
		assertTrue(findDepth(root.left.right) == 3);

	}
}
