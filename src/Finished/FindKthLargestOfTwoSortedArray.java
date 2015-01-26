package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindKthLargestOfTwoSortedArray {
	public int find(int[] ar1, int[] ar2, int k) {
		if (ar1 == null && ar2 == null)
			return 0;
		if (ar1.length == 0 || ar2.length == 0)
			return 0;
		if (k <= 0)
			k = 1;
		if (k > ar1.length + ar2.length)
			k = ar1.length + ar2.length;
		if (ar1.length == 0)
			return ar2[k - 1];
		if (ar2.length == 0)
			return ar1[k - 1];
		return find(ar1, 0, ar2, 0, k);
	}
	
	private int find(int[] ar1, int beg1, int[] ar2, int beg2, int k) {
		if (beg1 == ar1.length)
			return ar2[k - 1 + beg2];
		if (beg2 == ar2.length)
			return ar1[k - 1 + beg1];
		if (k == 1)
			return Math.min(ar1[beg1], ar2[beg2]);
		if (k == ar1.length - beg1 + ar2.length - beg2)
			return Math.max(ar1[ar1.length - 1], ar2[ar2.length - 1]);
		int n = (ar1.length - beg1) * k / (ar1.length - beg1 + ar2.length - beg2);
		if (n == 0)
			n = 1;
		int index1 = beg1 + n - 1;
		int index2 = beg2 + k - n - 1;
		if (ar1[index1] == ar2[index2])
			return ar1[index1];
		if (ar1[index1] > ar2[index2])
			return find(ar1, beg1, ar2, index2 + 1, n);
		else
			return find(ar1, index1 + 1, ar2, beg2, k - n);
	}
	
	@Test
	public void tc01() {
		int[] ar1 = {1,3,5,7,9};
		int[] ar2 = {2,4,6,8,10};
		FindKthLargestOfTwoSortedArray test = new FindKthLargestOfTwoSortedArray();
		assertTrue(test.find(ar1, ar2, 1) == 1);
		assertTrue(test.find(ar1, ar2, 2) == 2);
		assertTrue(test.find(ar1, ar2, 3) == 3);
		assertTrue(test.find(ar1, ar2, 4) == 4);
		assertTrue(test.find(ar1, ar2, 5) == 5);
		assertTrue(test.find(ar1, ar2, 6) == 6);
		assertTrue(test.find(ar1, ar2, 7) == 7);
		assertTrue(test.find(ar1, ar2, 8) == 8);
	}
	
	@Test
	public void tc02() {
		int[] ar1 = {1,2,3,4,5};
		int[] ar2 = {6,7,8,9,10};
		FindKthLargestOfTwoSortedArray test = new FindKthLargestOfTwoSortedArray();
		assertTrue(test.find(ar1, ar2, 1) == 1);
		assertTrue(test.find(ar1, ar2, 2) == 2);
		assertTrue(test.find(ar1, ar2, 3) == 3);
		assertTrue(test.find(ar1, ar2, 4) == 4);
		assertTrue(test.find(ar1, ar2, 5) == 5);
		assertTrue(test.find(ar1, ar2, 6) == 6);
		assertTrue(test.find(ar1, ar2, 7) == 7);
		assertTrue(test.find(ar1, ar2, 8) == 8);
	}
	
	@Test
	public void tc03() {
		int[] ar1 = {1,2,3,4,5};
		int[] ar2 = {6};
		FindKthLargestOfTwoSortedArray test = new FindKthLargestOfTwoSortedArray();
		assertTrue(test.find(ar1, ar2, 1) == 1);
		assertTrue(test.find(ar1, ar2, 2) == 2);
		assertTrue(test.find(ar1, ar2, 3) == 3);
		assertTrue(test.find(ar1, ar2, 4) == 4);
		assertTrue(test.find(ar1, ar2, 5) == 5);
		assertTrue(test.find(ar1, ar2, 6) == 6);
	}
}
