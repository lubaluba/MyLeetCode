package huawei;

import java.util.Scanner;

/**
 *	 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 */
public class CountChar {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();
			int[] nums = new int[127];
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				nums[arr[i]] = 1;
			}
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if(nums[i] == 1) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
