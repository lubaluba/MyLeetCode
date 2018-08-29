package leetcode;
/**
 * 	@author a3325
 *	题目：给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 */
public class addNum {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(8);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		ListNode l3 = addTwoNumbers(l1,l2);
		System.out.println(l3.val);
		System.out.println(l3.next.val);
		System.out.println(l3.next.next.val);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}
	 class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode (int x) { 
			 val = x; 
		 }
	 }
