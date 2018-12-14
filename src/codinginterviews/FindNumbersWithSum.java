package codinginterviews;

import java.util.ArrayList;

/**
 * 	输入一个递增排序的数组和一个数字S,在数组中查找两个数,
 * 	使得他们的和正好是S,如果有多对数字的和等于S,输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
	//方法一:暴力解决,控制边界情况,第二轮查找可以用二分查找
	public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int count = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < array.length && array[i] <= sum/2; i++) {
			int target = sum - array[i];
			for (int j = i + 1; j < array.length && array[j] <= target; j++) {
				if(array[j] == target) {
					int countTemp = array[i] * array[j];
					if (countTemp < count) {
						count = countTemp;
						index1 = i;
						index2 = j;
					}
				}
			}
		}
		if(index1 != -1 && index2 != -1) {
			list.add(array[index1]);
			list.add(array[index2]);
		}
		return list;
	}
	//方法二:因为是排序数组,就可以用左右逼近的方法
	public ArrayList<Integer> findNumbersWithSum2(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int j = array.length - 1;
		while(i < j) {
			if (array[i] + array[j] == sum) {
				list.add(array[i]);
				list.add(array[j]);
				return list;
			} else if (array[i] + array[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return list;
	}
	
}
 