package codinginterviews;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 
 * 思路:该题是要找出从根节点一直到某一个叶节点的,该路径上各个结点值的和为target的路径
 * 	那么就用一个list保存从跟节点到叶节点的路径,并用一个sum保存和,进行递归达到叶节点
 * 	如果最后叶节点时sum == target,就将这个路径的list放入大的list中
 */
public class FindPath {
	/**
	 * 方法一  : 参数过多,可以简化一下
	 */
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> path = new ArrayList<>();
		if(root != null) {
			get(root, target, new ArrayList<Integer>(), 0, path);
		}
		return path;
    }
	public void get(TreeNode root, int target, ArrayList<Integer> list, int sum, ArrayList<ArrayList<Integer>> path) {
		sum += root.val;
		list.add(root.val);
		if (root.left == null && root.right == null) {
			if(sum == target) {
				path.add(list);
			}
		} else {
			if (root.left != null) {
				ArrayList<Integer> listLeft = new ArrayList<>(list);
				get(root.left, target, listLeft, sum, path); 
			}
			if (root.right != null) {
				ArrayList<Integer> listRight = new ArrayList<>(list);
				get(root.right, target, listRight, sum, path); 
			}
		}
	}
	/**
	 * 方法二：和方法一思路一样,但是简化了代码,但是时间和空间上的复杂度其实是一样的。
	 */
	private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
		if (root == null) {
			return listAll;
		}
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null) {
			listAll.add(new ArrayList<Integer>(list));
		}
		findPath2(root.left, target);
		findPath2(root.right, target);
		//因为同时存在左右节点时,会导致遍历右节点时子节点也在list中,所以要移除。
		list.remove(list.size() - 1);
		return listAll;
	}
}
