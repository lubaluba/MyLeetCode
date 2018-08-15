package other;

import java.util.LinkedList;
import java.util.Queue;

/** 
 *	输入一棵二叉树，求该树的深度。
 *	从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *	
 *	思路:这题使用递归较为简单
 */
public class TreeDepth {
	/**
	 * 递归法
	 */
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else {
			int left = treeDepth(root.left);
			int right = treeDepth(root.right);
			return left > right ? left + 1 : right + 1;
		}
    }
	/**
	 * 非递归法:即层次遍历
	 */
	public int treeDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 0;
		int count = 0;
		int nextCount = 1;
		while (queue.size() != 0) {
			TreeNode top = queue.poll();
			count++;
			if (top.left != null) {
				queue.add(top.left);
			}
			if (top.right != null) {
				queue.add(top.right);
			}
			if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
		}
		return depth;
	}
}
