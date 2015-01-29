package CareerCupGoogle;

import org.junit.Test;

import Utils.TreeNode;

/*
 * http://www.careercup.com/question?id=4863668900593664
 * Given a binary search tree (BST), write a mehtod that will convert this BST into a doubly linked list that is sorted (ascending or descending order) and returns the first element in this list. You may assume you are given following Node class:


public class Node {
	public Node left, right;
	public String val;
}
Example: The following BST 
G 
/ \ 
A T 
can be converted into a list 
A = G = T 

Do it in place! Hnce the memory complexity of your algorithm shoul be O(1).
 */
public class BSTToDoublyLinkedList {
	public TreeNode convert(TreeNode root) {
		TreeNode dummy = new TreeNode(0);
		convert(dummy, root);
		return dummy.right;
	}
	
	private TreeNode convert(TreeNode head, TreeNode node) {
		if (node == null)
			return head;
		TreeNode pre = convert(head, node.left);
		pre.right = node;
		node.left = pre;
		TreeNode end = convert(node, node.right);
		return end;
	}
	
	@Test
	public void tc01() {
		TreeNode root = new TreeNode(100);
		root.left = new TreeNode(50);
		root.right = new TreeNode(150);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(75);
		root.right.left = new TreeNode(125);
		root.right.right = new TreeNode(200);
		
		BSTToDoublyLinkedList service = new BSTToDoublyLinkedList();
		TreeNode head = service.convert(root);
		System.out.println();
	}
}
