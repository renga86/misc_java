package basicdatastructures;

public class ArrayQueue {

	private int[] inpArr;
	private int front, rear;
	private static final int CAPACITY = 100;
	
	ArrayQueue() {
		inpArr = new int[CAPACITY];
		front = rear = -1;
	}
	
	void Enqueue(int elem) {
		if ((rear + 1) % CAPACITY == front) {
			return;
		} else if (isEmpty()) {
			front = rear = 0;
			inpArr[rear] = elem;
		} else {
			rear = (rear + 1) % CAPACITY;
		}
		inpArr[rear] = elem;
	}
	
	void dequeue() {
		if (isEmpty()) {
			return;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front = (front + 1) % CAPACITY;
		}
	}
	
	boolean isEmpty() {
		if (front == -1 && rear == -1) {
			return true;
		} else {
			return false;
		}
	}
}