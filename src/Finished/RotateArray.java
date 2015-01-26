package Finished;

import org.junit.Test;

public class RotateArray {
	/*
	 * Array rotation.
		Index i -> index i + k, 数组旋转
	 */
	
	public static void rotate(int[] ar, int k) {
		if (ar == null || ar.length == 1 || k % ar.length == 0)
			return;
		int n = getLCA(ar.length, k);
		for (int i = 0; i < n; ++i)
			rotate(ar, k, i);
	}
	
	private static int getLCA(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		if (a % b == 0)
			return b;
		return getLCA(b, a % b);
	}
	
	private static void rotate(int[] ar, int k, int beg) {
		int curr = beg;
		int next = getNext(ar.length, k, beg);
		int val = ar[beg];
		do {
			int tmp = ar[next];
			ar[next] = val;
			val = tmp;
			curr = next;
			next = getNext(ar.length, k, curr);
		} while (curr != beg);
	}
	
	private static int getNext(int length, int step, int i) {
		return (i + step) % length;
	}
	
	@Test
	public void tc01() {
		int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 4;
		rotate(ar, k);
		System.out.println(ar);
	}
}
