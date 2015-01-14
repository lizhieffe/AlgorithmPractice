package Finished;

import static org.junit.Assert.*;

import org.junit.Test;


public class SegmentTree {
	int[] array;
	int[] segmentTree;
	int[] min;
	
	public void constructST(int[] array) {
		if (array == null || array.length == 0)
			return;
		this.array = array;
		int height = (int)Math.ceil(Math.log(array.length) / Math.log(2)) + 1;
		this.segmentTree = new int[(int)Math.pow(2, height) - 1];
		this.min = new int[(int)Math.pow(2, height) - 1];
		constructST(0, array.length - 1, 0);
	}
	
	private int constructST(int sb, int se, int index) {
		if (sb == se) {
			segmentTree[index] = array[sb];
			min[index] = segmentTree[index];
			return array[sb];
		}
		int mid = getMid(sb, se);
		int val = constructST(sb, mid, 2 * index + 1) + constructST(mid + 1, se, 2 * index + 2);
		segmentTree[index] = val;
		min[index] = Math.min(min[2 * index + 1], min[2 * index + 2]);
		return val;
	}
	
	private int getMid(int beg, int end) {
		return beg + (end - beg) / 2;
	}
	
	public int getSum() {
		return getSum(0, array.length - 1);
	}
	
	public int getMin() {
		return getMin(0, array.length - 1);
	}
	
	public int getSum(int beg, int end) {
		return getSum(beg, end, 0, array.length - 1, 0);
		
	}
	
	public int getMin(int beg, int end) {
		return getMin(beg, end, 0, array.length - 1, 0);
	}
	
	private int getSum(int qb, int qe, int sb, int se, int index) {
		if (qb > qe || qb < 0 || qe >= array.length)
			return -1;
		if (qb <= sb && qe >= se)
			return segmentTree[index];
		if (qb > se || qe < sb)
			return 0;
		int mid = getMid(sb, se);
		return getSum(qb, qe, sb, mid, index * 2 + 1) + getSum(qb, qe, mid + 1, se, index * 2 + 2);
	}
	
	private int getMin(int qb, int qe, int sb, int se, int index) {
		if (qb > qe || qb < 0 || qe >= array.length)
			return -1;
		
		if (qb <= sb && qe >= se)
			return min[index];
		if (qb > se || qe < sb)
			return Integer.MAX_VALUE;
		int mid = getMid(sb, se);
		return Math.min(getMin(qb, qe, sb, mid, index * 2 + 1), getMin(qb, qe, mid + 1, se, index * 2 + 2));
	}
	
	public void updateTo(int index, int val) {
		if(index >= array.length || index < 0)
			return;
		int oldVal = getSum(index, index);
		update(index, val, val - oldVal, 0, array.length - 1, 0);
	}
	
	private void update(int qIndex, int val, int diff, int sb, int se, int index) {
		if (qIndex < sb || qIndex > se)
			return;
		segmentTree[index] += diff;
		min[index] = Math.min(min[index], val);
		if (sb != se) {
			int mid = getMid(sb, se);
			update(qIndex, val, diff, sb, mid, 2 * index + 1);
			update(qIndex, val, diff, mid + 1, se, 2 * index + 2);
		}
	}
	
	@Test
	public void test1() {
		int[] array = {1, 2, 3, 4, 5, 6};
		SegmentTree tc = new SegmentTree();
		tc.constructST(array);
		assertTrue(tc.segmentTree[0] == 21);
		assertTrue(tc.segmentTree[1] == 6);
		assertTrue(tc.segmentTree[2] == 15);
	}

	@Test
	public void test2() {
		int[] array = {1, 2, 3, 4, 5, 6};
		SegmentTree tc = new SegmentTree();
		tc.constructST(array);
		assertTrue(tc.getSum() == 21);
		assertTrue(tc.getSum(0, 2) == 6);
		assertTrue(tc.getSum(1, 4) == 14);
	}
	
	@Test
	public void test3() {
		int[] array = {1, 2, 3, 4, 5, 6};
		SegmentTree tc = new SegmentTree();
		tc.constructST(array);
		tc.updateTo(2, 5);
		assertTrue(tc.getSum() == 23);
		assertTrue(tc.getSum(0, 2) == 8);
		assertTrue(tc.getSum(1, 4) == 16);
	}
	
	@Test
	public void test4() {
		int[] array = {1, 2, 3, 4, 5, 6};
		SegmentTree tc = new SegmentTree();
		tc.constructST(array);
		assertTrue(tc.getMin() == 1);
		assertTrue(tc.getMin(0, 2) == 1);
		assertTrue(tc.getMin(1, 4) == 2);
	}
	
	@Test
	public void test5() {
		int[] array = {1, 2, 3, 4, 5, 6};
		SegmentTree tc = new SegmentTree();
		tc.constructST(array);
		tc.updateTo(2, -1);
		assertTrue(tc.getMin() == -1);
		assertTrue(tc.getMin(0, 2) == -1);
		assertTrue(tc.getMin(1, 4) == -1);
	}
}
