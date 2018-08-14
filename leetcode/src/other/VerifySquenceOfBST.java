package other;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 如[4,8,6,12,16,14,10]返回true;
 * 
 * 思路:对于后序遍历,末尾的元素,也就是根节点。那么以该元素为界
 * 	比该元素大的都在右树,比该元素小的都在左树。而这两段应该也都是后序遍历的结果。
 */
public class VerifySquenceOfBST {
	public boolean verifySquenceOfBST(int [] sequence) {
		if(sequence.length <= 0) {
			return false;
		}
		return judge(sequence, 0, sequence.length-1);
	}
	
	public boolean judge(int[] sequenece, int left, int right) {
		if(left >= right) {
			return true;
		}
		int i = right;
		while (i > left && sequenece[i-1] > sequenece[right]) {
			i--;
		}
		for (int j = i-1; j >= left; j-- ) {
			if (sequenece[j] > sequenece[right]) {
				return false;
			}
		}
		return judge(sequenece, left, i-1) && judge(sequenece, i, right-1);
	}
}
