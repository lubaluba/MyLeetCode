package codinginterviews;
/**
 * 	@author a3325 zlm
 *	题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *	例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *	
 *	思路: 通过新建一个StringBuilder来做替换,时间复杂度为O(n)但空间复杂度较大 运行时间：21ms占用内存：9560k

 */
public class ReplaceSpace {

	public  static String replaceSpace(StringBuffer str) {
		StringBuilder str1 = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			str1.append(c != ' ' ? c:"%20");
		}
		return str1.toString();
    }
}
