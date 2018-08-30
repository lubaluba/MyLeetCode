package huawei;

import java.util.Scanner;

/**
 *	计算字符串最后一个单词的长度，单词以空格隔开。
 *
 *	思路 :很简单,就是直接调用String方法获得最后一个' '(空格)的位置,如果不能使用这个的话
 *	遍历一遍字符串也能得到
 */
public class CalcLastLetter {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		System.out.println(str.length() - 1 - str.lastIndexOf(" "));
		input.close();
	}
}
