package fil.coo.Actions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fil.coo.Exceptions.ActionFinishedException;

public abstract class ActionTest {
	
	protected abstract Action createAction();
	Action action ;
	
	@Before 
	public void init() {
		action = this.createAction();
	}
	
	@Test 
	public void isReadyTest() {
		assertTrue(action.getState() == ActionState.READY);
	}
	
	
	@Test 
	public void isFinishedTest() throws ActionFinishedException {
		while(!action.StopCondition()) {
			action.doStep();
		}
		assertTrue(action.getState() == ActionState.FINISHED);
	}
	
	@Test (expected = ActionFinishedException.class, timeout=1000)
	public void doStepException() throws ActionFinishedException{
		Action action = this.createAction();
		while(!action.isFinished()) {
			action.doStep();
		}
		action.doStep();
	}

	
	
}
