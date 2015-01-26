package FrequencyCountOverDataStream;

public class CountEntry implements Comparable<CountEntry> {
	String s;
	int count;
	CountEntry(String s, int count) {
		this.s = s;
		this.count = count;
	}
	public int compareTo(CountEntry e) {
		if (this.count == e.count)
			return 0;
		if (this.count < e.count)
			return 1;
		return -1;
	}
}

