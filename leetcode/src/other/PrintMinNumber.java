package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 	
 * 	思路 : 将数组中的元素全部放入一个list中
 * 	然后对list进行排序,注意个排序是自定义的排序,最后将排序好的字符串拼接即可	
 */
public class PrintMinNumber {
	
	public String printMinNumber(int [] numbers) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		//自定义比较器
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = o1 + "" + o2;
				String s2 = o2 + "" + o1;
				return s1.compareTo(s2);
			}
		});
		StringBuilder str = new StringBuilder();
		for(int num : list) {
			str.append(num);
		}
		return str.toString();
	}
}
