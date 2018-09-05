package codinginterviews;
/**
 *	题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *	例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *	
 *	方法一 : 通过新建一个StringBuilder来做替换,时间复杂度为O(n)但空间复杂度较大
 *	方法二 : 对字符串直接替换,这个时候需要考虑的是从前往后还是从后往前,如果从前往后的话,每一次替换前面的元素都需要移动
 *	所以使用从后往前移动替换比较好
 *	方法三 : 其实该题可能就是考察replaceAll方法的实现,虽然调用replaceAll可以一步实现
 */
public class ReplaceSpace {

	//方法一
	public  static String replaceSpace(StringBuffer str) {
		StringBuilder str1 = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			str1.append(c != ' ' ? c:"%20");	
		}
		return str1.toString();
	}
	
	//方法二
	public  static String replaceSpace1(StringBuffer str) {
		int spaceNum = 0; //先计算空格个数
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				spaceNum ++;
			}
		}
		int indexOld = str.length() - 1; //替换前字符串的位置
		int newLength = str.length() + 2*spaceNum; //计算替换后字符串长度,避免越界
		int newIndex = newLength - 1;
		str.setLength(newLength);
		for (; indexOld >= 0 && indexOld < newLength; --indexOld) {
			if (str.charAt(indexOld) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');
			} else {
				str.setCharAt(newIndex--, str.charAt(indexOld));
			}
		}
		return str.toString();
	}
	
	//方法二
	public  static String replaceSpace2(StringBuffer str) {
		return str.toString().replaceAll("", "%20");
	}
}
