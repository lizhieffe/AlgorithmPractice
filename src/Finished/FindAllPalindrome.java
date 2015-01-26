package Finished;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FindAllPalindrome {
	public List<String>	findAllPalindrome(char[] c) {
		List<String> result = new ArrayList<String>();
		if (c == null || c.length == 0)
			return result;
		String solution = "";
		Arrays.sort(c);
		List<Character> list = new ArrayList<Character>();
		for (char cha : c)
			list.add(cha);
		findAll(result, solution, list);
		return result;
	}
	
	private void findAll(List<String> result, String solution, List<Character> list) {
		if (list.size() == 0) {
			result.add(solution);
			return;
		}
		Character last = (char)(list.get(0) + 1);
		for (int i = 0; i < list.size(); ++i) {
			Character c = list.get(i);
			if (!c.equals(last)) {
				StringBuilder b = new StringBuilder(solution);
				List<Character> newList = new ArrayList<Character>(list);
				b.append(newList.get(i));
				last = newList.remove(i);
				findAll(result, b.toString(), newList);
			}
		}
	}
	
	@Test
	public void tc01() {
		char[] c = {'1','2','3'};
		FindAllPalindrome service = new FindAllPalindrome();
		List<String> result = service.findAllPalindrome(c);
		assertTrue(result.size() == 6);
	}
	
	@Test
	public void tc02() {
		char[] c = {'1','1','3'};
		FindAllPalindrome service = new FindAllPalindrome();
		List<String> result = service.findAllPalindrome(c);
		assertTrue(result.size() == 3);
	}
	
	
	@Test
	public void tc03() {
		char[] c = {'1','2','3','4','5'};
		FindAllPalindrome service = new FindAllPalindrome();
		List<String> result = service.findAllPalindrome(c);
		assertTrue(result.size() != 3);
	}
}
