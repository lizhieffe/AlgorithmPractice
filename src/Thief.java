/*
 * Given an array of houses with properties of different value, generate the max value a thief can stole.
 * Note: if the thief stole the house at i, he cannot stole the neighboring houses (i - 1, i + 1)
 */
public class Thief {

	int length;
	int[] values;
	int[] dp;
	
	public int maxStole(int[] values) {
		length = values.length;
		
		if (length == 0)
			return 0;
		if (length == 1)
			return values[0];
		
		this.values = values;
		dp = new int[length];
		for (int i = 0; i < length; i ++)
			dp[i] = -1;
		
		return Math.max(max(0), max(1));
	}
	
	private int max(int start) {
		if (start >= length)
			return 0;
		
		if (start - length >= -2)
			return values[start];
		
		if (dp[start] != -1)
			return dp[start];
		
		int result = values[start] + Math.max(max(start + 2), max(start + 3));
		dp[start] = result;
		return result;
	}
	
	public static void main(String[] args) {
		int[] values = {1, 3, 1, 1};
		Thief service = new Thief();
		int result = service.maxStole(values);
		System.out.println(result);
	}
}
