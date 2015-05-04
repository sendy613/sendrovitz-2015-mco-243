package sendrovitz.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {

	FakeProcess getNextProcess(List<FakeProcess> list);
	boolean isPreemptive();
}
