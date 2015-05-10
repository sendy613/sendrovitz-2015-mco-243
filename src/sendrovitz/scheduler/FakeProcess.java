package sendrovitz.scheduler;

public class FakeProcess {
	private int priority;
	private int timeToCompletion;
	private int round;
	
	public FakeProcess(int priority, int timeToCompletion){
		this.priority = priority;
		this.timeToCompletion = timeToCompletion;
		this.round = 0;
	}
	public void run(int time){
		timeToCompletion-=time;
	}
	public boolean isStillRunning(){
		if(timeToCompletion<=0){
			return false;
		}
		return true;
	}
	public int getTimeToCompletion(){
		return timeToCompletion;
	}
	public int getPriority(){
		return priority;
	}
	public void setRound(int i) {
		round = i;
		
	}
	public int getRound() {
		return round;
	}
	public void increasePriority(){
		priority++;
	}
}
