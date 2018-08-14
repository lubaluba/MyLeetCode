package other;
/*
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 这里可以用到一个巧妙的办法,对n进行位运算,为什么选择n-1呢
 * 因为n-1可以将整数最右边的1变为0,同时之后的0都变成1
 * 此时再做位运算每次都能减少一位1,同时将其置为0,最后等所有的位数都为0,即=0时,结束
 */
public class NumberOf1 {
	public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
        	count ++;
        	n = n & (n-1);
        }
        return count;
    }
}
