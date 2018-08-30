package huawei;
/**
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 */
import java.util.Scanner;

public class HexToBinary {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(input.hasNext()) {
				hexToBinary(input.nextLine());
			}
		}
	}
	
	public static void hexToBinary(String hex) {
		hex = hex.toLowerCase();
		int num = 0;
		int h = 1;
		for (int i = hex.length() -1 ; i > 1; i--) {
			char ch = hex.charAt(i);
			if(ch >= '0' && ch <= '9') {
				num += h * (ch - '0');
			} else {
				num += h * (ch - 'a' + 10);
			}
			h *= 16;
		}
		System.out.println(num);
	}
}
