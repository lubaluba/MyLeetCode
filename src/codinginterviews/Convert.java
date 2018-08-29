package codinginterviews;
/**
 *	输入一棵二叉搜索树,将该二叉搜索树转换成一个排序的双向链表。
 *	要求不能创建任何新的结点,只能调整树中结点指针的指向。
 *	
 *	思路:二叉树的中序遍历的顺序即链表的顺序,所以就可以根据中序遍历结果来调整链表
 *	因为题目调整节点,只能操作原树,不能构建新节点。
 *	这里需要用到一个树节点来保存上一个节点值,并每次都把当前节点与上一个节点连接起来
 */
public class Convert {
	
	TreeNode head = null;
    TreeNode realHead = null;
	public TreeNode convert(TreeNode pRootOfTree) {
		 convertNode(pRootOfTree);
	     return realHead;
	}
	
	private  void convertNode(TreeNode pRootOfTree) {
		if(pRootOfTree==null) {
			return;
		}
        convertNode(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        convertNode(pRootOfTree.right);
	}
}	
