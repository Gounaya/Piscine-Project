package fil.coo.Actions;

import java.util.ArrayList;

import fil.coo.Exceptions.ActionFinishedException;
import fil.coo.Exceptions.SchedulerStartedException;

/**
 * Scheduler is an action that has a set of actions
 * these sub-actions can also be scheduler too 
 * A Scheduler is finished when all sub-schedulers are finished
 * @author gounaya
 *
 */
public abstract class Scheduler extends Action{
	
	protected int currentIndex;
	protected ArrayList<Action> ActionList;
	/**
	 * Create empty scheduler list of action
	 */
	public Scheduler() {
		 ActionList = new ArrayList<Action>();
	}
	
	public abstract int nextAction();
	/**
	 * With this method we can add a new sub-action
	 * @param action
	 * @throws ActionFinishedException
	 * @throws SchedulerStartedException
	 */
	public void addAction(Action action) throws ActionFinishedException, SchedulerStartedException {
		if (this.getState() != ActionState.READY) 
			throw new SchedulerStartedException("Scheduler Already Started") ;
		if (action.isFinished()) 
			throw new ActionFinishedException() ;
		this.ActionList.add(action);
	}
	

	/**
	 * Each call of doStep(), advance one of his actions in one step
	 * 
	 */
	public void realStep() {		
		
		Action action = this.ActionList.get(this.nextAction()) ;
		System.out.print(action);
		try {
			action.doStep();
			
		} catch (ActionFinishedException e) {
			// cannot happen since there is no finished action in a scheduler
		}
		if (action.isFinished()) { 
			this.ActionList.remove(action);
			this.currentIndex=this.currentIndex-1;
			if(this.currentIndex==-1) {
				this.currentIndex= this.ActionList.size();
			}
		}
	}
	
	public ArrayList<Action> getActionList() {
		return ActionList;
	}
	
	/**
	 * @return true if the scheduler list of action is empty
	 */
	public boolean StopCondition() {
		return this.ActionList.isEmpty();
	}
}

