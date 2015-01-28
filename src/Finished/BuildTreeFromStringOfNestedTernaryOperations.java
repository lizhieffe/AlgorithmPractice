package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

import Utils.TreeNode;

public class BuildTreeFromStringOfNestedTernaryOperations {
	public static TreeNode build(String s) {
		if (s == null || s.length() == 0)
			return null;
		char[] c = s.toCharArray();
		return build(c, 0, c.length - 1);
	}
	
	private static TreeNode build(char[] c, int beg, int end) {
		if (beg >= c.length || beg > end)
			return null;
		TreeNode node = new TreeNode(c[beg] - '0');
		if (beg == end)
			return node;
		int cut = findCut(c, beg + 2);
		node.left = build(c, beg + 2, cut - 1);
		node.right = build(c, cut + 1, end);
		return node;
	}
	
	private static int findCut(char[] c, int beg) {
		if (beg >= c.length)
			return c.length;
		int exclamationCount = 0;
		int i = beg;
		while (true) {
			if (c[i] == '?')
				++exclamationCount;
			else if (c[i] == ':') {
				if (exclamationCount == 0)
					return i;
				else
					--exclamationCount;
			}
			++i;
		}
	}
	
	@Test
	public void tc01() {
		String s = "1?2:3";
		TreeNode node = build(s);
		assertTrue(node.val == 1);
	}
	
	@Test
	public void tc02() {
		String s = "1?2?:3:4";
		TreeNode node = build(s);
		assertTrue(node.val == 1);
	}
}
