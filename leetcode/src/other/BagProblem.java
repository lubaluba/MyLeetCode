package other;

/**
 * 	背包问题具体例子:假设现有容量10kg的背包,另外有3个物品,分别为a1,a2,a3。
 * 	物品a1重量为3kg,价值为4;物品a2重量为4kg,价值为5;物品a3重量为5kg,价值为6。
 * 	将哪些物品放入背包可使得背包中的总价值最大?
 */
public class BagProblem {
	public static void main(String[] args) {
		BagProblem bp = new BagProblem();
		int[] w = {3,4,5};
		int[] v = {4,5,6};
		bp.solution(10, 3, w, v);
	}
	
	/**
	 * 
	 * @param b 背包大小
	 * @param gn 商品个数
	 * @param w 商品重量数组(假设已经排序)  
	 * @param v 商品价值数组(已排序)
	 */
	public void solution(int bs, int gn, int[] w, int [] v) {
		int result[][] = new int[gn+1][bs+1];
		for (int i = 0; i < gn+1 ; i++)
            result[i][0] = 0;
        for (int j = 0; j < bs+1 ; j++)
            result[0][j] = 0;
		
		for (int i =1; i < gn+1; i++) {
			for (int j = 0; j < bs+1; j++) {
				if (w[i-1] <= j) {
					if (result[i-1][j] < result[i-1][j - w[i-1]] + v[i-1]) {
						result[i][j] = result[i-1][j - w[i-1]] + v[i-1];
					} else {
						result[i][j] = result[i-1][j];
					}
				} else {
					result[i][j] = result[i-1][j];
				}
			}
		}
		
		for(int i =0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
		

}
