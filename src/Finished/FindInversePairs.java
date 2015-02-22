package Finished;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindInversePairs {
	/*
	 * brutal force
	 * o(n^2)
	 */
	public static long find1(int[] ar) {
		long result = 0;
		if (ar == null || ar.length <= 1)
			return result;
		for (int i = 0; i < ar.length - 1; ++i)
			for (int j = i + 1; j < ar.length; ++j)
				if (ar[i] > ar[j])
					++result;
		return result;
	}
	
	/*
	 * merge sort
	 * o(nlog(n)) 
	 */
	public static long find2(int[] ar) {
		if (ar == null || ar.length < 2)
			return 0;
		return sort(ar, 0, ar.length - 1);
	}
	
	private static long sort(int[] ar, int beg, int end) {
		if (end == beg)
			return 0;
		if (end - beg == 1) {
			if (ar[beg] > ar[end]) {
				swap(ar, beg, end);
				return 1;
			}
			else
				return 0;
		}
		long result = 0;
		int mid = beg + (end - beg) / 2;
		result += sort(ar, beg, mid);
		result += sort(ar, mid + 1, end);
		result += merge(ar, beg, mid, end);
		return result;
	}
	
	private static long merge(int[] ar, int beg, int mid, int end) {
		int[] tmp = new int[end - beg + 1];
		long result = 0;
		int index1 = beg;
		int index2 = mid + 1;
		for (int i = 0; i < tmp.length; ++i) {
			if (index1 > mid) {
				tmp[i] = ar[index2++];
			}
			else if (index2 > end) {
				tmp[i] = ar[index1++];
			}
			else if (ar[index1] <= ar[index2])
				tmp[i] = ar[index1++];
			else {
				tmp[i] = ar[index2++];
				result += mid - index1 + 1;
			}
		}
		System.arraycopy(tmp, 0, ar, beg, tmp.length);
		return result;
	}
	
	private static void swap(int[] ar, int i, int j) {
		if (i != j) {
			int tmp = ar[i];
			ar[i] = ar[j];
			ar[j] = tmp;
		}
	}
	
	@Test
	public void tc01() {
		int[] ar = {4, 3, 2, 1};
		assertTrue(find1(ar) == 6);
		assertTrue(find2(ar) == 6);

	}
	
	@Test
	public void tc02() {
		int[] ar = {5, 6, 4, 3, 2, 1};
		assertTrue(find1(ar) == 14);
		assertTrue(find2(ar) == 14);

	}
	
	public static void main(String[] args) {
		BufferedReader br;
		List<Integer> list = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader(
					"/Users/zhili/Development/CourseraAlgorithm/src/Finished/IntegerArray.txt"));
			String line;
			while ((line = br.readLine()) != null) {
			   list.add(Integer.parseInt(line));
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			array[i] = list.get(i);
//		Arrays.sort(array);
		long result = find2(array);
		System.out.println(result);
	}
}
