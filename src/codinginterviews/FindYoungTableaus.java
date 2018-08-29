package codinginterviews;
/**
 * 	@author a3325 zlm 
 * 	题目 : 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 	请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 	思路 : 暴力查找虽然没毛病,但肯定不是我们想要的答案。根据数组的特征可知(0,0)和(n,n)肯定是最大和最小的元素。
 * 	那么第一步判根据最大最小值判断
 * 	第二步,选取左下或者右上的位置作为初始,这里选择左下
 * 	分别和其上面以及其右边元素比较,比上面的小就上移,比右边大就右移。
 */
public class FindYoungTableaus {
	
	public boolean find2(int target, int [][] array) {	
		if(array.length == 0 || array[0].length==0 ) {
			return false;
		}
		if(target < array[0][0] || target>array[array.length-1][array[0].length-1] ) {
			return false;
		}
		int i = array.length-1, j = 0;
		while( i>=0 && j<array[0].length ) {
			if(target == array[i][j]) {
				return true;
			} else if (target > array[i][j]) {
				j++;
			} else {
				i--;
			}
		}
		return false;
	}
}
