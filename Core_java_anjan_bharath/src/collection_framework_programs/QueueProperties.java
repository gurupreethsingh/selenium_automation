package collection_framework_programs;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueProperties {

	public static void main(String[] args) 
	{
		// Queue - it will not allow null values. 
		// queues are partially sorted. 
		// size is dynamic
		// you can store heterogienous data 
		// store duplicates
		
		// LinkedList, PriorityQueue
		
		Queue q = new PriorityQueue(); 
		
		q.add(10);
		q.add(5);
		q.add(3); 
		q.add(8); 
		q.add(3); 
		
		System.out.println(q);

	}

}
