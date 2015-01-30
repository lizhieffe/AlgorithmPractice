package CareerCupGoogle;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/*
 * 3-sum question:
给N = 1,000,000个不相同的int整数以及一个int X. 如果 a + b + c <= X，(a < b <
c)则称有一个triplet, 求triplet count。

o(n) time
 */
public class ThreeSumTriplet {
	public static int getTriplets(int[] array, int val) {
		if (array == null || array.length < 3)
			return 0;
		int result = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; ++i) {
			int beg = i + 1;
			int end = array.length - 1;
			while (beg < end) {
				if (array[beg] + array[end] < val) {
					result += end - beg;
					++beg;
				}
				else
					--end;
			}
		}
		return result;
	}
	
	@Test
	public void tc01() {
		int[] array = {1,2,3,30,20,9,10};
		int val = 25;
		int result = getTriplets(array, val);
		assertTrue(result == 13);
	}
}
