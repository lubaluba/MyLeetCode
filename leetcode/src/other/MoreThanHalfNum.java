package other;

import java.util.TreeMap;

/**
 * 	数组中有一个数字出现的次数超过数组长度的一半,
 * 	请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *	由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 *---------------------------------------------------------------------------------------------
 *	思路:用一个map缓存所有的数以及出现的次数,最后查询
 *	上面这种方法比较容易想到,或者也可以对数组先进行排序,再遍历,那么时间复杂度应该就是排序算法的复杂度
 *	
 *	-------------------------------------------------------------------------------------------
 *	借这个题目顺便复习下快排,第二种方法就使用快排来实现
 *	--------------------------------------------------------------------------------------------
 *	这里有一种时间复杂度为O(n)的算法,
 *	第一次遍历数组,用一个num从0号数字开始,count保存次数,如果后面的数与num相同,count+1,否则count-1,
 *	当count==0的时候,将num替换为当前数,count=1,重复操作;
 *	通过第一次遍历,如果存在大于一半数组长度的数的话,num一定等于该数,但是如果不存在这样的数,num的值就不确定了
 *	所以第二次遍历就拿着num去检查其是否在数组出现次数大于数组长度一半。
 *	通过两次遍历可以得出结论,时间复杂度为O(n)
 */
public class MoreThanHalfNum {
	public static void main(String[] args) {
		MoreThanHalfNum m = new MoreThanHalfNum();
		int[] arr = {1,3,4,5,2,2,2,2,2};
		System.out.println(m.moreThanHalfNum(arr));
 	}
	//方法一:treeMap,时间复杂度不清楚,应该是O(n^2)
	public int MoreThanHalfNum_Solution(int [] array) {
		if(array.length == 1) {
			return array[0];
		}
		TreeMap<Integer, Integer> map = new TreeMap<>(); 
		for (int i = 0; i < array.length; i++) {
			if(! map.containsKey(array[i])) {
				map.put(array[i], 1);
			}else {
				if(map.get(array[i])+1 > array.length/2) {
					return array[i];
				}else {
					map.put(array[i], map.get(array[i])+1);
				}
			}
		}
		return 0;    
    }
	
	//方法二:快排+遍历。
	public int moreThanHalfNum(int [] array) {
		if(array.length == 0) {
			return 0;
		}
		if(array.length == 1) {
			return array[0];
		}
		quickSort(array, 0, array.length-1);
		int num = array[array.length/2 + 1];
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(num == array[i]) {
				count++;
			}
		}
		if (count > array.length/2) {
			return num;
		} else {
			return 0;
		}
	}
	public static void quickSort(int[] arr, int left, int right){
		if(left >= right) {
			return;
		}
		int temp = arr[left];
		int i = left;
		int j = right;
		while (i < j) {
			while (arr[j] >= temp && i < j) {
				j--;
			}
			while (arr[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, left, i);
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);	
	}
	private static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//方法三O(n)
	public int MoreThanHalfNum_Solution2(int [] array) {
		int count = 1;
		int num = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] == num) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				num = array[i];
			}
		}
		count = 0;
		for(int i = 0; i< array.length; i++) {
			if (array[i] == num) {
				count++;
			}
		}
		if (count > array.length/2) {
			return num;
		} else {
			return 0;
		}
	}
	
}
