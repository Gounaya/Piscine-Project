package fil.coo.Resource;

import static org.junit.Assert.*;

import org.junit.Test;
import fil.coo.Exceptions.NoSuchElementException;
import fil.coo.Resource.Cubicle;
import fil.coo.Resource.ResourcePool;
/**
 * 
 * @author errami & gounaya
 *
 */
public class ResourcePoolTest {

	/**
	 * ResourcePoolFirstTest basic test that verify if the resourcePool is created
	 */
	@Test
	public void ResourcePoolFirstTest() {
		
		ResourcePool<Cubicle> resources = new MockResourcePool(1);
	
		assertEquals(resources.getFreeResources().size(),1);
	
	}
	
	
	@Test
	public void recoverResourceTest() {
		
		ResourcePool<Cubicle> resources = new MockResourcePool(1);

		Cubicle r = resources.provideResource();
		
		assertNotNull(r);
		
		assertTrue(resources.getBusyResources().size() == 1);
		
		resources.recoverResource(r);
		
		assertTrue(resources.getBusyResources().size() == 0);

	}
	
	@Test
	public void ProvideResourceTest() {
		
		ResourcePool<Cubicle> resource = new MockResourcePool(3);
		
		Cubicle r = resource.provideResource();
		
		assertNotNull(r);
	}
	

	
	@Test (expected=NoSuchElementException.class)
	public void provideResourceWhenNoSuchElementException(){
		
		MockResourcePool resources =new MockResourcePool(0);
	
		resources.provideResource();
	
	}
	
}
