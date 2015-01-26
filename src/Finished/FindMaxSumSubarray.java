package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMaxSumSubarray {
	public static int find1(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		if (array.length == 1)
			return array[0];
		int sum = array[0];
		int result = sum;
		for (int i = 1; i < array.length; ++i) {
			if (array[i] >= 0) {
				if (sum >= 0)
					sum += array[i];
				else
					sum = array[i];
			}
			else {
				result = Math.max(result, sum);
				if (sum + array[i] >= 0)
					sum += array[i];
				else
					sum = array[i];
			}
		}
		result = Math.max(result, sum);
		return result;
	}
	
	/*
	 * assume the subarray is a[i] - a[j] (i > j)
	 * then its sum = sum(0, i) - sum(0, j)
	 */
	public static int find2(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int sum = array[0];
		int result = sum;
		int min = 0;
		for (int i = 1; i < array.length; ++i) {
			min = Math.min(sum, min);
			sum += array[i];
			result = Math.max(result, sum - min);
		}
		return result;
	}
	
	@Test
	public void tc01() {
		int[] array = {1,2,-3,4,-6,4,2};
		assertTrue(find1(array) == 6);
		assertTrue(find2(array) == 6);

	}
	
	@Test
	public void tc02() {
		int[] array = {1,2,3,4,6,4,2};
		assertTrue(find1(array) == 22);
		assertTrue(find2(array) == 22);

	}
	
	@Test
	public void tc03() {
		int[] array = {-1,-2,-3,-4,-6,-4,-2};
		assertTrue(find1(array) == -1);
		assertTrue(find2(array) == -1);

	}
	
	@Test
	public void tc04() {
		int[] array = {1,2,3,-4,6,4,2};
		assertTrue(find1(array) == 14);
		assertTrue(find2(array) == 14);

	}
}
