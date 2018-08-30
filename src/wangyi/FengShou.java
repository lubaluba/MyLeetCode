package wangyi;

import java.util.Scanner;
/**
 * 	又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 	牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 *	在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 	牛牛觉得这个问题太简单，所以希望你来替他回答。
 *  
 *	输入  
 * 	第一行一个数n(1 <= n <= 105)。
 * 	第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 	第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 	第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * 
 * 	方法一:利用空间换时间,将后面的询问过程的时间复杂度变为O(n)
 * 	方法二:二分法查找
 * 	
 */
public class FengShou {
	//二分查找
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int n = input.nextInt(); 
			int[] apple = new int[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				count += input.nextInt();
				apple[i] = count;
			}
			int m = input.nextInt();
			for (int i = 0; i < m; i++) {
				System.out.println(binarySearch(apple, 0, apple.length-1, input.nextInt()));
			}
		}
			
	}
	public static int binarySearch(int[] arr,int start, int end, int target) {
		if (start <= end) {
			int mid = (start + end)/2;
			if (target <= arr[mid]) {
				if(mid - 1 < start) {
					return mid+1;
				} else if (target > arr[mid-1]) {
					return mid +1;
				} else {
					return binarySearch(arr, start, mid - 1, target);
				}
				
			} else {
				return binarySearch(arr, mid + 1, end, target);
			}
		}
		return 0;
		
	}
	
	//空间换时间
	public static void method1() {
		try (Scanner input = new Scanner(System.in)) {
			int n = input.nextInt();
			int count = 0; //保存苹果总数,用于创建数组
			int[] apple = new int[n+1]; //用数组保存苹果
			for (int i = 1; i <= n; i++) {
				apple[i] = input.nextInt();
				count += apple[i];
			}
			
			int[] arr = new int[count+1];
			count = 0;	
			for (int i = 1; i <= n; i++) {
				for(int j = count+1; j <= apple[i]+count; j++ ) {
					arr[j] = i;
				}
				count += apple[i];
			}
			int m = input.nextInt();
			for (int i = 0; i < m; i++) {
				System.out.println(arr[input.nextInt()]);
			}
		}
	}
	//方法二:二分查找
}
