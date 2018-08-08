package other;
/**
 *	把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 *	 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 *
 *	思路:题目的意思是将一个不递减排序数组经过了旋转,让我们在旋转之后的数组中找到最小元素。
 *	根据旋转的思想,我们可以采用类似于二分查找的方式
 *	首先我们使用两个指针分别指向头尾,然后找到其中间元素，用中间元素和头比较,如果中间元素大于头,说明在右边,否则在左边
 */
public class MinNumberInRotateArray {
	public static void main(String[] args) {
	}
	public  int minNumberInRotateArray(int [] array) {
		if(array == null || array.length == 0){
			return 0;
		}
		int p1 = 0;
		int p2 = array.length-1;
		int min = array[p1];
		int mid = 0;
		while(array[p1] >= array[p2]){
			if(p2 - p1 == 1){
				min = array[p2];
				break;
			}
			mid = (p1 + p2)/2; 
		   //如果中间位置的数既等于p1位置的数又等于P2位置的数,就只能遍历查找了
		   if(array[p1] == array[mid]&&array[p2] == array[mid]){
			  min = minInorder(array,p1,p2);
		   }
		   if (array[p1] <= array[mid]){
			 p1 = mid;
		   } else if (array[p2] >= array[mid]){
			 p2 = mid;
		   }
		}
		return min;
	}
	private  static int minInorder(int[]array,int p1,int p2){
		int min = array[p1];
		for (int i = p1 + 1; i <= p2; i++){
			if (min > array[i]){
				min = array[i];
			}
		}
		return min;
	}
}