package other;

/**
 *	输入一个复杂链表（每个节点中有节点值,以及两个指针,一个指向下一个节点,另一个特殊指针指向任意一个节点）
 *	返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 *	思路:该题如果之间遍历复制,从next节点到random节点,这样的话时间复杂度为O(n^2)
 *	要将时间复杂度降低到o(n),采取的方式是,第一遍遍历复制主链表,即next部分,不管random
 *	但是注意这个复制不是创建一个新的链表,而是将复制后的节点之间插入到链表中
 *	第二步,再次遍历,此次插入random节点,因为我们刚才把复制的节点直接插入到原链表节点后面,
 *	那么很显然,random是指向链表的某一个节点,我们只需要将复制的random指向该节点的后面一个节点,
 *	因为原节点与复制节点是紧紧相连的,这就是为什么要把复制节点放在原链表了,这样就不用遍历random节点复制了
 *	最后一步,从原链表中拆下复制后的节点;
 */
public class CloneLinkedList {
	public RandomListNode clone(RandomListNode pHead) {
		if (pHead == null) {
			return null;
		}
		RandomListNode node = pHead;
		//复制旧链表并插入新链表中
		while (node != null) {
			RandomListNode copyNext = new RandomListNode(node.label);
			copyNext.next = node.next;
			node.next = copyNext;
			node = copyNext.next;
		}
		node = pHead;
		//复制random节点
		while (node != null) {
			if (node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		//从原链表中拆下复制后的链表,注意要把原来的链表复原,要完整的拆下来
		RandomListNode copyHead = pHead.next;
		RandomListNode copy = copyHead;
		node = pHead;
		while (node != null) {
			node.next = node.next.next;
			if (copy.next != null) {
				copy.next = copy.next.next;
			}
			copy = copy.next;
			node = node.next;
		}
		return copyHead;
	}
}

class RandomListNode {
	
	int label;
	RandomListNode next = null;
	RandomListNode random = null;
	
	RandomListNode(int label) {
        this.label = label;
    }
}