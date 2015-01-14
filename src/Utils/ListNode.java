package Utils;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public static ListNode asList(int[] list) {
		if (list.length == 0)
			return null;
		
		ListNode head = new ListNode(list[0]);
		ListNode cNode = head;
		
		for (int i = 1; i < list.length;) {
			ListNode newNode = new ListNode(list[i]);
			cNode.next = newNode;
			cNode = cNode.next;
			i++;
		}
		
		return head;
	}
}
