package Finished;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FindMinDistanceBetweenTwoArray {

	/*
	 * given two arraies A, B. Find the min distance among A and B elements
	 */
	public static int getMin(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0)
			return -1;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i = 0;
		int j = 0;
		int result = Integer.MAX_VALUE;
		while (i < arr1.length && j < arr2.length) {
			int tmp = Math.abs(arr1[i] - arr2[j]);
			if (tmp < result)
				result = tmp;
			if (result == 0)
				return result;
			if (arr1[i] > arr2[j])
				j++;
			else
				i++;
		}
		return result;
	}
	
	@Test
	public void tc01() {
		int[] arr1 = {1, 10, 25};
		int[] arr2 = {5, 18};
		assertTrue(getMin(arr1, arr2) == 4);
	}
}
