package sendrovitz.processes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadIncrement extends Thread {
	// doesnt need to be static bec youre passing in the same instance every
	// time you create a thread
	private AtomicInteger integer;
	private CountDownLatch latch;

	public ThreadIncrement(AtomicInteger integer, CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			// while one thread is inside not other thread can be in there
			integer.incrementAndGet();

		}
		latch.countDown();
	}

	public static void main(String args[]) {
		AtomicInteger integer = new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			new ThreadIncrement(integer, latch).start();
		}
		try {
			// waits until all threads end before it prints
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(integer);
	}
}