package other;

import java.util.ArrayList;
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * 思路:主要就是设置四个边界,每次走到边界就换方向。
 * 	用run保存方向,0代表右走,1代表下走,2代表左走,3代表上走。
 * 	注意要控制好边界这样就不会走到重复的元素
 * 	同时用一个变量count保存走过的总次数,当count等于矩阵大小时,说明走完了。
 */
public class PrintMatrix {	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int cols = matrix[0].length;
		int rows = matrix.length;
		int i = 0, j = 0, count = 0;
		int run = 0;
		int up = 0, down = rows-1, left = 0, right = cols-1;
		while(count < cols*rows) {
			System.out.println(i+" "+j);
			list.add(matrix[i][j]);
			count++;
			if (run == 0) {
				if (j == right) {
					run = 1;
					i++;
					up++;
					continue;
				}
				j++;
			} else if (run == 1) {
				if (i == down) {
					right--;
					j--;
					run = 2;
					continue;
				}
				i++;
			} else if (run == 2) {
				if (j == left) {
					down--;
					i--;
					run = 3;
					continue;
				}
				j--;
			} else if (run == 3) {
				if (i == up) {
					left++;
					j++;
					run = 0;
					continue;
				}
				i--;
			}
		}
		return list;
    }
}
