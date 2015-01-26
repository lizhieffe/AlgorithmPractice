package Finished;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class FindSumWindow {

	/*
	 * 给一个int array，有正有负， 给一个target number
	 * ，找出这个array里有没有连续的几个数之和等于target number 要用O(n) time
	 */
	
	public static boolean find(int[] ar, int target) {
		if (ar == null || ar.length == 0)
			return false;
		Map<Integer, List<Integer>> sumFromHead = new HashMap<Integer, List<Integer>>();
		int sum = 0;
		for (int i = 0; i < ar.length; ++i) {
			int val = ar[i];
			sum += val;
			if (sumFromHead.containsKey(sum)) {
				if (target == 0)
					return true;
				sumFromHead.get(sum).add(i);
			}
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				sumFromHead.put(sum, list);
			}
		}
		Iterator<Entry<Integer, List<Integer>>> it 
				= sumFromHead.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, List<Integer>> entry = it.next();
			int val = entry.getKey();
			List<Integer> pos = entry.getValue();
			if (sumFromHead.containsKey(val + target)) {
				List<Integer> targetPos = sumFromHead.get(val + target);
				if (pos.get(0) < targetPos.get(targetPos.size() - 1))
					return true;
			}
		}
		return false;
	}
	
	@Test
	public void tc01() {
		int[] ar = {1,2,3,4,5,6};
		int target = 9;
		assertTrue(find(ar, target) == true);
		assertTrue(find(ar, 0) == false);

	}
}
