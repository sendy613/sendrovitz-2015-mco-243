package sendrovitz.philosophers;

public class DiningPhilosophers {

	public static void main(String args[]){
		
		Fork one = new Fork();
		Fork two = new Fork();
		Fork three = new Fork();
		Fork four = new Fork();
		Fork five = new Fork();
		
		Philosopher a = new Philosopher(one, two, "A");
		Philosopher b = new Philosopher(two, three, "B");
		Philosopher c = new Philosopher(three, four, "C");
		Philosopher d = new Philosopher(four, five, "D");
		Philosopher e = new Philosopher(five, one, "E");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		
	}
}
