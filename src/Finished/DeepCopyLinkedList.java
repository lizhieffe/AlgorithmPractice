package Finished;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Utils.ListNode;

public class DeepCopyLinkedList {

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
}
