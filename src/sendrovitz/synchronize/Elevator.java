package sendrovitz.synchronize;

public class Elevator {
private int currentFloor;
private int requestedFloor;


public boolean isInUse(){
	return requestedFloor>0;
}
public void setrequestedFloor(int floor){
	synchronized(this){
	if(isInUse()){
		return;
	}
	this.requestedFloor =floor;
}
}

}
