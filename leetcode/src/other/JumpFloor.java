package other;
/**
 * 	问:一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 	求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 
 * 	第一想法就是使用递归来解题,递归的思想也比较简单
 * 	还有如果观察细心可以知道,其实每一次跳台阶的选择总数就是前两次的选择的和,也就是一个斐波拉契数列
 * 	如果是斐波拉契数列,解法就更简单了
 */
public class JumpFloor {
	private static int n;
	public int jumpFloor(int target) {
		n=0;
	    jumpFloors(target);
	    return n;
	}
	
	private  void jumpFloors(int target) {
		if(target == 0) {
			n++;
		} else if(target < 0) {
		
		} else {
			jumpFloors(target-1);
			jumpFloors(target-2);
		}
	}
}
