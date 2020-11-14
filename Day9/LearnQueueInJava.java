package day9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author amjain
 *
 */
public class LearnQueueInJava {
	public static void printQueye(Queue<Integer> queue) {
		for(Integer ele:queue) {
			System.out.print(ele);
		}
		System.out.println("");
	}
	
	public static void removeWhileIterating(Queue<Integer> queue) {
		Iterator iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
//			System.out.println(queue.poll());
		}
		
		iterator = queue.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
//			System.out.println(queue.poll());
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> quess = new LinkedList<>();
		quess.add(1);
		quess.add(2);
		quess.add(3);
		quess.add(4);
		printQueye(quess);
		
		System.out.println("peek : "+quess.peek());
		System.out.println("peek : "+quess.peek());
		printQueye(quess);
		
//		System.out.println("poll : "+quess.poll());
//		printQueye(quess);
//		
//		System.out.println("remove : "+quess.remove());
//		printQueye(quess);
		
		removeWhileIterating(quess);
		printQueye(quess);
		
		if(quess.isEmpty()) {
			System.out.println("empty");
		}
	}
	
}
