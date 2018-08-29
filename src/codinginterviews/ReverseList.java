package codinginterviews;
/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 
 * 思路一:创建一个新的链表,每次遍历旧的链表采用头插法插入新链表
 */
public class ReverseList {
	
	//方法一
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = new ListNode(head.val);
		while (head.next != null) {
			head = head.next;
			ListNode pp = new ListNode(head.val);
			pp.next = p;
			p = pp;
		}
		return p;
	}
	
	//方法二
	public ListNode reverseList2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

}
