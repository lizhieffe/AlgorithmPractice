package CareerCupGoogle;

import org.junit.Test;

import Utils.TreeNode;

/*
 * Given preorder traversal array of a BST, recontruct the BST.
 * 
 * o(n) time
 */
public class RecoverBST {
	
	private int curr = 0;
	
	public TreeNode recover(int[] array) {
		if (array == null || array.length == 0)
			return null;
		return recover(array, Integer.MAX_VALUE);
	}
	
	private TreeNode recover(int[] array, int limit2) {
		if (curr >= array.length)
			return null;
		TreeNode root = new TreeNode(array[curr++]);
		if (curr < array.length && array[curr] < root.val)
			root.left = recover(array, root.val);
		if (curr < array.length && array[curr] < limit2)
			root.right = recover(array,limit2);
		return root;
	}
	
	@Test
	public void tc01() {
		int[] array = {10,5,1,8,15,12,18};
		TreeNode result = new RecoverBST().recover(array);
		System.out.println();
	}
}
