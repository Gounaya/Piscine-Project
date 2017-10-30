package fil.coo.Actions;

import fil.coo.Exceptions.ActionFinishedException;
/**
 * Action - It's an object that progresses from initial state READY to final state by calling successively his doStep() method
 * @author gounaya & errami
 *
 */
public abstract class Action {
	
	protected ActionState state;
	
	/**
	 * An action is in READY stat
	 */
	public Action() {
		this.state= ActionState.READY;
	}
	/**
	 * It's methode that progresses the state of an action
	 * 
	 * @throws ActionFinishedException if the state of the action is finished, then the action can not progress
	 */
	public void doStep() throws ActionFinishedException{
		if(this.isFinished()) {
		    throw new ActionFinishedException();
	    }
		this.state= ActionState.INPROGRESS;
	    this.realStep();
	    if (this.StopCondition()) {
	    	this.state = ActionState.FINISHED;
	    }
	    
	}
	protected abstract void realStep();
	protected abstract boolean StopCondition();
	
	/**
	 * @return true if the action is finished or else
	 */
	public boolean isFinished() {
		return this.state == ActionState.FINISHED;
	}
	
	/**
	 * getState() : Action state getter.
	 * @return the state of the Action
	 */
	
	public ActionState getState(){
		return this.state;
		
	}
	
	
}

