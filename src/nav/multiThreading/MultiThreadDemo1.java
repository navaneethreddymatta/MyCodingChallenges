package nav.multiThreading;
public class MultiThreadDemo1 {
	public static void main(String[] args) {
		// Using Thread
		Runner runner1 = new Runner();
		//runner1.start();
		
		// Using Runnable
		Thread t1 = new Thread(new RunnerInt());
		//t1.start();
		//RunnerInt r1 = new RunnerInt();
		//r1.run();
		
		// Using Anonymous class
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10; i++) {
					System.out.println("Hello " + i + " from anonymous class");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		//t2.start();
		
		// Not Synchronized
		UnSynchronizedDemo usd = new UnSynchronizedDemo();
		usd.doWork();
		
		// Synchronized
		SynchronizedDemoCls sd = new SynchronizedDemoCls();
		sd.doWork();
	}
}

class RunnerInt implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello " + i + " from Runnable Interface");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Runner extends Thread {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello " + i + " from Thread class");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class UnSynchronizedDemo {
	private int count = 0;
	public void doWork() {
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++) {
					count++;
				}
			}
			
		});
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++) {
					count++;
				}
			}
			
		});
		t3.start();
		t4.start();
		System.out.println("Value of count before join: " + count); 
		// Displays a small number as it might have incremented few times before displaying
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Value of count after join: " + count);
		// Displays a number < 20000 and sometimes 20000 as the increment might be done at same tiume in both threads
	}
}

class SynchronizedDemoCls {
	private int count = 0;
	public void doWork() {
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++) {
					increment();
				}
			}
			
		});
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 0; i < 10000; i++) {
					increment();
				}
			}
			
		});
		t3.start();
		t4.start();
		System.out.println("Value of count before join: " + count); 
		// Displays 0
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Value of count after join: " + count);
		// Displays 20000 as the function increment can be executed over one thread at a time
	}
	
	public synchronized void increment() {
		count++;
	}
}