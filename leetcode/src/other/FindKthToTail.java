package other;

import java.util.HashMap;
import java.util.Map;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 方法一: 时间换空间,缓存每一个节点至map,最后直接从map中拿出来,时间复杂度为O(n),但是会消耗额外空间
 * 方法二: 使用两个指针,先让第一个指针和第二个指针都指向头结点,先让第一个指针走k-1步达到k节点,然后两个指针同时移动,当
 * 第一个指针到达尾部时,第二个指针就是倒数k个节点了,时间复杂度仍然为O(n)
 **/
public class FindKthToTail {
	//方法一
	public ListNode findKthToTail(ListNode head,int k) {
		Map<Integer, ListNode> map = new HashMap<>();
		int len = 0;
		while (head != null) {
			map.put(len, head);
			head = head.next;
			len++;
		}
		if( k > len || k <= 0) {
			return null;
		}else {
			return map.get(len - k);
		}
	}
	//方法二
	public ListNode findKthToTail2(ListNode head,int k) {
		ListNode p1 = head;
		ListNode p2 = head;
		if (head == null || k <= 0) {
			return null;
		}
		for (int i = 1; i < k; i++) {
			if(p1.next != null) {
				p1 = p1.next;
			} else {
				return null;
			}
		}
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
}
