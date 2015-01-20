package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatePattern {

	/*
	 * a string (consists of 0 and 1) contains two valid patterns:
	 * 1. if a char start with '0', then '0' itself is a pattern
	 * 2. if a char start with '1', then '1' and the letter after it (can be either 0 or 1) is a pattern
	 * Given a string, determine whether this string is valid. Do it from end to start
	 */
	
	/*
	 * TODO: add dp 
	 */
	public static boolean isValid(int[] ar) {
		if (ar == null || ar.length == 0)
			return true;
		boolean result = isPattern1(ar, ar.length - 1);
		if (result)
			return result;
		result = isPattern2(ar, ar.length - 1);
		return result;
	}
	
	private static boolean isPattern1(int[] ar, int beg) {
		if (beg < 0)
			return true;
		if (ar[beg] == 0)
			return isPattern1(ar, beg - 1) || isPattern2(ar, beg - 1);
		else
			return false;
	}
	
	private static boolean isPattern2(int[] ar, int beg) {
		if (beg == 0)
			return false;
		if (beg < 0)
			return true;
		if (ar[beg - 1] == 0)
			return false;
		else
			return isPattern1(ar, beg - 2) || isPattern2(ar, beg - 2);
	}
	
	@Test
	public void tc01() {
		int[] ar1 = {1, 0, 0, 1};
		int[] ar2 = {1, 0, 0, 1, 0};
		assertTrue(isValid(ar1) == false);
		assertTrue(isValid(ar2) == true);
	}
}
