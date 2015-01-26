package Finished;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * 找一个字符串中最长的只含有N种不同的字符的子字符串
 */
public class FindLongestSubstringWithNKindsCharacters {
	public static int find(String s, int n) {
		if (s == null || s.length() == 0 || n <= 0)
			return 0;
		if (s.length() < n)
			return s.length();
		char[] c = s.toCharArray();
		Map<Character, Integer> found = new HashMap<Character, Integer>();
		int end = findFirstSubstring(c, found, n);
		if (end == c.length - 1)
			return c.length;
		int result = end + 1;
		Range range = new Range(0, end);
		while (range.end < c.length - 1) {
			range = moveToNext(c, found, range, n);
			if (range.end - range.start + 1 > result)
				result = range.end - range.start + 1;
		}
		return result;
	}
	
	private static int findFirstSubstring(char[] c, Map<Character, Integer> found, int n) {
		for (int i = 0; i < c.length; ++i) {
			if (found.containsKey(c[i])) {
				found.put(c[i], found.get(c[i]) + 1);
			}
			else {
				if (found.size() == n)
					return i - 1;
				else
					found.put(c[i], 1);
			}
		}
		return c.length - 1;
	}
	
	private static Range moveToNext(char[] c, Map<Character, Integer> found
			, Range range, int n) {
		int start = range.start;
		int end = range.end;
		while (true) {
			if (found.get(c[start]) == 1) {
				found.remove(c[start++]);
				break;
			}
			else
				found.put(c[start], found.get(c[start]) - 1);
			++start;
		}
		for (int i = end + 1; i < c.length; ++i) {
			if (found.containsKey(c[i])) {
				found.put(c[i], found.get(c[i]) + 1);
			}
			else {
				if (found.size() == n)
					return new Range(start, i - 1);
				else
					found.put(c[i], 1);
			}
		}
		return new Range(start, c.length - 1);
	}
	
	@Test
	public void tc01() {
		String s = "123412332431";
		int n = 3;
		assertTrue(find(s, n) == 6);
	}
}

class Range {
	int start;
	int end;
	Range(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
