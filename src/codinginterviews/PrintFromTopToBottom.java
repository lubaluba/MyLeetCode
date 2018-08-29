package codinginterviews;

import java.util.ArrayList;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *   		8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9  11
   	上面这颗二叉树的打印结果应该是:8,6,10,5,7,9,11
   	
   	思路:从上到下,从左到右遍历二叉树,这里使用一个list来模拟队列,按照该顺序将节点子树保存至队列中
   			每次循环都从左至右将子树节点存入,并取出第一个子树,将其val放入list。
   		原理其实就是缓存每一个节点,适时取出,不管从上往下或者从下往上都可以实现
 */
public class PrintFromTopToBottom {
	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (queue.size() != 0) {
			TreeNode temp = queue.remove(0);
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
			list.add(temp.val);
		}
		return list;
	}
}
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/