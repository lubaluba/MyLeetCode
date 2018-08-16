package other;
/**
 *	把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 *	例如6、8都是丑数，但14不是,因为它包含质因子7。 
 *	习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *	思路:质因子只含2,3,5,那就对该数从2开始整除,除到不能除为止,然后对3整除,再对5整除,看最后是否为1
 *	上面的思路可以用于完成解法一,但是时间复杂度较大
 *	所以需要解法二:因为发现所有的丑数都是2,3,5来的,那么丑数一定可以被另外某个丑数整除,这样的话
 *	我们用一个数组保存之前的丑数,其中每一位丑数可以决定后三位丑数,即x2,x3,x5
 */
public class GetUglyNumber {
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution2(1400));
	}
	//方法一:最基础的解法,从原理出发,但是时间复杂度过大。
	public static int GetUglyNumber_Solution(int index) {
		if(index < 1) {
			return 0;
		}
		if(index == 1) {
			return 1;
		}
		int count = 1;
		for(int i = 2; ; i++) {
			int num = i;
			while (num % 2 == 0) {
				num/= 2;
			}
			while (num % 3 == 0) {
				num/=3;
			}
			while(num % 5 == 0) {
				num /= 5;
			}
			if( num == 1){
				count++;
				if(count == index) {
					return i;
				}
			}
		} 
	}
	//解法二
	public static int GetUglyNumber_Solution2(int index) {
		if(index < 7) {
			return index;
		}
		int[] arr = new int[index];
		arr[0] = 1;
		int t2 = 0, t3 = 0, t5 = 0;
		for(int i = 1; i < index; i++) {
			arr[i] = Math.min(arr[t2]*2, Math.min(arr[t3]*3, arr[t5]*5));
			if(arr[i] == arr[t2]*2) {
				t2++;
			}
			if(arr[i] == arr[t3]*3) {
				t3++;
			}
			if(arr[i] == arr[t5]*5) {
				t5++;
			}
		}
		return arr[index-1];
	}
}
