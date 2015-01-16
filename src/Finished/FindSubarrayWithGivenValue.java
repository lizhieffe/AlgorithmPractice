package Finished;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FindSubarrayWithGivenValue {
	
	/*
	 * assume the original array is non-negative
	 */
	public boolean findInNonNegative(int[] array, int target) {
		if (array == null || array.length == 0 || target < 0)
			return false;
		int i = 0;
		int j = 0;
		int sum = array[0];
		for (i = 0; i < array.length; i++) {
			while (sum < target) {
				if (j == array.length - 1)
					return false;
				sum += array[++j];
			}
			if (sum == target)
				return true;
			sum -= array[i];
			while (sum > target)
				sum -= array[j--];
		}
		return false;
	}
	
	/*
	 * find in any array (element can be <0, =0, or >0)
	 */
	public boolean findInAnyArray(int[] array, int target) {
		if (array == null || array.length == 0)
			return false;
		Map<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == target)
				return true;
			if (prefixSum.containsKey(sum - target))
				return true;
			else
				prefixSum.put(sum, i);
		}
		return false;
	}
	
	@Test
	public void tc01() {
		int[] array = {1, 3, 5, 2, 0 ,3, 32, 4};
		int target = 41;
		assertTrue(findInNonNegative(array, target) == true);
		assertTrue(findInAnyArray(array, target) == true);

	}
	
	@Test
	public void tc02() {
		int[] array = {15, 2, 4, 8, 9, 5, 10, 23};
		int target = 23;
		assertTrue(findInNonNegative(array, target) == true);
		assertTrue(findInAnyArray(array, target) == true);

	}
	
	@Test
	public void tc03() {
		int[] array = {23, -3, 15, -90, -9, 45, 60, 32, -89};
		int target = -39;
		assertTrue(findInAnyArray(array, target) == true);

	}
}
