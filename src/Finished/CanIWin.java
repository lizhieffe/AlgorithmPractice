package Finished;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CanIWin {

	/*
	 * there are 2 players, can pick number 1 - N iteratively. The player who reach the total sum >= K wins
	 * there are 2 sub cases:
	 * 1) the 1 - N can be used infinite times
	 * 2) the 1 - N can only be used once (if A used n, then A or B cannot use n again)
	 */
	
	public static boolean canIWin1(int N, int K) {
		if (K % (N + 1) == 0)
			return false;
		else
			return true;
	}
	
	public static boolean canIWin2(int N, int K) {
		if (N <= 0 || K < 0)
			return false;
		if (K == 0)
			return true;
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= N; ++i) {
			sum += i;
			list.add(i);
		}
		if (sum < K)
			return false;
		return canIWin2(list, K);
	}
	
	private static boolean canIWin2(List<Integer> list, int K) {
		if (list.get(list.size() - 1) >= K)
			return true;
		for (int i = 0; i < list.size(); ++i) {
			int remove = list.remove(i);
			if (!canIWin2(list, K - remove)) {
				list.add(i, remove);
				return true;
			}
			list.add(i, remove);
		}
		return false;
	}
	
	@Test
	public void tc01() {
		int N = 10;
		int K = 99;
		assertTrue(canIWin1(N, K) == false);
	}
	
	@Test
	public void tc02() {
		int N = 10;
		int K = 100;
		assertTrue(canIWin1(N, K) == true);
	}
	
	@Test
	public void tc03() {
		int N = 3;
		int K = 5;
		assertTrue(canIWin2(N, K) == true);
	}
	
	@Test
	public void tc04() {
		int N = 3;
		int K = 4;
		assertTrue(canIWin2(N, K) == false);
	}
}
