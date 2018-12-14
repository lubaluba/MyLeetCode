package codinginterviews;

import java.util.ArrayList;
/**
 * 	小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 	但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 	没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 	现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 
 * 	思路一：最简单的想法,暴力遍历,但是其实连续的数最大也就是sum/2-1,每次遍历时去计算即可,但是时间复杂度较高
 * 	思路二： 	
 */
public class FindContinuousSequence {

	public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {     
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 1; i <= sum/2; i++) {
			int target = sum;
			int j = i;
			ArrayList<Integer> arr = new ArrayList<>();
			while(target > 0) {
				arr.add(j);
				target -= j++;
			}
			if (target == 0) {
				list.add(arr);
			}
		}
		return list;
	}
	
	//方法二
	public ArrayList<ArrayList<Integer> > findContinuousSequence2(int sum) {     
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
			if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
					list.add(k);
				}
				ans.add(list);
			}
		}
        return ans;
    }
}

