package meituan;

import java.util.Scanner;
/**
 * 	大富翁游戏,玩家根据骰子的点数决定走的步数,即骰子点数为1时可以走一步,点数为2时可以走两步,点数为n时可以走n步。
 * 	求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时,总共有多少种投骰子的方法。 
 */
public class DaFuWeng {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] arr = new int[n + 1];
			arr[1] = 1;
			for (int i = 2; i <= n; i++) {
				for(int j = 1; j < i; j++) {
					arr[i] += arr[j];
				}
				arr[i] += 1;
			}
			System.out.println(arr[n]);
		}
	}
}
