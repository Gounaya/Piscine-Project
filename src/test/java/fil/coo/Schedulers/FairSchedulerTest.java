package fil.coo.Schedulers;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Actions.FairScheduler;
import fil.coo.Actions.Scheduler;

public class FairSchedulerTest extends SchedulerTest{

	
	protected Scheduler createScheduler() {
		return new FairScheduler() ;
	}
	
	@Test
	public void fairSchedulerTest() {
		
		Scheduler scheduler = this.createScheduler() ;
		
		for (int i = 0 ; i < 2 ; i++){
			scheduler.addAction(new MockStepAction()) ;
		}
		
		for (int i = 0 ; i < 2 ; i++){
			scheduler.doStep() ; 
		}
		
		assertEquals(scheduler.getActionList().size(), 2) ;
	
	}

}
