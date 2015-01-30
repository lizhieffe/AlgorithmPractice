package CareerCupGoogle;

import org.junit.Test;

import Utils.ListNode;

public class ReverseLinkedList {
	public static ListNode reverse(ListNode node) {
		if (node == null)
			return node;
		ListNode dummy = new ListNode(0);
		dummy.next = node;
		ListNode end = node;
		while (end.next != null) {
			ListNode toMove = end.next;
			end.next = end.next.next;
			toMove.next = dummy.next;
			dummy.next = toMove;
		}
		return dummy.next;
	}
	
	@Test
	public void tc01() {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		ListNode result = reverse(head);
		System.out.print(result);
	}
}
