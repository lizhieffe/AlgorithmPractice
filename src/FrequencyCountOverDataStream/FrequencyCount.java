package FrequencyCountOverDataStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequencyCount {
	
	private PriorityQueue<CountEntry> pq 
			= new PriorityQueue<CountEntry>();
	Map<String, CountEntry> map = new HashMap<String, CountEntry>();
	StringStreamQueue ssq;
	
	public FrequencyCount(StringStreamQueue ssq) {
		this.ssq = ssq;
	}
	
	synchronized private void increaseCount(String s, int n) {
		if (map.containsKey(s)) {
			CountEntry old = map.get(s);
			pq.remove(old);
			old.count += n;
			pq.add(old);
		}
		else {
			CountEntry e = new CountEntry(s, n);
			map.put(s, e);
			pq.add(e);
		}
	}
	
	synchronized private void increaseCount(Map<String, Integer> map) {
		if (map.size() == 0)
			return;
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> e = it.next();
			increaseCount(e.getKey(), e.getValue());
		}
	}
	
	private void updateCount() {
		increaseCount(ssq.summarize());
	}
	
	public List<CountEntry> getTopFrequency(int n) {
		List<CountEntry> result = new ArrayList<CountEntry>();
		if (n <= 0)
			return result;
		updateCount();			
		PriorityQueue<CountEntry> pqCopy = null;
		synchronized(this) {
			pqCopy = new PriorityQueue<CountEntry>(pq);
		}
		for (int i = 0; i < n && pqCopy.size() > 0; ++i) {
			CountEntry e = pqCopy.poll();
			result.add(e);
		}
		return result;
	}
}