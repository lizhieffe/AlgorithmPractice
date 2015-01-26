package Finished;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FindMaxMultipleSubarray {
	public static int find1(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int max = array[0];
		int min = array[0];
		int result = max;
		for (int i = 1; i < array.length; ++i) {
			if (array[i] == 0) {
				max = 0;
				min = 0;
			}
			else if (array[i] > 0) {
				max = Math.max(max * array[i], array[i]);
				min = Math.min(min * array[i], array[i]);
			}
			else {
				max = Math.max(min * array[i], array[i]);
				min = Math.min(max * array[i], array[i]);
			}
			result = Math.max(max, result);
		}
		return result;
	}
	
	@Test
	public void tc01() {
		int[] array = {1,2,3};
		assertTrue(find1(array) == 6);

	}
	
	@Test
	public void tc02() {
		int[] array = {1,0,-3};
		assertTrue(find1(array) == 1);

	}
	
	@Test
	public void tc03() {
		int[] array = {-1,2,-3};
		assertTrue(find1(array) == 6);

	}
	
	@Test
	public void tc04() {
		int[] array = {1,-1,3};
		assertTrue(find1(array) == 3);

	}
}
