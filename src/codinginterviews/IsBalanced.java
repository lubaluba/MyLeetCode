package codinginterviews;
/**
 *	输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 *	思路:
 *	平衡二叉树的定义 : 某一节点的左子树和右子树的深度差距最大为1
 *	先创建一个寻找二叉树深度的方法,然后递归依次比较左子树和右子树。直到叶节点
 */
public class IsBalanced {
	
	public boolean IsBalancedSolution(TreeNode root) {
		if (root == null) {
			return true;
		}
		if(Math.abs(getDeep(root.left, 0) - getDeep(root.right, 0)) > 1) {
			return false;
		}
		IsBalancedSolution(root.right);
		IsBalancedSolution(root.left);
		return true;
	}	
	public int getDeep(TreeNode node, int count) {
		if (node == null) {
			return count;
		}
		return Math.max(getDeep(node.left, count + 1), getDeep(node.right, count + 1));
	}
}
