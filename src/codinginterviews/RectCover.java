package codinginterviews;
/**
 *	我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *	请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *	
 *	思路：由于大矩形是2*n,小矩形是2*1,所以可见,可以将大矩形拆成多个2*2的小矩形,那
 *	每一个小矩形只有两种排列方式。
 *	所以总的排列方式应该依旧是一个斐波拉契数列
 */
public class RectCover {
    public int fectCover(int target) {
    	int x = 0;
    	int y = 1;
    	int z = 0;
    	for (int i = 1; i <= target; i++) {
    		z = x+y;
    		y = x;
    		x = z;
    	}
    	return z;
    }

}
