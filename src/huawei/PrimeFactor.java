package huawei;

import java.util.Scanner;

/**
 *	功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子
 *	(如180的质数因子为2,2,3,3,5 )最后一个数后面也要有空格
 */
public class PrimeFactor {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			long x = input.nextLong();
			int i = 2;
			while (! isPrime(x)) {
				if(isPrime(i)) {
					while(x % i == 0) {
						System.out.print(i+" ");
						x/=i;
					}
				}
				i++;
			}
			System.out.println(x+" ");
		}
	}
	
	public static boolean isPrime(long num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num %i == 0) {
				return false;
			}
		}
		return true;
	}
}
