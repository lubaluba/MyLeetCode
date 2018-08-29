package codinginterviews;

import java.util.Stack;

/**
 *	用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *	栈先入后出,队列先入先出。
 *	1,当我们向队列添加元素时,压入栈1。
 *	2,出列时,先将元素全部压入栈2,这样就可以保证栈2内的元素是栈1的反序,这样就就可以先进先出
 *	3,再添加元素时,如果栈2不为空,要先将栈2元素压入栈1,这样就能保证之前添加的元素在栈1里面继续顺序排列,这样新入栈的元素才能保证顺序
 *	4,重复步骤2,3
 */
public class TwoStackQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}

        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	
    	return stack2.pop();
    }
}
