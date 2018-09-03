package codinginterviews;
/**
 *	统计一个数字在排序数组中出现的次数。
 *
 *	思路 : 二分查找
 */
public class GetNumberOfK {
	
	public int getNumberOfK(int [] array , int k) {
		int index = getIndex(array, 0, array.length - 1, k);
		if (index == -1) {
			return 0;
		}
		int count = 1;
		int i = index - 1;
		int j = index + 1;
		while(i >= 0 && array[i] == k) {
			count++;
			i--;
		}
		while( j < array.length && array[j] == k) {
			count++;
			j++;
		}
		return count;
	}

	private int getIndex(int[] array, int start, int end, int k) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		} else {
			if (array[mid] == k) {
				return mid;
			} else if (array[mid] > k) {
				return getIndex(array, start, mid - 1, k);
			} else {
				return getIndex(array, mid + 1, end, k);
			}
		}
	}
}	
