package huawei;

import java.util.Scanner;

/**
 * 	写出一个程序,接受一个由字母和数字组成的字符串,
 * 	和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class CalcCharNum {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)){
			String str = input.next();
			String c = input.next();
			char ch = c.trim().charAt(0);
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ch || Math.abs(str.charAt(i) - ch) == 32) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
