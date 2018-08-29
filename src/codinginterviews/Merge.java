package codinginterviews;
/**
 * 	题目:输入两个单调递增的链表，输出两个链表合成后的链表，
 * 		当然我们需要合成后的链表满足单调不减规则。
 * 
 * 	思路:以一个链表为标准,将另一个往其中插入,比如将list2插入到list1中
 */
public class Merge {
    //为了避免重复不必要的操作,我们将头元素大的往头元素小的链表里面插入
    public ListNode merge(ListNode list1, ListNode list2) {
    	if (list1 == null) {
    		return list2;
    	}
    	if (list2 == null) {
    		return list1;
    	}
    	if (list1.val >= list2.val) {
    		return insertTo(list1, list2);
    	} else {
    		return insertTo(list2, list1);
    	}
    }
    //将list1插入到list2中
	private ListNode insertTo(ListNode list1, ListNode list2) {
		ListNode lp = list2;//用一个listNode来负责移动和插入
		while (list1 != null) {
			if (lp.next == null) {//如果此时被插入节点为null,那就一路往后插就行
				lp.next = new ListNode(list1.val);
			} else if (list1.val <= lp.next.val) {//每次插入之前和被插入链表的下一个元素比较,小的话就在该元素前插入,否则移动被插入表
				ListNode p = new ListNode(list1.val);
				p.next = lp.next;
				lp.next = p;
			} else {
				lp = lp.next;
				continue;
			}	
			list1 = list1.next;
		}
		return list2;
	}
	/**
	 *	方法二,递归,这种方式代码简便,但是比上一种方法要耗更多时间
	 */
	public ListNode Merge2(ListNode list1,ListNode list2) {
	       if(list1 == null){
	           return list2;
	       }
	       if(list2 == null){
	           return list1;
	       }
	       if(list1.val <= list2.val){
	           list1.next = Merge2(list1.next, list2);
	           return list1;
	       }else{
	           list2.next = Merge2(list1, list2.next);
	           return list2;
	       }       
	   }
}
