package sendrovitz.scheduler;

import java.util.List;

public class FIFO implements SchedulerAlgorithm {
	private boolean preemptive;
	public FIFO(){
		this.preemptive = false;
	}
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return list.get(0);
	}
	public boolean isPreemptive(){
		return preemptive;
	}

}
