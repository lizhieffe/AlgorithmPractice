package Finished;

import org.junit.Test;

import Utils.ListNode;

public class RemoveNthNodeFromEndOfList {
	/*
	 * Given a linked list, remove the nth node from the end of list and return its head.
For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
	 */
	public static ListNode remove(ListNode node, int n) {
		if (n <= 0 || node == null)
			return node;
		ListNode dummy = new ListNode(0);
		dummy.next = node;
		ListNode curr = dummy;
		for (int i = 0; i < n; ++i) {
			if (curr.next == null)
				return node;
			curr = curr.next;
		}
		ListNode pre = dummy;
		ListNode second = dummy;
		while (curr != null) {
			curr = curr.next;
			pre = second;
			second = second.next;
		}
		pre.next = second.next;
		return dummy.next;
	}
	
	@Test
	public void tc01() {
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);
		node.printList();
		remove(node, 7).printList();;
	}
}
