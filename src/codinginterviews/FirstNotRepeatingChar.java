package codinginterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符。
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * 	方法一 : 用map的性质,遍历字符数组,每次判断字符是否在map中。
 * 	因为hashMap的containsKey是O(1)时间复杂度的
 * 	map的Key就是该字符,value就是字符的位置,如果出现多次就把value置于-1即可
 * 	最后遍历map找出最小的value值即可,没用的话说明不存在返回-1
 * 
 * 	方法二: 桶排序,用两个桶保存,一个保存index,一个保存出现次数
 */
public class FirstNotRepeatingChar {
	
	public int firstNotRepeatingChar(String str) {
		if (str == null || str.length() == 0 ) {
			return -1;
		}
		Map<Character, Integer> map = new HashMap<>();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				map.put(arr[i], 10001);
			}
		}
		int index =  10001;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() < index) {
				index = entry.getValue();
			}
		}
		return index == 10001 ? -1 : index;
	}
	
	//方法二,桶排序,假设只存在大小写字母
	public int firstNotRepeatingChar2(String str) {
		if (str == null || str.length() == 0 ) {
			return -1;
		}
		int [] arr = new int[200];
		int [] arr2 = new int[200];
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			arr[chars[i]] ++;
			arr2[chars[i]] = i;
		}
		int index = 10001;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 1 && arr2[i] < index) {
				index = arr2[i];
			}
		}
		return index == 10001 ? -1 : index;	
	}
}
