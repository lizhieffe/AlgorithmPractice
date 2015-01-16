package Finished;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class GetMinDistanceBetweenTwoWords {
	
	/*
	 * 	有一个array ["this", "is", "a", "is", "fox", "happy"]
		需要返回两个单词的最近距离（用index计算）。
		int dist(string word1, string word2)
		比如dist("fox", "happy") = 1
		dist("is", "fox") = 1 注意“is”是有重复的。
		每个单词都是有可能重复的。
	 */
	
	private String[] s;
	private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
	
	public GetMinDistanceBetweenTwoWords() {
		
	}
	
//	public GetMinDistanceBetweenTwoWords(String[] s) {
//		this.s = s;
//		preprocess();
//	}
	public void setString(String[] s) {
		this.s = s;
		preprocess();
	}
	
	private void preprocess() {
		for (int i = 0; i < s.length; i++) {
			if (!map.containsKey(s[i]))
				map.put(s[i], new ArrayList<Integer>());
			map.get(s[i]).add(i);
		}
		Iterator<Entry<String, List<Integer>>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			List<Integer> list = it.next().getValue();
			Collections.sort(list);
		}
	}
	
	public int getMinDistance(String s1, String s2) {
		List<Integer> l1 = this.map.get(s1);
		List<Integer> l2 = this.map.get(s2);
		if (l1 == null || l2 == null)
			return -1;
		int[] a1 = new int[l1.size()];
		for (int i = 0; i < a1.length; i++)
			a1[i] = l1.get(i);
		int[] a2 = new int[l2.size()];
		for (int i = 0; i < a2.length; i++)
			a2[i] = l2.get(i);
		return FindMinDistanceBetweenTwoArray.getMin(a1, a2);
	}
	
	@Test
	public void tc01() {
		String[] s = {"a","d","d","b","d","a"};
		GetMinDistanceBetweenTwoWords service = new GetMinDistanceBetweenTwoWords();
		service.setString(s);
		assertTrue(service.getMinDistance("a", "b") == 2);
	}
}
