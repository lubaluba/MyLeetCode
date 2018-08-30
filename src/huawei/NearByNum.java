package huawei;

import java.util.Scanner;

/**
 *	写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class NearByNum {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			float f = input.nextFloat();
			float ff = f - (int)f;
			if(ff - 0.5 >= 0.0000000) {
				System.out.println((int)f + 1);
			} else {
				System.out.println((int)f);
			}
		}
	}
}
