package other;

import java.util.ArrayList;
import java.util.Stack;

/**
 *	输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *	首先想到的就是利用栈的先进后出
 *	还可以利用递归来做,虽然递归本质还是利用了栈的思想,但是省略了很多代码。
 */
public class PrintListFromTailToHead {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
        
    }
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		if(listNode != null) {
			this.printListFromTailToHead2(listNode);
			list.add(listNode.val);
		}
		return list;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
