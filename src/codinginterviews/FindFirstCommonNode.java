package codinginterviews;
/**
 * 	输入两个链表，找出它们的第一个公共结点。
 * 
 * 	思路:算出两个链表长度,如果有长度差,就让长的先走长度差的距离
 * 	然后两个链表一起走,找到公共节点
 * 
 */
public class FindFirstCommonNode {
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode node1 = pHead1;
		ListNode node2 = pHead2;
		int len1 = getLength(node1);
		int len2 = getLength(node2);
		if (len1 > len2) {
			for(int i = 0; i < len1 - len2; i++) {
				pHead1 = pHead1.next;
			}
		} else {
			for(int i = 0; i < len2 - len1; i++) {
				pHead2 = pHead2.next;
			}
		}
		while (pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
    }
	
	public int getLength(ListNode head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
