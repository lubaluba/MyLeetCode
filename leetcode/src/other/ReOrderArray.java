package other;
/**
 *	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *	所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *	
 *	思路：偶动奇不动,而且从后往前读。注意一个小陷阱,就是交换时的下标
 */
public class ReOrderArray {
	
	public static void main(String[] args) {
		ReOrderArray a = new ReOrderArray();
		int[] arr = {1,2,3,4,5,6,7};
		a.reOrderArray(arr);
		for(int i = 0  ; i<arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void reOrderArray(int [] array) {
        for (int i = array.length-2; i >= 0; i--) {
        	if (array[i] % 2 == 0) {
        		int x = i;
        		for(int j = i+1; j<array.length; j++) {
        			if (array[j] % 2 == 0 ) {
        				break;
        			} else {
        				int temp = array[x];
        				array[x] = array[j];
        				array[j] = temp;
        				x = j;
        			}
        		}
        	}
        }
    }
}
