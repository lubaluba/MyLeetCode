package other;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序,序列4,5,3,2,1是该压栈序列对应的一个弹出序列,
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。(注意：这两个序列的长度是相等的)
 * 
 * 思路：用一个栈来实现。将push数组元素入栈,每次入栈后比较是否和pop数组元素相同,相同就出栈。
 * 	如果能够遍历成功,说明出栈方式可行
 *  */
public class IsPopOrder {
	public boolean isPopOrder(int [] pushA,int [] popA) {
	    if (pushA.length != popA.length || pushA.length == 0) {
	    	return false;
	    }
		Stack<Integer> stack = new Stack<>();
		int i = 1;
		int j = 0;
		stack.push(pushA[0]);
		while (i < pushA.length) {
			if (stack.peek() != popA[j]) {
				stack.push(pushA[i++]);
			} else {
				stack.pop();
				j++;
			}
		}
		while (!stack.empty()) {
			if(stack.pop() != popA[j++]) {
				return false;
			}
		}
		return true;
    }
}
