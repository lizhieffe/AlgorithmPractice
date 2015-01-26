package Finished;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FindMaxSumSubsequence {
	public static int find1(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; ++i) {
			if (array[i] >= 0)
				result = Math.max(array[i], result + array[i]);
			else
				result = Math.max(result, array[i]);
		}
		return result;
	}
	
	@Test
	public void tc01() {
		int[] array = {1,2,-3,4,-6,4,2};
		assertTrue(find1(array) == 13);

	}
	
	@Test
	public void tc02() {
		int[] array = {1,2,3,4,6,4,2};
		assertTrue(find1(array) == 22);

	}
	
	@Test
	public void tc03() {
		int[] array = {-1,-2,-3,-4,-6,-4,-2};
		assertTrue(find1(array) == -1);

	}
	
	@Test
	public void tc04() {
		int[] array = {1,2,3,-4,6,4,2};
		assertTrue(find1(array) == 18);

	}
}
