package nav.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown(); // will shutdown after all threads complete executing
		
		System.out.println("All tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
		
	}

}

class Processor implements Runnable {
	private int id;	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting: " + id);		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {			
		}
		System.out.println("Completed: " + id);
	}	
}
