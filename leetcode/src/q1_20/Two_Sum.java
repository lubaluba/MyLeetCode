package q1_20;
import java.util.HashMap;
import java.util.Map;
/*
 * 该题首先想到暴力解法,逐个遍历,但这种方法显然不推荐,因为时间复杂度到了O(n^2)
 * 要降低时间复杂度,该题就可以采取空间换时间,可以根据hashMap的特点,就是key的查找是常数时间,
 * 所以就可以把数组元素放入hashMap,然后遍历一次即可
 */
public class Two_Sum {
	public static int[] twoSum (int nums[], int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<nums.length;i++) {
			if (map.containsKey(target-nums[i])) {
				result[0] = i;
				result[1] = map.get(target-nums[i]);
				return result;
			}
			map.put(nums[i],i);
		}
	return null;
	}
}