package Tree;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.TreeNode;

public class FindMaxPathInTree {
	int result = Integer.MIN_VALUE;
	
	public int find(TreeNode root) {
		if (root == null)
			return 0;
		search(root);
		return result;
	}
	
	private int search(TreeNode node) {
		result = Math.max(result, node.val);
		int left = 0;
		int right = 0;
		if (node.left != null)
			left = search(node.left);
		if (node.right != null)
			right = search(node.right);
		if (left <= 0 && right <= 0)
			return node.val;
		if (left > 0 && right > 0) {
			result = Math.max(result, node.val + left + right);
			return node.val + Math.max(left, right);
		}
		else {
			result = Math.max(result, node.val + Math.max(left, right));
			return node.val + Math.max(left, right);
		}
	}
	
	@Test
	public void tc01() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(-2);
		root.right.right = new TreeNode(5);
		FindMaxPathInTree test = new FindMaxPathInTree();
		assertTrue(test.find(root) == 14);
	}
}
