package Finished;

public class SearchInRotatedArray {
	public static boolean search(int[] array, int val) {
		if (array == null || array.length == 0)
			return false;
		return search(array, 0, array.length - 1, val);
	}
	
	private static boolean search(int[] array, int beg, int end, int val) {
		if (end == beg)
			return val == array[beg];
		if (end - beg == 1)
			return val == array[beg] || val == array[end];
		int mid = beg + (end - beg) / 2;
		if (array[beg] == val || array[mid] == val || array[end] == val)
			return true;
		if (array[beg] < array[end]) {
			if (array[beg] > val || array[end] < val)
				return false;
			else if (array[mid] > val)
				return search(array, beg + 1, mid - 1, val);
			else
				return search(array, mid + 1, end - 1, val);
		}
		else if (array[beg] > array[end]) {
			if (array[mid] > val)
				return search(array, beg + 1, mid - 1, val);
			else
				return search(array, mid + 1, end- 1, val);
		}
		else {
			return search(array, beg, mid - 1, val) || search(array, mid + 1, end - 1, val);
		}
	}
}
