package nav.multiThreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) {
		
		List<Integer> sharedList = new ArrayList<Integer>();		
		Thread t1 = new Thread(new Producer(sharedList));
		Thread t2 = new Thread(new Consumer(sharedList));
		
		t1.start();
		t2.start();
		
	}
}	

class Producer implements Runnable {
	
	List<Integer> sharedList = null;
	final int MAX_SIZE = 5;
	private int i = 0;
	
	public Producer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while(true) {
			try {
				produce(i++);
			} catch(InterruptedException exception) {
				
			}
		}
	}
	
	public void produce(int i) throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.size() == MAX_SIZE) {
				System.out.println("SharedList is full.... Waiting for the consumer to consume");
				sharedList.wait();
			}			
		//}		
		//synchronized (sharedList) {
			System.out.println("Producer produced the element " + i);
			sharedList.add(i);
			Thread.sleep(1000);
			sharedList.notify();
		}
	}
	
}
	
class Consumer implements Runnable {
	
	List<Integer> sharedList = null;
	
	public Consumer(List<Integer> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch(InterruptedException exception) {
				
			}
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.isEmpty()) {
				System.out.println("SharedList is empty.... Waiting for the producer to produce");
				sharedList.wait();
			}			
		//}		
		//synchronized (sharedList) {
			Thread.sleep(2000);
			System.out.println("Consumed the element: " + sharedList.remove(0));
			sharedList.notify();
		}
	}
	
}


