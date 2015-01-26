package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class CanCombileString {
	public static boolean canCombine(String a, String b, String c) {
		if (a == null || b == null || c == null)
			return false;
		if (a.length() + b.length() != c.length())
			return false;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		char[] cc = c.toCharArray();
		int j = 0;
		int k = 0;
		for (int i = 0; i < cc.length; ++i) {
			if (j == ac.length) {
				if (bc[k++] != cc[i])
					return false;
			}
			else if (k == bc.length) {
				if (ac[j++] != cc[i])
					return false;
			}
			else if (ac[j] == cc[i])
				++j;
			else if (bc[k] == cc[i])
				++k;
			else
				return false;
		}
		return true;
	}
	
	@Test
	public void tc01() {
		String a = "abc";
		String b = "";
		String c = "abc";
		String d = "bac";
		assertTrue(canCombine(a, b, c) == true);
		assertTrue(canCombine(a, b, d) == false);
	}
	
	@Test
	public void tc02() {
		String a = "abc";
		String b = "dbe";
		String c = "adbbec";
		String d = "dabbce";
		assertTrue(canCombine(a, b, c) == true);
		assertTrue(canCombine(a, b, d) == true);
	}
}
