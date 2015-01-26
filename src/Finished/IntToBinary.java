package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntToBinary {
	public static String convert(int val) {
		if (val == 0)
			return "0";
		StringBuilder builder = new StringBuilder();
		while (val > 0) {
			builder.insert(0, val % 2);
			val /= 2;
		}
		return builder.toString();
	}
	
	@Test
	public void tc01() {
		int val = 5;
		assertTrue(convert(val).equals("101"));
	}
}
