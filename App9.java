import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class App9 {

	public static void main(String args[]) {
		Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(3);
		
		q1.add(10);
		q1.add(20);
		q1.add(30);
		try {
			q1.add(40);
		} catch (IllegalStateException exp) {
			System.out.println(" Only 3 elements allowed ");
		}
		
		for(Integer val:q1) {
			System.out.println("Queue value: " + val);
		}
		
		q1.remove();
		
		for(Integer val:q1) {
			System.out.println("Queue value: " + val);
		}
		
		System.out.println(q1.element());
		
		
		Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(2);
		q2.offer(10);
		q2.offer(20);
		q2.offer(30);
		
		for(Integer val:q2) {
			System.out.println("Queue value: " + val);
		}
	}
}