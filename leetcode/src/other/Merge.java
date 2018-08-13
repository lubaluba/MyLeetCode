package other;
/**
 * 	题目:输入两个单调递增的链表，输出两个链表合成后的链表，
 * 		当然我们需要合成后的链表满足单调不减规则。
 * 
 * 	思路:以一个链表为标准,将另一个往其中插入,比如将list2插入到list1中
 */
public class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
    	if (list1 == null) {
    		return list2;
    	}
    	if (list2 == null) {
    		return list1;
    	}
    	
    	//先找出list2中比list1头部小的元素,全部头插入list1
    	while (list2 != null && list2.val < list1.val  ) {
    		ListNode p = new ListNode(list2.val);
			p.next = list1;
			list1 = p;
			list2 = list2.next;    		
    	}
    	ListNode head = list1;
    	while (list2 != null) {
    		if (list1.next == null) {
    			list1.next = new ListNode(list2.val);
    		} else if (list2.val > list1.next.val ) {
    			list1 = list1.next;
    			continue;
    		} else if (list2.val >= list1.val ) {
    			ListNode p  = new ListNode(list2.val);
    			p.next = list1.next;
    			list1.next = p;
    		}
    		list2 = list2.next;
    	}
    	return head;
    }
}
