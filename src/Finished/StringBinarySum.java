package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBinarySum {
	/*
	 * Given two binary strings, return their sum (also a binary string). 
	 * For example, a = "11" b = "1" Return "100".
	 */
	
	public static String addBinary(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		if (s1 == null && s2 == null)
			return sb.toString();
		if (s1 == null || s1.length() == 0)
			return s2;
		if (s2 == null || s2.length() == 0)
			return s1;
		int mod = 0;
		int v1, v2;
		for (int i = 0; i < Math.max(s1.length(),  s2.length()); ++i) {
			if (i < s1.length())
				v1 = (int)(s1.charAt(s1.length() - 1- i) - '0');
			else
				v1 = 0;
			if (i < s2.length())
				v2 = (int)(s2.charAt(s2.length() - 1- i) - '0');
			else
				v2 = 0;
			sb.insert(0, (v1 + v2 + mod) % 2);
			mod = (v1 + v2 + mod) / 2;
		}
		if (mod == 1)
			sb.insert(0, mod);
		return sb.toString();
	}
	
	@Test
	public void tc01() {
		String s1 = "0010010";
		String s2 = "1111111";
		assertTrue(addBinary(s1, s2).equals("10010001"));
	}
}
