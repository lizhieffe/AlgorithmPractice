package Utils;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode jump;
	private static int count = 0;
	private int id;
	public ListNode(int x) {
		val = x;
		next = null;
		id = count++;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = " + id);
		sb.append(", val = " + val);
		if (next == null)
			sb.append(", next val = " + "NULL");
		else
			sb.append(", next val = " + next.val);

		if (jump == null)
			sb.append(", jump val = " + "NULL");
		else
			sb.append(", jump val = " + jump.val);		
		return sb.toString();
	}
	
	public void printList() {
		System.out.println(this.toString());
		if (next != null)
			next.printList();
	}
}
