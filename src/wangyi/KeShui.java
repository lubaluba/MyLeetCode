package wangyi;

import java.util.Scanner;

/**
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
 * 你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，
 * 你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。 
 */
public class KeShui {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] value = new int[n];
			int[] status = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				value[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				status[i] = sc.nextInt();
				if(status[i] == 1) {
					sum += value[i];
				}
			}
			
			int max = 0;
			int temp = 0;
			for (int i = 0; i < n - k + 1; i++) { //注意i < n-k+1比较关键,减少时间复杂度
					temp = 0;
					for (int j = 0; j < k ; j++) {
						if(status[i + j] == 0) {
							temp += value[i + j];
						}
					}
					max = Math.max(temp, max);
			}
			System.out.println(sum + max);
		}
	}
}
