package Finished;

/**
 * In the input array, there are n - 2 integers come with pairs, 2 integers do not.
 * Find the 2 integers
 * 
 * @author zhili
 *
 */
public class FindTwoDifferentInteger {
	int[] findTwoDifferentInteger(int[] array) {
		if (array == null || array.length < 2 || array.length % 2 == 1)
			return null;
		
		int tmp = 0;
		for (int i = 0; i < array.length; i ++)
			tmp = tmp ^ array[i];
		
		int benchmark = -1;
		for (int i = 0; i < 32; i ++) {
			if (tmp % 2  == 1) {
				benchmark = i;
				break;
			}
			tmp = tmp << 1;
		}
		
		if (benchmark == -1)
			return null;
		
		int tmp1 = 0;
		int tmp2 = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] << benchmark) % 2 == 0)
				tmp1 = tmp1 ^ array[i];
			else
				tmp2 = tmp2 ^ array[i];
		}
		
		int[] result = new int[2];
		result[0] = tmp1;
		result[1] = tmp2;
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 1, 3, 2, 4};
		FindTwoDifferentInteger service = new FindTwoDifferentInteger();
		int[] result = service.findTwoDifferentInteger(array);
		System.out.println(result);
	}
}
