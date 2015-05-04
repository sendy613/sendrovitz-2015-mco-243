package sendrovitz.scheduler;

import java.util.List;

public class SPF implements SchedulerAlgorithm {
	private boolean preemptive;
	
	public SPF(){
		this.preemptive = false;
	}
	
	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		FakeProcess shortest = list.get(0);
		for(FakeProcess p : list){
			if(p.getTimeToCompletion()<= shortest.getTimeToCompletion()){
				shortest = p;
			}
		}
		return shortest;
	}

	@Override
	public boolean isPreemptive() {
		return preemptive;
	}

}
