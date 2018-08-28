package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *	输入n个整数,找出其中最小的K个数。
 *	例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *	
 *	方法一: 选择排序/冒泡,该方法时间复杂度是O(n*k)
 *	方法二: 快排/归并排序,时间复杂度O(nlogn)
 *	方法三: 用最大堆保存这k个数,每次只和堆顶比,如果比堆顶小,删除堆顶,新数入堆。(当数据无法全部装入内存时可使用)
 */
public class GetLeastNumbers {
	
	//方法一
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if (input.length !=0 && input.length >= k && k > 0) {
			sort(input, k);
			for(int i = 0; i < k; i++) {
				list.add(input[i]);
			}
		}
		return list;
    }
	private void sort(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//方法二
	public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if(input.length !=0 && input.length >= k) {
			
			//java优先队列是基于堆实现的
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
			
			for (int i = 0; i < input.length; i++) {
				if (maxHeap.size() != k) {
					maxHeap.offer(input[i]);
				} else if (maxHeap.peek() > input[i]) {
					@SuppressWarnings("unused")
					Integer temp = maxHeap.poll();
					temp = null;
					maxHeap.offer(input[i]);
				}
			}
			
			for (Integer integer : maxHeap) {
				result.add(integer);
			}
		}
		return result;
	}	
}
