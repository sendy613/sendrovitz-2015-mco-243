package sendrovitz.scheduler;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private static final int QUANTUM = 10;
	private List<FakeProcess> list;
	private SchedulerAlgorithm algorithm;

	public Scheduler(SchedulerAlgorithm algorithm) {
		// can make a bunch of instances of an algorithm and scheduler can take
		// different algorithms at different times.
		// the logic behind the scheduling can be in the instances' class
		list = new ArrayList<FakeProcess>();
		this.algorithm = algorithm;

	}

	public void run() {
		while (!list.isEmpty()) {
			FakeProcess process = algorithm.getNextProcess(list);
			list.remove(process);

			if (algorithm.isPreemptive() == false) {
				process.run(process.getTimeToCompletion());
			} else {
				process.run(QUANTUM);

				if (process.isStillRunning()) {
					addProcess(process);
				}
			}
		}
	}

	public void addProcess(FakeProcess process) {
		list.add(process);
	}

	public int getNumProcesses() {
		return list.size();
	}
}
