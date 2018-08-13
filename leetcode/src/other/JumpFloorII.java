package other;
/**
 * 	一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 	求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *	
 *	类似于跳台阶
 */
public class JumpFloorII {
	
	public static void main(String[] args) {
		JumpFloorII j = new JumpFloorII();
		long s = System.currentTimeMillis();
		j.jumpFloorII(100);
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
	//方法一,还是用一个常量保存每一层的走法,时间复杂度太大
	public int jumpFloorII(int target) {
        if(target==0||target==1)
            return 1;
       if(target==2)
            return 2;
        int sum = 0;
        for(int i=0; i < target; i++){
            sum += jumpFloorII(i);
        }
        return sum;

    }
	//方法二三原理一样,主要是分析,这道题其实最后转换成函数关系其实就是f(n)=2*f(n-1),可以参照方法一来得出结论
	public int jumpFloorII2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII2(target - 1);
        }
	}
	
	public int jumpFloorII3(int target) {
		int a=1; 
        return a<<(target-1);
	}
}
