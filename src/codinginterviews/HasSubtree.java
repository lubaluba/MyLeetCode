package codinginterviews;
/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * 思路：采用递归分别从用root节点,root左节点和root右节点分别与root2比较。
 */
public class HasSubtree {	
	public boolean hasSubtree(TreeNode root1,TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		return isSubTree(root1, root2) || isSubTree(root1.left, root2)||isSubTree(root1.right, root2);
    }
	
	private boolean isSubTree(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null || root1.val != root2.val) {
			return false;
		}
		return (isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right));	
	}
}

/*class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/