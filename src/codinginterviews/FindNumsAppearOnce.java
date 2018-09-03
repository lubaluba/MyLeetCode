package codinginterviews;
/**
 *	一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 *	num1,num2分别为长度为1的数组。传出参数将num1[0],num2[0]设置为返回结果
 *
 *	方法一:空间换时间
 *	方法二:根据位运算法则,我们知道,一个数字异或其本身就是0,也就是说用异或操作运算整个数组,最后
 *	得到的结果应该是只出现一次的那两个数的异或结果,因为只出现一次的数抵消掉了,所以只要将数组分成两块,每块包含一个
 *	出现一次的数字,最后做异或操作,最后结果就是那两个数
 *	该方法核心:将数组分为两组,每组包含一个目标数字
 */
public class FindNumsAppearOnce {
	//方法一:空间换时间,用一个数组保存数字出现的次数
	public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int[] arr = new int[max + 1 ];
		for (int i = 0; i < array.length; i++) {
			arr[array[i]] ++;
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				num1[0] = i;
				index = i;
				break;
			}
		}
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[i] == 1) {
				num2[0] = i;
				index = i;
				break;
			}
		}
	}
	
}