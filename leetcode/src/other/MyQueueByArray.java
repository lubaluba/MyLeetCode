package other;
/**
 * 	用数组实现一个队列(这里为了表示简便就用int了)
 * 
 * 	思路:这里使用到了两个整数head和tail,head代表头部即插入位置。
 * 	tail表示插入位置,当入列时,如果size > 数组长度时, 扩容数组。注意扩容时要调整数组元素位置以及head和tail
 * 	当tail数组长度时,就往后插入,直到碰到数组的尽头,此时因为size小于数组长,说明前面有元素出列,所以就将tail置零开始
 *
 */
public class MyQueueByArray {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int[] elements;
	
	private int size = 0;
	
	private int tail = 0;
	private int head = 0;
	
	MyQueueByArray(int capacity) {
		elements = new int[capacity];
	}
	MyQueueByArray() {
		this(DEFAULT_CAPACITY);
	}
	public void enqueue(int val) {
		if(size == elements.length) {
			reSize();
		}
		if(tail >= elements.length) {
			tail = 0;
		}
		size++;
		elements[tail++] = val;
	}

	public int dequeue() {
		if(size == 0) {
			throw new RuntimeException("队列为空");
		}
		if(head == elements.length) {
			head = 0;
		}
		size--;
		return elements[head++];
	}

	private void reSize() {
		int[] newArray = new int[elements.length*2];
		for(int i = 0; i < size; i++) {
			newArray[i] = elements[(i+head)%size];
		}
		elements = newArray;
		head = 0;
		tail = size;
		
	}
}
