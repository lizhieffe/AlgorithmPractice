package FrequencyCountOverDataStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class StringStreamQueue {
	
	/*
	 * only the strings appear with frequency > 1/THRESHOLD will be count
	 */
	private static int THRESHOLD = 5;
	
	private ConcurrentLinkedQueue<String> queue 
			=new ConcurrentLinkedQueue<String>();
	
	public void add(final String s) {
		queue.add(s);
	}
	
	public String poll() {
		return queue.poll();
	}
	
	public void setThreshold(int val) {
		if (val <= 1)
			return;
		else
			THRESHOLD = val;
	}
	
	/*
	 * 1. summarize the current queue based on the THRESHOLD
	 * 2. clear the queue
	 */
	synchronized public Map<String, Integer> summarize() {
		Queue<String> queueCopy = new LinkedList<String>(queue);
		Queue<String> queueCopy2 = new LinkedList<String>(queueCopy);
		queue.clear();
		int num = queueCopy.size();
		Map<String, Integer> frequentString = new HashMap<String, Integer>();
		if (queueCopy.size() == 0)
			return frequentString;
		while (queueCopy.size() > 0) {
			String s = queueCopy.poll();
			if (frequentString.containsKey(s))
				frequentString.put(s, frequentString.get(s) + 1);
			else {
				if (frequentString.size() == THRESHOLD - 1) {
					Iterator<java.util.Map.Entry<String, Integer>> it 
							= frequentString.entrySet().iterator();
					while (it.hasNext()) {
						java.util.Map.Entry<String, Integer> e
								= it.next();
						if (e.getValue() == 1)
							it.remove();
						else
							e.setValue(e.getValue() - 1);
					}
				}
				else
					frequentString.put(s, 1);
			}
		}
		if (frequentString.size() == 0)
			return frequentString;
		Iterator<java.util.Map.Entry<String, Integer>> it 
				= frequentString.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry<String, Integer> e = it.next();
			e.setValue(0);
		}
		while (queueCopy2.size() > 0) {
			String s = queueCopy2.poll();
			if (frequentString.containsKey(s))
				frequentString.put(s, frequentString.get(s) + 1);
		}
		it = frequentString.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> e = it.next();
			if (e.getValue() < Math.ceil((double)num / (double)THRESHOLD))
				it.remove();
		}
		
		return frequentString;
	}
}
