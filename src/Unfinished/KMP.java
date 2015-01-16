package Unfinished;

public class KMP {
	public boolean canFindString(String ts, String ps) {
		if (ts == null || ps == null || ts.length() < ps.length())
			return false;
		int[] partialMatchTable = new int[ps.length()];
		return canFind(ts, 0, ps, 0, partialMatchTable);
	}
	
	private boolean canFind(String ts, int tb
			, String ps, int pb, int[] partialMatchTable) {
		if (ts.length() - tb < ps.length() - pb)
			return false;
		for (int i = 0; i < ps.length() - pb; i++) {
			if (ts.charAt(tb + i) != ps.charAt(pb + i)) {
				if (pb == 0 && i == 0)
					return canFind(ts, tb + 1, ps, 0, partialMatchTable);
				else
					return canFind(ts, tb, ps, partialMatchTable[pb + i - 1], partialMatchTable);
			}
			else {
				if (ps.charAt(pb + i) == ps.charAt(partialMatchTable[pb + i - 1]))
					partialMatchTable[pb + i] = partialMatchTable[pb + i - 1] + 1;
				else
					partialMatchTable[pb + i] = 0;
			}
		}
		return true;
	}
}
