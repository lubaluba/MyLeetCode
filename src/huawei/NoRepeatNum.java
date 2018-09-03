package huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 	输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class NoRepeatNum {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int x = sc.nextInt();
			String s = x + "";
			char[] arr = s.toCharArray();
			HashSet<Integer> set = new HashSet<>();
			StringBuilder str = new StringBuilder();
			for (int i = arr.length - 1; i >= 0; i--) {
				if (! set.contains(arr[i] - '0')) {
					set.add(arr[i] - '0');
					str.append(arr[i] - '0');
				}
			}
			System.out.println(Integer.parseInt(str.toString()));
		}
	}
}
