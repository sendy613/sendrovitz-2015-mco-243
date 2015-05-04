package sendrovitz.philosophers;

import java.util.Random;

public class Philosopher extends Thread {

	private static final Random rand = new Random();
	private String name;
	private Fork forkA;
	private Fork forkB;

	public Philosopher(Fork a, Fork b, String name) {

		forkA = a;
		forkB = b;
		this.name = name;

	}

	public void run() {

		while (true) {
			eat();
			think();
		}

	}

	private void eat() {

		synchronized (forkA) {
			synchronized (forkB) {

				System.out.println(name + " is eating");

				try {
					Thread.sleep(rand.nextInt(1500) + 500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	private void think() {

		System.out.println(name + " is thinking");

		try {
			Thread.sleep(rand.nextInt(1500) + 500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
