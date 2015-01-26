package Finished;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Utils.ListNode;

public class DeepCopyLinkedList {

	/*
	 * use hash map
	 * time complexity: o(n)
	 * memory complexity: o(n)
	 */
	public static ListNode deepCopy1(ListNode node) {
		if (node == null)
			return null;
		Map<ListNode, ListNode> relations = new HashMap<ListNode, ListNode>();
		ListNode curr = node;
		while (curr != null) {
			ListNode newNode = new ListNode(curr.val);
			relations.put(curr, newNode);
			curr = curr.next;
		}
		curr = node;
		while (curr != null) {
			ListNode dup = relations.get(curr);
			dup.next = relations.get(curr.next);
			dup.jump = relations.get(curr.jump);
			curr = curr.next;
		}
		return relations.get(node);
	}
	
	/*
	 * time complexity: o(n)
	 * memory complexity: o(1)
	 */
	public static ListNode deepCopy2(ListNode node) {
		if (node == null)
			return null;
		ListNode curr = node;
		while (curr != null) {
			ListNode tmp = new ListNode(curr.val);
			tmp.jump = curr.jump;
			tmp.next = curr.next;
			curr.next = tmp;
			curr = curr.next.next;
		}
		curr = node;
		ListNode dupHead = curr.next;
		ListNode currDup = dupHead;
		while (true) {
			if (currDup.jump != null)
				currDup.jump = currDup.jump.next;
			currDup = currDup.next;
			if (currDup == null)
				break;
			else
				currDup = currDup.next;
		}
		currDup = dupHead;
		while (true) {
			curr.next = currDup.next;
			curr = curr.next;
			if (curr == null)
				break;
			else {
				currDup.next = curr.next;
				currDup = currDup.next;
			}
		}
		return dupHead;
	}
	
	@Test
	public void tc01() {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.jump = head.next.next;
		head.next.jump = head.next.next.next;
		ListNode dup = deepCopy1(head);
		head.printList();
		dup.printList();
	}
	
	@Test
	public void tc02() {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.jump = head.next.next;
		head.next.jump = head.next.next.next;
		ListNode dup = deepCopy2(head);
		head.printList();
		dup.printList();
	}
}
