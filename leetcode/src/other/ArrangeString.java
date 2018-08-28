package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 	输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 	例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 	
 * 	思路:采用递归方式,从一个数开始考虑,依次将后面的字符与前面的置换.从头到尾一个个固定字符,最后得到所有的解
 * 	需要注意的就是重复的字符排列方式,这个问题可以使用一个HashSet<String>来进行插入
 */
public class ArrangeString {
	private HashSet<String> set =new HashSet<>(); //用一个set保存所有情况,这样可以避免重复
	public ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		if (str != null && str.length() > 0) {
			permutation(str, 0);
			list.addAll(set);
			Collections.sort(list); //因为要求按字典顺序排列,最后要排列下list
		}
		return list;
    }
	
	private void permutation(String str, int start) {
		char[] arr = str.toCharArray();
		String r = null;
		if (start == str.length()-1) {
			r = String.valueOf(arr);
			set.add(r);
		} else {
			for (int i = start; i < str.length(); i++) {
				char temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
				permutation(String.valueOf(arr), start+1);
				//交换之后还要交换回去
				temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
			}
		}
	}
}
