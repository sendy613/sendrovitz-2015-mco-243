package sendrovitz.scheduler;

import java.util.List;

public class Priority implements SchedulerAlgorithm {
	private boolean preemptive;
	public Priority(){
		this.preemptive = true;
	}
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		FakeProcess process = list.get(0);
		for(FakeProcess p : list){
			if(p.getPriority()>process.getPriority()){
				process = p;
			}
		}
		
		return process;
	}

	@Override
	public boolean isPreemptive() {
		return preemptive;
	}

}
