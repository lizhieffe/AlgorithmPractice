package CareerCupGoogle;

import org.junit.Test;

/*
 * Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a special way.After that,the negative integers should in the front,and the positive integers should in the back.Also the relative position should not be changed. 
eg. -1 1 3 -2 2 ans: -1 -2 1 3 2. 
o(n)time complexity and o(1) space complexity is perfect.
 */

/*
 * http://www.careercup.com/question?id=5201559730257920
 * cannot only get o(nlog(n)) time
 */
public class SortArrayBySign {
	public static void sort(int[] array) {
		if (array == null || array.length == 0)
			return;
		sort(array, 0, array.length - 1);
	}
	
	private static void sort(int[] array, int beg, int end) {
		if (beg == end)
			return;
		if (end - beg == 1) {
			if (array[beg] >= 0 && array[end] < 0)
				swap(array, beg, end);
			return;
		}
		int mid = beg + (end - beg) / 2;
		sort(array, beg, mid);
		sort(array, mid + 1, end);
		int mid1 = findFirstPositive(array, beg, mid);
		int mid2 = findFirstPositive(array, mid + 1, end);
		reverse(array, mid1, mid);
		reverse(array, mid + 1, mid2 - 1);
		reverse(array, mid1, mid2 - 1);
	}
	
	private static void swap(int[] array, int beg, int end) {
		if (beg != end) {
			int tmp = array[beg];
			array[beg] = array[end];
			array[end] = tmp;
		}
	}
	
	private static void reverse(int[] array, int beg, int end) {
		while (beg < end) {
			swap(array, beg++, end--);
		}
	}
	
	/*
	 * can be replaced by binary search
	 */
	private static int findFirstPositive(int[] array, int beg, int end) {
		for (int i = beg; i <= end; ++i)
			if (array[i] >= 0)
				return i;
		return end + 1;
	}
	
	@Test
	public void tc01() {
		int[] array = {-1,2,-3,4,-5,6,-7,8};
		sort(array);
		System.out.println();
	}
	
	@Test
	public void tc02() {
		int[] array = {1,2,-3,-4,5,6,7,-8};
		sort(array);
		System.out.println();
	}
}
