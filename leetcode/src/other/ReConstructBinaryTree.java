package other;
/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if(pre.length != in.length) {
    		return null;
    	} else {
    		return reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    	}
        
    }
    public TreeNode reConstructBinaryTree(int [] pre, int startpre, int endpre, int [] in, int startin, int endin) {
        if(startpre > endpre || startin > endin) {
        	return null;
        } else {
        	int rootVal = pre[startpre];
        	TreeNode root = new TreeNode(pre[startpre]);
        	int position = findRootPosition(rootVal, in, startin, endin);
        	if(position == -1) {
        		return null;
        	}
        	root.left = reConstructBinaryTree(pre, startpre+1, startpre+position-startin, in, startin, position-1);
        	root.right = reConstructBinaryTree(pre, startpre+position-startin+1, endpre, in, position+1, endin);
        	return root;
        }
    }
    
    //找到当前根元素在中序遍历数组中的位置
	private  int  findRootPosition(int target, int[] in, int startin, int endin) {
		for(int i = startin; i <= endin; i++) {
			if(in[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
/*Definition for binary tree*/
class TreeNode {  
	 int val;
	 TreeNode left;
	 TreeNode right;
     TreeNode(int x) { 
    	 val = x; 
     }
}
