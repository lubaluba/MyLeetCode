package other;
/**
 * 	一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 	求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *	
 *	类似于跳台阶
 */
public class JumpFloorII {
	public int jumpFloorII(int target) {
        if(target==0||target==1)
            return 1;
       if(target==2)
            return 2;
        int sum = 0;
        for(int i=0; i<target; i++){
            sum += jumpFloorII(i);
        }
        return sum;

    }
	public int jumpFloorII2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII2(target - 1);
        }
	}
}
