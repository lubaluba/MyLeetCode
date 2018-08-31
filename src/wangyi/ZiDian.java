package wangyi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 	小易在学校中学习了关于字符串的理论, 于是他基于此完成了一个字典的项目。
 * 	小易的这个字典很奇特, 字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列。
 * 	小易现在希望你能帮他找出第k个单词是什么。 
 * 	
 * 	思路：其实就是一个黑白球的组合问题,总组合数是C(m,n),所有先用一个函数来求组合数
 * 	采用从第一个字符逐步往后追加的方式,首先
 * 	第一个字符只有两种选择方式,a或者z,至于具体选择哪种,其实看后面,如果第一个选a,那么后面的组合数就是C(m-1,n)
 * 	那么只要k<=C(m-1,n)说明第一个字符必然是a,否则就是z
 * 	按照这样的方式一次推下去就可以,只要m和n有一方先为0,那说明剩下的全是'a'或'z'。
 * 	注意k>=C(m-1,n)的情况,这种情况递归之前要先减去C(m-1,n)只保留超过的部分。
 */
public class ZiDian {
	static StringBuilder str = new StringBuilder();
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			if(new BigInteger(k+"").compareTo(count(m,n)) > 0) {
				System.out.println(-1);
			}else {
				hh(n,m,k);
				System.out.println(str.toString());
			}
		}
	}
	
	public static void hh(int m, int n, int k) {
		if(m == 0) {
			for(int i = 0; i < n; i++) {
				str.append("z");
			}
			return;
		} 
		if(n ==0) {
			for(int i = 0; i < m; i++) {
				str.append("a");
			}
			return;
		}
		BigInteger count = count(m-1,n);
		if(count.compareTo(new BigInteger(k+""))>=0) {
			str.append("a");
			hh(m-1,n,k);
		} else {
			str.append("z");
			k -= count(m-1,n).intValue();
			hh(m,n-1,k);
		}
	}
	//计算C(m,m+n)
	private static BigInteger count(int m,int n) {
		int min = Math.min(m, n);
		BigInteger count = new BigInteger("1");
		for(int i = m+n-min+1; i <= m+n; i++) {
			count = count.multiply(new BigInteger(i+""));
		}
		for(int i = 1; i <= min; i++) {
			count = count.divide(new BigInteger(i+""));
		}
		return count;
	}
	
}
