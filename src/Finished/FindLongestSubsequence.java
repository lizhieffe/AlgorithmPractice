package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindLongestSubsequence {
	public int find(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int[][] dp = new int[arr.length][arr.length];
		return find(arr, 0, arr.length - 1, dp);
	}
	
	public int find(int[] arr, int beg, int end) {
		int[] newArr = new int[end - beg + 1];
		System.arraycopy(arr, beg, newArr, 0, newArr.length);
		return find(newArr);
	}
	
	private int find(int[] arr, int beg, int end, int[][] dp) {
		if (beg > end)
			return 0;
		if (beg == end)
			return 1;
		if (dp[beg][end] != 0)
			return dp[beg][end];
		int result;
		if (arr[beg] == arr[end])
			result = 2 + find(arr, beg + 1, end - 1, dp);
		else
			result = Math.max(find(arr, beg + 1, end, dp), find(arr, beg, end - 1, dp));
		dp[beg][end] = result;
		return result;
	}
	
	@Test
	public void tc01() {
		int[] arr = {1,2,3,4,5,1,5,1,3,2,1};
		assertTrue(find(arr) == 9);
	}
}
