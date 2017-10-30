package fil.coo.Actions;


/**
 * Foreseeable action - It's an action that we already know the invocation number of the doStep()
 * 
 * @author gounaya
 *
 */
public class foreseeableAction extends Action{
	private int totalTime;
	private int waitingTime;
	private String nameOfAction;
	
	/**
	 * Create an action with time known time
	 * @param waiting : time for the action to end (finished)
	 * @param nameOfAction : it's name of action
	 */
	public foreseeableAction(int waiting, String nameOfAction) {
		this.totalTime=waiting;
		this.waitingTime = waiting;
		this.nameOfAction= nameOfAction;
	}
	/**
	 * At each call of realStep(), the waitingTime diminished
	 * 
	 */
	public void realStep(){
		this.waitingTime--;
		
	}
	/**
	 * @return true if waitingTime is null so there is no step to do or else 
	 *
	 */
    protected boolean StopCondition() {
        return this.waitingTime == 0;
    }
    
    public String toString() {
    	return nameOfAction+" "+"("+(totalTime+1-waitingTime)+"/"+totalTime+") \n\n";
    }
}

