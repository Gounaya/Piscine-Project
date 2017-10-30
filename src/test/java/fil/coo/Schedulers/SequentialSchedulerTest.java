package fil.coo.Schedulers;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Actions.Scheduler;
import fil.coo.Actions.SequentialScheduler;

public class SequentialSchedulerTest extends SchedulerTest {

	@Override
	protected Scheduler createScheduler() {
		return new SequentialScheduler() ;
	}
	
	@Test
	public void sequentialSchedulerTest() {
		Scheduler scheduler = this.createScheduler() ;
		for (int i = 0 ; i < 2 ; i++) scheduler.addAction(new MockStepAction()) ;
		for (int i = 0 ; i < 2 ; i++)  scheduler.doStep() ; 
		assertEquals(scheduler.getActionList().size(), 1) ;
	}


}

