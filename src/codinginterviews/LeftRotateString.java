package codinginterviews;
/**
 * 	汇编语言中有一种移位指令叫做循环左移(ROL),现在有个简单的任务,就是用字符串模拟这个指令的运算结果。
 * 	对于一个给定的字符序列S,请你把其循环左移K位后的序列输出。例如,字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果,
 * 	即“XYZdefabc”。是不是很简单?OK,搞定它！
 * 	
 */
public class LeftRotateString {
	//方法一:最简单的想法,就创建一个新的字符串,直接从原字符串中截取即可,但是显然这个题目的考点不是这样的
	public String leftRotateString(String str, int n) {
		if (str.length() == 0 || n > str.length() ) {
			return "";
		}
		StringBuilder strb = new StringBuilder();
		for (int i = n; i < str.length(); i++) {
			strb.append(str.charAt(i));
		}
		strb.append(str.substring(0, n));
		return strb.toString();
	}
	
	//方法二
	public String leftRotateString2(String str, int n) {
		  
		return str;
	}
}
