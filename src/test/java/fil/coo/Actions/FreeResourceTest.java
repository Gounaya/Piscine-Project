package fil.coo.Actions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fil.coo.Resource.Cubicle;
import fil.coo.Resource.MockResourcePool;
import fil.coo.Resource.ResourcePool;
import fil.coo.Resource.ResourceUser;

public class FreeResourceTest {

	
protected FreeResourceAction<Cubicle> freeResourceAction;
	

	@Before
	public void BeforeTest() throws Exception{
		
		ResourcePool<Cubicle> resources = new MockResourcePool(3);
		
		resources.provideResource();

		ResourceUser<Cubicle> user= new ResourceUser<Cubicle>(); 
		
		freeResourceAction= new FreeResourceAction<Cubicle>(resources,user,"test");

		
	}
	

	@After
	public void afterTest() throws Exception {
	      freeResourceAction = null;
	}

	
	@Test
	public void testFreeResource() {
		
		freeResourceAction.realStep();;
		assertTrue(freeResourceAction.isFinished());

	}
}
