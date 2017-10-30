package fil.coo.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.Actions.Action;
import fil.coo.Actions.foreseeableAction;
import fil.coo.Exceptions.ActionFinishedException;

public class ForeseeableActionTest extends ActionTest{

	
	protected Action createAction() {
		return new foreseeableAction(5, null) ;
	}
	
	@Test
	public void ForeseeableActionTestIsOK() throws ActionFinishedException {
		int nSteps = 15 ;
		
		Action action = new foreseeableAction(nSteps,null) ;
		
		for (int i = 0 ; i < nSteps ; i++){
			action.doStep() ;
		}
		
		assertTrue(action.isFinished()) ;
	}

}
