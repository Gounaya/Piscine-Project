package fil.coo.Schedulers;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Actions.Action;
import fil.coo.Actions.Scheduler;
import fil.coo.Exceptions.ActionFinishedException;
import fil.coo.Exceptions.SchedulerStartedException;

public abstract class SchedulerTest {
	
	protected abstract Scheduler createScheduler();
	
	
	@Test
	public void addActionTest() {
		Scheduler scheduler = this.createScheduler();
		
		assertEquals(scheduler.getActionList().size(), 0);
		
		scheduler.addAction(new MockStepAction());
		
		assertEquals(scheduler.getActionList().size(), 1);
	}
		
	@Test(expected = ActionFinishedException.class)
	public void addFinishedActionTest() {
		
		Scheduler scheduler = this.createScheduler();
		
		Action action = new MockStepAction();
		
		action.doStep(); 
		action.doStep();
		
		scheduler.addAction(action);
	}
	
	@Test(expected = SchedulerStartedException.class)
	public void SchedulerStartedExceptionTest() {
	
		Scheduler scheduler = this.createScheduler() ;
		
		scheduler.addAction(new MockStepAction()) ;
		
		scheduler.doStep() ;
	
		scheduler.addAction(new MockStepAction()) ;
	
	}

}
