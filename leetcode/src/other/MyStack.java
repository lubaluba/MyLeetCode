 package other;

import java.util.Stack;

/**
 * 定义栈的数据结构,请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 *	思路：定义一个辅助栈,如果此时入栈元素小于辅助栈顶元素就同时入辅助栈
 *	出栈的时候就判断是否和辅助栈顶元素相同,相同出栈
 *	这样辅助栈顶保存的就是最小值
 */
public class MyStack {
	int size= 0;
	int[] items = new int[8];
	Stack<Integer> min = new Stack<>(); 
	public void push(int node) {
		if (size == items.length) {
			resize();
		}
		if(size==0) {
			min.push(node);
		}
		if(node<min.peek()) {
			min.push(node);
		}
		items[size++] = node;
	}    
	private void resize() {
		int[] newItems = new int[items.length*2];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
		
	}
	public void pop() {
		if(items[size-1]==min.peek()) {
			min.pop();
		}
		size--;
	}
	    
	public int top() {
		if(items[size-1]==min.peek()) {
			min.pop();
		}
		return items[--size];
	}
	    
	public int min() {
		return min.peek();
	        
	}
	public int findMin() {
		int min = items[0];
		for(int i =0; i<size-1; i++) {
			if(items[i] < min ) {
				min = items[i];
			}
		}
		return min;
	}

}
