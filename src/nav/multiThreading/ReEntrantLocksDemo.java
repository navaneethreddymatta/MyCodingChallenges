package nav.multiThreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLocksDemo {
	
	public static void main(String[] args) throws Exception{		
		final ReEntrantRunner runner = new ReEntrantRunner();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try{
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try{
					runner.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		runner.finished();
	}
}

class ReEntrantRunner{
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for(int i = 0; i < 10000; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		lock.lock();
		
		System.out.println("Waiting....");
		//Thread.sleep(5000);
		cond.await();
		
		System.out.println("Woken up!");
		
		try{
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void secondThread() throws InterruptedException {
		//Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the return key!");
		new Scanner(System.in).nextLine(); 
		System.out.println("Got return key!");
		
		cond.signal();
		
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}
	
	public void finished() {
		System.out.println("Count is: " + count);
	} 

}
