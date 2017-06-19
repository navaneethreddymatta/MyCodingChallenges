package nav.multiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<20; i++) {
			executor.submit(new ThrProcessor(latch,i));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed..");
	}
}

class ThrProcessor implements Runnable {
	private CountDownLatch latch;
	private int counter = 0;
	
	public ThrProcessor(CountDownLatch latch, int i) {
		this.latch = latch;
		this.counter = i;
	}
	
	@Override
	public void run() {
		System.out.println("Started...." + counter);		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Before -- " + latch.getCount());
		latch.countDown();
		System.out.println("After -- " + latch.getCount());
	}
	
}
