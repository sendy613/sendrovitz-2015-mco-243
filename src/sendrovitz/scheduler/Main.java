package sendrovitz.scheduler;



public class Main {
	public static void main(String args[]) {
		Main main = new Main();
		System.out.println("FIFO: \n");
		Scheduler fifo = new Scheduler(new FIFO());
		main.setList(fifo);
		
		System.out.println(System.currentTimeMillis());
		fifo.run();
		System.out.println(System.currentTimeMillis() + "\n");

		
		System.out.println("SPF: \n");
		Scheduler spf = new Scheduler(new SPF());
		main.setList(spf);
	

		System.out.println(System.currentTimeMillis());
		spf.run();
		System.out.println(System.currentTimeMillis() + "\n");
		
		
		System.out.println("Priority: \n");
		Scheduler priority = new Scheduler(new Priority());
		main.setList(priority);
		
		System.out.println(System.currentTimeMillis());
		priority.run();
		System.out.println(System.currentTimeMillis() + "\n");

	}

	public void setList(Scheduler s) {
		int priority = 10;
		int timeToCompletion = 1;
		for (int i = 0; i < 100; i++) {
			if(priority==0){
				priority =10;
			}
			if(timeToCompletion==65){
				timeToCompletion =0;
			}
			FakeProcess p = new FakeProcess(priority--, timeToCompletion++);
			s.addProcess(p);
			
		}
	}
}



/*//FIFO: 

1430706627678
1430706627679

SPF:

1430706627680
1430706627695

Priority:

1430706627696
1430706627718*/
