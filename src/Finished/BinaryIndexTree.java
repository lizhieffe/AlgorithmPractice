package Finished;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryIndexTree {
	
	int[] BIT;
	
	public void constructBIT(int[] array) {
		if (array == null || array.length == 0)
			return;
		BIT= new int[array.length];
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			BIT[i] = sum - getSum(removeLowestBit(i + 1) - 1);
		}
	}
	
	public int getSum(int index) {
		if (index < 0 || index >= BIT.length)
			return 0;
		return BIT[index] + getSum(removeLowestBit(index + 1) - 1);
	}
	
	public void updateTo(int index, int newVal) {
		if (index < 0 || index >= BIT.length)
			return;
		int diff = newVal - (getSum(index) - getSum(index - 1));
		while (index < BIT.length) {
			BIT[index] += diff;
			index += (lowestBit(index + 1));
		}
	}
	
	public static int removeLowestBit(int i) {
		if (i <= 0)
			return 0;
		return i - lowestBit(i);
	}
	
	public static int lowestBit(int i) {
		if (i <= 0)
			return 0;
		int tmp = 1;
		while ((i & tmp) == 0)
			tmp = tmp << 1;
		return tmp;
	}
	
	@Test
	public void testcase1() {
		assertTrue(removeLowestBit(1) == 0);
		assertTrue(removeLowestBit(12) == 8);
		assertTrue(removeLowestBit(13) == 12);
	}
	
	@Test
	public void testcase2() {
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		BinaryIndexTree test = new BinaryIndexTree();
		test.constructBIT(array);
		assertTrue(test.BIT[12] == 13);
		assertTrue(test.BIT[7] == 36);
		assertTrue(test.BIT[11] == 42);
	}
	
	@Test
	public void testcase3() {
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		BinaryIndexTree test = new BinaryIndexTree();
		test.constructBIT(array);
		assertTrue(test.getSum(0) == 1);
		assertTrue(test.BIT[1] == 3);
		assertTrue(test.BIT[3] == 10);
	}
	
	@Test
	public void testcase4() {
		int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		BinaryIndexTree test = new BinaryIndexTree();
		test.constructBIT(array);
		test.updateTo(2, 5);
		assertTrue(test.getSum(0) == 1);
		assertTrue(test.BIT[1] == 3);
		assertTrue(test.BIT[3] == 12);
	}
}
