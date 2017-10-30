package fil.coo.Actions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fil.coo.Resource.Cubicle;
import fil.coo.Resource.MockResourcePool;
import fil.coo.Resource.ResourcePool;
import fil.coo.Resource.ResourceUser;

public class TakeResourceActionTest {
	
	protected TakeResourceAction<Cubicle> takeResourceAction;
	

	@Before
	public void BeforeTest() throws Exception{
		
		ResourcePool<Cubicle> cub = new MockResourcePool(3);
		
		ResourceUser<Cubicle> user= new ResourceUser<Cubicle>(); 
		
		takeResourceAction= new TakeResourceAction<Cubicle>(cub,user,"test");

		
	}
	

	@After
	public void afterTest() throws Exception {
		takeResourceAction = null;
	}
	
	@Test
	public void isReadyTest() {
		assertTrue(takeResourceAction.state==ActionState.READY);
		assertFalse(takeResourceAction.state==ActionState.INPROGRESS);
		assertFalse(takeResourceAction.isFinished());
	}

	@Test
	public void isFinishedTest() {
		takeResourceAction.realStep();
		assertFalse(takeResourceAction.state==ActionState.READY);
		assertTrue(takeResourceAction.isFinished());
		assertFalse(takeResourceAction.state==ActionState.INPROGRESS);
	}
	

	@Test
	public void realStepTest() {
		assertTrue(takeResourceAction.state==ActionState.READY);
		assertFalse(takeResourceAction.state==ActionState.INPROGRESS);
		assertFalse(takeResourceAction.isFinished());
		
		takeResourceAction.realStep();

		assertFalse(takeResourceAction.state==ActionState.READY);
		assertTrue(takeResourceAction.isFinished());
		assertFalse(takeResourceAction.state==ActionState.INPROGRESS);
	}
	
}
