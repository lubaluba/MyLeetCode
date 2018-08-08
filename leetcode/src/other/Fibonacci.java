package other;
/**
 * 	实现斐波拉契数列
 * 	
 * 	斐波拉契数列的实现很简单,但是不推荐递归,对于斐波拉契数列使用递归会考虑很多的重复情况.
 * 	可以使用一个数组保存每次加和后的前两个数,并每次更新,这样就每次去两数相加即可
 *	我这里直接用两个数保存了每次保存前面两个数
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
	}
    public static int fibonacci(int n) {
    	int x = 1;
    	int y = 1;
    	int z = 1;
    	for (int i = 2; i <= n; i++) {
    		z = x+y;
    		y = x;
    		x = z;
    	}
    	return z;
    }
}	
